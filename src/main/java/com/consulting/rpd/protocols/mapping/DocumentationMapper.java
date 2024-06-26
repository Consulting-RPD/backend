package com.consulting.rpd.protocols.mapping;

import com.consulting.rpd.protocols.domain.model.Documentation;
import com.consulting.rpd.protocols.resource.CreateDocumentationResource;
import com.consulting.rpd.protocols.resource.DocumentationResource;
import com.consulting.rpd.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentationMapper {
    @Autowired
    private EnhancedModelMapper mapper;

    public DocumentationResource toResource(Documentation model) {
        return mapper.map(model, DocumentationResource.class);
    }

    public Documentation toModel(CreateDocumentationResource resource) {
        return mapper.map(resource, Documentation.class);
    }

    public Page<DocumentationResource> modelListPage(List<Documentation> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, DocumentationResource.class), pageable, modelList.size());
    }
}
