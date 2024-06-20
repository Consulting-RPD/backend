package com.consulting.rpd.projects.service;

import com.consulting.rpd.projects.domain.model.Project;
import com.consulting.rpd.projects.domain.persistance.ClientRepository;
import com.consulting.rpd.projects.domain.persistance.ProjectRepository;
import com.consulting.rpd.projects.domain.service.ProjectService;
import com.consulting.rpd.shared.exception.FetchNotFoundException;
import com.consulting.rpd.shared.exception.ResourceNotFoundException;
import com.consulting.rpd.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {
    private static final String ENTITY = "Project";

    private final ProjectRepository projectRepository;
    private final ClientRepository clientRepository;
    private final Validator validator;

    @Override
    public List<Project> getAll(){
        return projectRepository.findAll();
    }

    @Override
    public List<Project> getAllByClientId(Long clientId){
        return projectRepository.findByClientId(clientId);
    }

    @Override
    public Page<Project> getAll(Pageable pageable){
        return projectRepository.findAll(pageable);
    }

    @Override
    public Project getById(Long id){
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Project create(Project project){
        Set<ConstraintViolation<Project>> violations = validator.validate(project);

        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY, violations);
        }

        return projectRepository.save(project);
    }

    @Override
    public Project update(Long id, Project project){
        Set<ConstraintViolation<Project>> violations = validator.validate(project);

        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY, violations);
        }

        return projectRepository.findById(id)
                .map(projectToUpdate -> projectRepository.save(
                        projectToUpdate.withProjectCode(project.getProjectCode())
                                .withProjectCorrelative(project.getProjectCorrelative())
                                .withClient(project.getClient())
                    )
                )
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public ResponseEntity<?> delete(Long id){
        return projectRepository.findById(id)
                .map(project -> {
                    projectRepository.delete(project);
                    return ResponseEntity.ok().build();
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Transactional
    public Project createForClient(Long clientId, Project project) {
        Set<ConstraintViolation<Project>> violations = validator.validate(project);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return clientRepository.findById(clientId)
                .map(client -> {
                    project.setClient(client);
                    return projectRepository.save(project);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Client", clientId));
    }
}
