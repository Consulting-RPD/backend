package com.consulting.rpd.protocols.mapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.consulting.rpd.protocols.domain.model.SystemLocation;
import com.consulting.rpd.protocols.resource.CreateSystemLocationResource;
import com.consulting.rpd.protocols.resource.SystemLocationResource;
import com.consulting.rpd.shared.mapping.EnhancedModelMapper;

@Component
public class SystemLocationMapper {
    @Autowired
    private EnhancedModelMapper mapper;

    public SystemLocationResource toResource(SystemLocation model) {
        return mapper.map(model, SystemLocationResource.class);
    }

    public SystemLocation toModel(CreateSystemLocationResource resource) {
        return mapper.map(resource, SystemLocation.class);
    }

    public Page<SystemLocationResource> modelListPage(List<SystemLocation> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, SystemLocationResource.class), pageable, modelList.size());
    }
}
