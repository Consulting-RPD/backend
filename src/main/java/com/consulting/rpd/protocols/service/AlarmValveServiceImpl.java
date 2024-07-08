package com.consulting.rpd.protocols.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.consulting.rpd.protocols.domain.model.AlarmValve;
import com.consulting.rpd.protocols.domain.persistance.AlarmValveRepository;
import com.consulting.rpd.protocols.domain.persistance.ProtocolHeaderRepository;
import com.consulting.rpd.protocols.domain.service.AlarmValveService;
import com.consulting.rpd.shared.exception.ResourceNotFoundException;
import com.consulting.rpd.shared.exception.ResourceValidationException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlarmValveServiceImpl implements AlarmValveService{
    private static final String ENTITY = "Alarm Valve";

    private final AlarmValveRepository alarmValveRepository;
    private final ProtocolHeaderRepository protocolHeaderRepository;
    private final Validator validator;

    @Override
    public AlarmValve getById(Long id) {
        return alarmValveRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public AlarmValve create(Long protocolId, AlarmValve alarmValve) {
        Set<ConstraintViolation<AlarmValve>> violations = validator.validate(alarmValve);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }
        
        return protocolHeaderRepository.findById(protocolId)
                .map(protocolHeader -> {
                    alarmValve.setProtocolHeader(protocolHeader);
                    return alarmValveRepository.save(alarmValve);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Protocol Header", protocolId));
    }
}
