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

import java.util.List;

public class ClientMapper {
    @Autowired
    private EnhancedModelMapper mapper;

    public ClientResource toResource(Client model) {return mapper.map(model, ClientResource.class);}

    public Client toModel(CreateClientResource resource) {return mapper.map(resource, Client.class);}

    public Client toModel(UpdateClientResource resource) {return mapper.map(resource, Client.class);}

    public Page<ClientResource> modelListPage(List<Client> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ClientResource.class), pageable, modelList.size());
    }
}
