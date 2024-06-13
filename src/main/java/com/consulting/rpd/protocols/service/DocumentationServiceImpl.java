package com.consulting.rpd.protocols.service;

import com.consulting.rpd.protocols.domain.model.Documentation;
import com.consulting.rpd.protocols.domain.persistance.DocumentationRepository;
import com.consulting.rpd.protocols.domain.service.DocumentationService;
import com.consulting.rpd.shared.exception.ResourceNotFoundException;
import com.consulting.rpd.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DocumentationServiceImpl implements DocumentationService {
    private static final String ENTITY = "Documentation";
    private final DocumentationRepository documentationRepository;
    private final Validator validator;

    public DocumentationServiceImpl(DocumentationRepository documentationRepository, Validator validator) {
        this.documentationRepository = documentationRepository;
        this.validator = validator;
    }

    @Override
    public List<Documentation> getAll() {
        return documentationRepository.findAll();
    }

    @Override
    public Page<Documentation> getAll(Pageable pageable) {
        return documentationRepository.findAll(pageable);
    }

    @Override
    public Documentation getById(Long documentationId){
        return documentationRepository.findById(documentationId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, documentationId));
    }

    @Override
    public Documentation create(Documentation documentation) {
        Set<ConstraintViolation<Documentation>> violations = validator.validate(documentation);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return documentationRepository.save(documentation);
    }

    @Override
    public Documentation update(Long documentationId, Documentation documentation) {
        Set<ConstraintViolation<Documentation>> violations = validator.validate(documentation);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return documentationRepository.findById(documentationId)
                .map(documentationToUpdate -> documentationRepository.save(documentationToUpdate))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, documentationId));
    }

    @Override
    public ResponseEntity<?> delete(Long documentationId) {
        return documentationRepository.findById(documentationId)
                .map(documentation -> {
                    documentationRepository.delete(documentation);
                    return ResponseEntity.ok().build();
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, documentationId));
    }
}
