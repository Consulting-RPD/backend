package com.consulting.rpd.protocols.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.consulting.rpd.protocols.domain.model.PipeAndAccesories;
import com.consulting.rpd.protocols.domain.persistance.PipeAndAccesoriesRepository;
import com.consulting.rpd.protocols.domain.persistance.ProtocolHeaderRepository;
import com.consulting.rpd.protocols.domain.service.PipeAndAccesoriesService;
import com.consulting.rpd.shared.exception.ResourceNotFoundException;
import com.consulting.rpd.shared.exception.ResourceValidationException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PipeAndAccesoriesServiceImpl implements PipeAndAccesoriesService{
    private static final String ENTITY = "PipeAndAccesories";

    private final PipeAndAccesoriesRepository pipeAndAccesoriesRepository;
    private final ProtocolHeaderRepository protocolHeaderRepository;
    private final Validator validator;

    @Override
    public PipeAndAccesories getById(Long id) {
        return pipeAndAccesoriesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public PipeAndAccesories create(Long protocolId, PipeAndAccesories pipeAndAccesories) {
        Set<ConstraintViolation<PipeAndAccesories>> violations = validator.validate(pipeAndAccesories);
        
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return protocolHeaderRepository.findById(protocolId)
                .map(protocolHeader -> {
                    pipeAndAccesories.setProtocolHeader(protocolHeader);
                    return pipeAndAccesoriesRepository.save(pipeAndAccesories);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Protocol Header", protocolId));
    }
}
