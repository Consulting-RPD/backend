package com.consulting.rpd.protocols.mapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.consulting.rpd.shared.mapping.EnhancedModelMapper;
import com.consulting.rpd.protocols.resource.AlarmValveResource;
import com.consulting.rpd.protocols.resource.CreateAlarmValveResource;
import com.consulting.rpd.protocols.domain.model.AlarmValve;

@Component
public class AlarmValveMapper {
    @Autowired
    private EnhancedModelMapper mapper;

    public AlarmValveResource toResource(AlarmValve model) {
        return mapper.map(model, AlarmValveResource.class);
    }

    public AlarmValve toModel(CreateAlarmValveResource resource) {
        return mapper.map(resource, AlarmValve.class);
    }

    public Page<AlarmValveResource> modelListPage(List<AlarmValve> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, AlarmValveResource.class), pageable, modelList.size());
    }
}
