package com.consulting.rpd.protocols.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.consulting.rpd.protocols.domain.model.AlarmDeviceTest;
import com.consulting.rpd.protocols.domain.service.AlarmDeviceTestService;
import com.consulting.rpd.protocols.domain.persistance.AlarmDeviceTestRepository;
import com.consulting.rpd.protocols.domain.persistance.AlarmValveRepository;
import com.consulting.rpd.shared.exception.ResourceNotFoundException;
import com.consulting.rpd.shared.exception.ResourceValidationException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlarmDeviceTestServiceImpl implements AlarmDeviceTestService{
    private static final String ENTITY = "Alarm Device Test";

    private final AlarmDeviceTestRepository alarmDeviceTestRepository;
    private final AlarmValveRepository alarmValveRepository;
    private final Validator validator;

    @Override
    public AlarmDeviceTest getById(Long id) {
        return alarmDeviceTestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public AlarmDeviceTest create(Long alarmValveId, AlarmDeviceTest alarmDeviceTest) {
        Set<ConstraintViolation<AlarmDeviceTest>> violations = validator.validate(alarmDeviceTest);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return alarmValveRepository.findById(alarmValveId)
                .map(alarmValve -> {
                    alarmDeviceTest.setAlarmValve(alarmValve);
                    return alarmDeviceTestRepository.save(alarmDeviceTest);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Alarm Valve", alarmValveId));
    }
}
