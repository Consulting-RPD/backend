package com.consulting.rpd.protocols.service;

import com.consulting.rpd.protocols.domain.model.Documentation;
import com.consulting.rpd.protocols.domain.persistance.DocumentationRepository;
import com.consulting.rpd.protocols.domain.persistance.ProtocolHeaderRepository;
import com.consulting.rpd.protocols.domain.service.DocumentationService;
import com.consulting.rpd.shared.exception.ResourceNotFoundException;
import com.consulting.rpd.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class DocumentationServiceImpl implements DocumentationService {
    private static final String ENTITY = "Documentation";

    private final DocumentationRepository documentationRepository;
    private final ProtocolHeaderRepository protocolHeaderRepository;
    private final Validator validator;

    @Override
    public Documentation getById(Long id){
        return documentationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY,id));
    }

    @Override
    public Documentation create(Long protocolId, Documentation documentation) {
        Set<ConstraintViolation<Documentation>> violations = validator.validate(documentation);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY,violations);
        }

        return protocolHeaderRepository.findById(protocolId)
                .map(protocolHeader -> {
                    documentation.setProtocolHeader(protocolHeader);
                    return documentationRepository.save(documentation);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Protocol Header",protocolId));
    }
}
