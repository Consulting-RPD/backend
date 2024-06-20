package com.consulting.rpd.projects.service;

import com.consulting.rpd.projects.api.internal.ProjectsContextFacade;
import com.consulting.rpd.projects.domain.model.Client;
import com.consulting.rpd.projects.domain.model.Project;
import com.consulting.rpd.projects.domain.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProjectsContextFacadeImpl implements ProjectsContextFacade {
    private final ProjectService projectService;

    @Override
    public List<Client> getProjectClientByClientId(Long clientId){
        return this.projectService.getAllByClientId(clientId).stream()
                .map(Project::getClient)
                .collect(Collectors.toList());
    }
}
