package com.consulting.rpd.protocols.mapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import com.consulting.rpd.protocols.domain.model.InitialVerification;
import com.consulting.rpd.protocols.resource.CreateInitialVerificationResource;
import com.consulting.rpd.protocols.resource.InitialVerificationResource;
import com.consulting.rpd.shared.mapping.EnhancedModelMapper;

@Component
public class InitialVerificationMapper {
    @Autowired
    private EnhancedModelMapper mapper;

    public InitialVerificationResource toResource(InitialVerification model) {
        return mapper.map(model, InitialVerificationResource.class);
    }

    public InitialVerification toModel(CreateInitialVerificationResource resource) {
        return mapper.map(resource, InitialVerification.class);
    }

    public Page<InitialVerificationResource> modelListPage(List<InitialVerification> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList,InitialVerificationResource.class), pageable,modelList.size());
    }
}
