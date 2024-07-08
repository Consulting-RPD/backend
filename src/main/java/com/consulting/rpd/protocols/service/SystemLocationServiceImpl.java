package com.consulting.rpd.protocols.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.consulting.rpd.protocols.domain.model.SystemLocation;
import com.consulting.rpd.protocols.domain.persistance.ProtocolHeaderRepository;
import com.consulting.rpd.protocols.domain.persistance.SystemLocationRepository;
import com.consulting.rpd.protocols.domain.service.SystemLocationService;
import com.consulting.rpd.shared.exception.ResourceNotFoundException;
import com.consulting.rpd.shared.exception.ResourceValidationException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SystemLocationServiceImpl implements SystemLocationService{
    private static final String ENTITY = "System Location";

    private final SystemLocationRepository systemLocationRepository;
    private final ProtocolHeaderRepository protocolHeaderRepository;
    private final Validator validator;

    @Override
    public SystemLocation getById(Long id){
        return systemLocationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY,id));
    }

    @Override
    public SystemLocation create(Long protocolId, SystemLocation systemLocation) {
        Set<ConstraintViolation<SystemLocation>> violations = validator.validate(systemLocation);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY,violations);
        }

        return protocolHeaderRepository.findById(protocolId)
                .map(protocolHeader -> {
                    systemLocation.setProtocolHeader(protocolHeader);
                    return systemLocationRepository.save(systemLocation);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Protocol Header",protocolId));
    }
}
