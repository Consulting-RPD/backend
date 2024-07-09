package com.consulting.rpd.protocols.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.consulting.rpd.protocols.domain.model.AlarmValveData;
import com.consulting.rpd.protocols.domain.persistance.AlarmValveDataRepository;
import com.consulting.rpd.protocols.domain.persistance.AlarmValveRepository;
import com.consulting.rpd.protocols.domain.service.AlarmValveDataService;
import com.consulting.rpd.shared.exception.ResourceNotFoundException;
import com.consulting.rpd.shared.exception.ResourceValidationException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlarmValveDataServiceImpl implements AlarmValveDataService{
    private static final String ENTITY = "Alarm Valve Data";

    private final AlarmValveDataRepository alarmValveDataRepository;
    private final AlarmValveRepository alarmValveRepository;
    private final Validator validator;

    @Override
    public AlarmValveData getById(Long id) {
        return alarmValveDataRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public AlarmValveData create(Long alarmValveId, AlarmValveData alarmValveData) {
        Set<ConstraintViolation<AlarmValveData>> violations = validator.validate(alarmValveData);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return alarmValveRepository.findById(alarmValveId)
                .map(alarmValve -> {
                    alarmValveData.setAlarmValve(alarmValve);
                    return alarmValveDataRepository.save(alarmValveData);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Alarm Valve", alarmValveId));
    }
}
