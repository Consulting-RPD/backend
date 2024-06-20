package com.consulting.rpd.projects.mapping;

import com.consulting.rpd.projects.domain.model.Client;
import com.consulting.rpd.projects.resource.ClientResource;
import com.consulting.rpd.projects.resource.CreateClientResource;
import com.consulting.rpd.projects.resource.UpdateClientResource;
import com.consulting.rpd.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ClientMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public ClientResource toResource(Client model) {
        return mapper.map(model, ClientResource.class);
    }

    public Page<ClientResource> modelListPage(List<Client> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ClientResource.class), pageable, modelList.size());
    }

    public Client toModel(CreateClientResource model) {
        return mapper.map(model, Client.class);
    }

    public Client toModel(UpdateClientResource model) {
        return mapper.map(model, Client.class);
    }
}
