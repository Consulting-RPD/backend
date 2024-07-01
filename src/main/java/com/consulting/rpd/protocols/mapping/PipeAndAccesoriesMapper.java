package com.consulting.rpd.protocols.mapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.consulting.rpd.protocols.domain.model.PipeAndAccesories;
import com.consulting.rpd.protocols.resource.CreatePipeAndAccesoriesResource;
import com.consulting.rpd.protocols.resource.PipeAndAccesoriesResource;
import com.consulting.rpd.shared.mapping.EnhancedModelMapper;

@Component
public class PipeAndAccesoriesMapper {
    @Autowired
    private EnhancedModelMapper mapper;

    public PipeAndAccesoriesResource toResource(PipeAndAccesories model) {
        return mapper.map(model, PipeAndAccesoriesResource.class);
    }

    public PipeAndAccesories toModel(CreatePipeAndAccesoriesResource resource) {
        return mapper.map(resource, PipeAndAccesories.class);
    }

    public Page<PipeAndAccesoriesResource> modelListPage(List<PipeAndAccesories> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, PipeAndAccesoriesResource.class), pageable, modelList.size());
    }
}
