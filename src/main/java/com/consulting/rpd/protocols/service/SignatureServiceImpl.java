package com.consulting.rpd.protocols.service;

import org.springframework.stereotype.Service;

import com.consulting.rpd.protocols.domain.model.Signature;
import com.consulting.rpd.protocols.domain.persistance.ProtocolHeaderRepository;
import com.consulting.rpd.protocols.domain.persistance.SignatureRepository;
import com.consulting.rpd.protocols.domain.service.Signatureservice;
import com.consulting.rpd.shared.exception.ResourceNotFoundException;
import com.consulting.rpd.shared.exception.ResourceValidationException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;

import java.util.Set;

@Service
@AllArgsConstructor
public class SignatureServiceImpl implements Signatureservice{
    private static final String ENTITY = "Signature";

    private final SignatureRepository signatureRepository;
    private final ProtocolHeaderRepository protocolHeaderRepository;
    private final Validator validator;

    @Override
    public Signature getById(Long id){
        return signatureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY,id));
    }

    @Override
    public Signature create(Long protocolId, Signature signature) {
        Set<ConstraintViolation<Signature>> violations = validator.validate(signature);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY,violations);
        }

        return protocolHeaderRepository.findById(protocolId)
                .map(protocolHeader -> {
                    signature.setProtocolHeader(protocolHeader);
                    return signatureRepository.save(signature);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Protocol Header",protocolId));
    }
}
