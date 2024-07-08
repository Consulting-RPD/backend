package com.consulting.rpd.protocols.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.consulting.rpd.protocols.domain.model.Sprinkler;
import com.consulting.rpd.protocols.domain.persistance.ProtocolHeaderRepository;
import com.consulting.rpd.protocols.domain.persistance.SprinklerRepository;
import com.consulting.rpd.protocols.domain.service.SprinklerService;
import com.consulting.rpd.shared.exception.ResourceNotFoundException;
import com.consulting.rpd.shared.exception.ResourceValidationException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SprinklerServiceImpl implements SprinklerService{
    private static final String ENTITY = "Sprinkler";

    private final SprinklerRepository sprinklerRepository;
    private final ProtocolHeaderRepository protocolHeaderRepository;
    private final Validator validator;

    @Override
    public Sprinkler getById(Long id){
        return sprinklerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY,id));
    }

    @Override
    public Sprinkler create(Long protocolId, Sprinkler sprinkler) {
        Set<ConstraintViolation<Sprinkler>> violations = validator.validate(sprinkler);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY,violations);
        }

        return protocolHeaderRepository.findById(protocolId)
                .map(protocolHeader -> {
                    sprinkler.setProtocolHeader(protocolHeader);
                    return sprinklerRepository.save(sprinkler);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Protocol Header",protocolId));
    }
}
