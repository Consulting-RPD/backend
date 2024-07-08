package com.consulting.rpd.protocols.mapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.consulting.rpd.protocols.domain.model.Sprinkler;
import com.consulting.rpd.protocols.resource.CreateSprinklerResource;
import com.consulting.rpd.protocols.resource.SprinklerResource;
import com.consulting.rpd.shared.mapping.EnhancedModelMapper;

@Component
public class SprinklerMapper {
    @Autowired
    private EnhancedModelMapper mapper;

    public SprinklerResource toResource(Sprinkler model) {
        return mapper.map(model, SprinklerResource.class);
    }

    public Sprinkler toModel(CreateSprinklerResource resource) {
        return mapper.map(resource, Sprinkler.class);
    }

    public Page<SprinklerResource> modelListPage(List<Sprinkler> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, SprinklerResource.class), pageable, modelList.size());
    }
}
