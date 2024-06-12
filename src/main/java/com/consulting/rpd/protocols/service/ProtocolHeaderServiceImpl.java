package com.consulting.rpd.protocols.service;

import com.consulting.rpd.protocols.domain.model.ProtocolHeader;
import com.consulting.rpd.protocols.domain.persistance.ProtocolHeaderRepository;
import com.consulting.rpd.protocols.domain.service.ProtocolHeaderService;
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
public class ProtocolHeaderServiceImpl implements ProtocolHeaderService {
    private static final String ENTITY = "ProtocolHeader";
    private final ProtocolHeaderRepository protocolHeaderRepository;
    private final Validator validator;

    public ProtocolHeaderServiceImpl(ProtocolHeaderRepository protocolHeaderRepository, Validator validator) {
        this.protocolHeaderRepository = protocolHeaderRepository;
        this.validator = validator;
    }

    @Override
    public List<ProtocolHeader> getAll() {
        return protocolHeaderRepository.findAll();
    }

    @Override
    public Page<ProtocolHeader> getAll(Pageable pageable) {
        return protocolHeaderRepository.findAll(pageable);
    }

    @Override
    public ProtocolHeader getById(Long protocolId){
        return protocolHeaderRepository.findById(protocolId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, protocolId));
    }

    @Override
    public ProtocolHeader create(ProtocolHeader protocolHeader) {
        Set<ConstraintViolation<ProtocolHeader>> violations = validator.validate(protocolHeader);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        Optional<ProtocolHeader> protocolNumber = protocolHeaderRepository.findByProtocolNumber(protocolHeader.getProtocolNumber());
        if (protocolNumber.isPresent() && !protocolNumber.get().getId().equals(protocolHeader.getId())) {
            throw new ResourceValidationException(ENTITY, "A protocol header with the same number already exists");
        }

        return protocolHeaderRepository.save(protocolHeader);
    }

    @Override
    public ProtocolHeader update(Long protocolId, ProtocolHeader protocolHeader) {
        Set<ConstraintViolation<ProtocolHeader>> violations = validator.validate(protocolHeader);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        Optional<ProtocolHeader> protocolNumber = protocolHeaderRepository.findByProtocolNumber(protocolHeader.getProtocolNumber());
        if (protocolNumber.isPresent() && !protocolNumber.get().getId().equals(protocolHeader.getId())) {
            throw new ResourceValidationException(ENTITY, "A protocol with the same number already exists");
        }

        return protocolHeaderRepository.findById(protocolId)
                .map(protocolToUpdate -> protocolHeaderRepository.save(protocolToUpdate
                        .withProtocolNumber(protocolHeader.getProtocolNumber())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, protocolId));
    }

    @Override
    public ResponseEntity<?> delete(Long protocolId) {
        return protocolHeaderRepository.findById(protocolId)
                .map(protocolHeader -> {
                    protocolHeaderRepository.delete(protocolHeader);
                    return ResponseEntity.ok().build();
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, protocolId));
    }
}
