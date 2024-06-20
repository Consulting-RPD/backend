package com.consulting.rpd.projects.api.internal;

import com.consulting.rpd.projects.domain.model.Client;

import java.util.List;

public interface ProjectsContextFacade {
    List<Client> getProjectClientByClientId(Long clientId);
}
