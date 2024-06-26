package com.consulting.rpd.protocols.mapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.consulting.rpd.protocols.domain.model.Signature;
import com.consulting.rpd.protocols.resource.CreateSignatureResource;
import com.consulting.rpd.protocols.resource.SignatureResource;
import com.consulting.rpd.shared.mapping.EnhancedModelMapper;

@Component
public class SignatureMapper {
    @Autowired
    private EnhancedModelMapper mapper;
    
    public SignatureResource toResource(Signature model) {
        return mapper.map(model, SignatureResource.class);
    }

    public Signature toModel(CreateSignatureResource resource) {
        return mapper.map(resource, Signature.class);
    }

    public Page<SignatureResource> modelListPage(List<Signature> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, SignatureResource.class), pageable, modelList.size());
    }
}
