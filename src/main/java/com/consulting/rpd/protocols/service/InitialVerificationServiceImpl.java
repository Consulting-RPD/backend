package com.consulting.rpd.protocols.service;

import org.springframework.stereotype.Service;
import com.consulting.rpd.protocols.domain.model.InitialVerification;
import com.consulting.rpd.protocols.domain.persistance.InitialVerificationRepository;
import com.consulting.rpd.protocols.domain.persistance.ProtocolHeaderRepository;
import com.consulting.rpd.protocols.domain.service.InitialVerificationService;
import com.consulting.rpd.shared.exception.ResourceNotFoundException;
import com.consulting.rpd.shared.exception.ResourceValidationException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;

import java.util.Set;

@Service
@AllArgsConstructor
public class InitialVerificationServiceImpl implements InitialVerificationService{
    private static final String ENTITY = "Initial Verification";

    private final InitialVerificationRepository initialVerificationRepository;
    private final ProtocolHeaderRepository protocolHeaderRepository;
    private Validator validator;

    @Override
    public InitialVerification getById(Long id){
        return initialVerificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY,id));
    }

    @Override
    public InitialVerification create(Long protocolId, InitialVerification initialVerification) {
        Set<ConstraintViolation<InitialVerification>> violations = validator.validate(initialVerification);
        
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY,violations);
        }

        return protocolHeaderRepository.findById(protocolId)
                .map(protocolHeader -> {
                    initialVerification.setProtocolHeader(protocolHeader);
                    return initialVerificationRepository.save(initialVerification);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Protocol Header",protocolId));
    }
}
