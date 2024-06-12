package com.consulting.rpd.projects.service;

import com.consulting.rpd.projects.domain.model.Project;
import com.consulting.rpd.projects.domain.persistance.ProjectRepository;
import com.consulting.rpd.projects.domain.service.ProjectService;
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

public class ProjectServiceImpl implements ProjectService {
    private static final String ENTITY = "Project";
    private final ProjectRepository projectRepository;
    private final Validator validator;

    public ProjectServiceImpl(ProjectRepository projectRepository, Validator validator) {
        this.projectRepository = projectRepository;
        this.validator = validator;
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Page<Project> getAll(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Project getById(Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, projectId));
    }

    @Override
    public Project create(Project project) {
        Set<ConstraintViolation<Project>> violations = validator.validate(project);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        Optional<Project> projectCode = projectRepository.findByProjectCode(project.getProjectCode());
        if (projectCode.isPresent() && !projectCode.get().getId().equals(project.getId())) {
            throw new ResourceValidationException(ENTITY, "A project with the same code already exists");
        }

        return projectRepository.save(project);
    }

    @Override
    public Project update(Long projectId, Project project) {
        Set<ConstraintViolation<Project>> violations = validator.validate(project);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        Optional<Project> projectCode = projectRepository.findByProjectCode(project.getProjectCode());
        if (projectCode.isPresent() && !projectCode.get().getId().equals(project.getId())) {
            throw new ResourceValidationException(ENTITY, "A project with the same code already exists");
        }

        return projectRepository.findById(projectId)
                .map(projectToUpdate -> projectRepository.save(projectToUpdate
                        .withProjectCode(project.getProjectCode())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, projectId));
    }

    @Override
    public ResponseEntity<?> delete(Long clientId) {
        return projectRepository.findById(clientId)
                .map(project -> {
                    projectRepository.delete(project);
                    return ResponseEntity.ok().build();
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, clientId));
    }
}
