package com.consulting.rpd.protocols.mapping;

import com.consulting.rpd.protocols.domain.model.ProtocolHeader;
import com.consulting.rpd.protocols.resource.CreateProtocolHeaderResource;
import com.consulting.rpd.protocols.resource.ProtocolHeaderResource;
import com.consulting.rpd.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProtocolHeaderMapper {
    @Autowired
    private EnhancedModelMapper mapper;

    public ProtocolHeaderResource toResource(ProtocolHeader model) {
        return mapper.map(model, ProtocolHeaderResource.class);
    }

    public ProtocolHeader toModel(CreateProtocolHeaderResource resource) {
        return mapper.map(resource, ProtocolHeader.class);
    }

    // public ProtocolHeader toModel(Update resource) {
    //    return mapper.map(resource, Project.class);
    //}

    public Page<ProtocolHeaderResource> modelListPage(List<ProtocolHeader> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ProtocolHeaderResource.class), pageable, modelList.size());
    }
}
