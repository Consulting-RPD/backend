package com.consulting.rpd.protocols.service;

import com.consulting.rpd.projects.domain.persistance.ProjectRepository;
import com.consulting.rpd.protocols.domain.model.ProtocolHeader;
import com.consulting.rpd.protocols.domain.persistance.ProtocolHeaderRepository;
import com.consulting.rpd.protocols.domain.service.ProtocolHeaderService;
import com.consulting.rpd.shared.exception.ResourceNotFoundException;
import com.consulting.rpd.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProtocolHeaderServiceImpl implements ProtocolHeaderService {
    private static final String ENTITY = "ProtocolHeader";

    private final ProtocolHeaderRepository protocolHeaderRepository;
    private final ProjectRepository projectRepository;
    private final Validator validator;

    @Override
    public List<ProtocolHeader> getAll() {
        return protocolHeaderRepository.findAll();
    }

    @Override
    public List<ProtocolHeader> getAllByProjectId(Long projectId){
        return protocolHeaderRepository.findByProjectId(projectId);
    }

    @Override
    public Page<ProtocolHeader> getAll(Pageable pageable) {
        return protocolHeaderRepository.findAll(pageable);
    }

    @Override
    public ProtocolHeader getById(Long id){
        return protocolHeaderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY,id));
    }

    @Override
    public ProtocolHeader create(Long projectId, ProtocolHeader protocolHeader){
        Set<ConstraintViolation<ProtocolHeader>> violations = validator.validate(protocolHeader);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return projectRepository.findById(projectId)
                .map(project -> {
                    protocolHeader.setProject(project);
                    return protocolHeaderRepository.save(protocolHeader);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Protocol", projectId));
    }
}
