package com.consulting.rpd.protocols.mapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.consulting.rpd.protocols.domain.model.AlarmValveData;
import com.consulting.rpd.protocols.resource.AlarmValveDataResource;
import com.consulting.rpd.protocols.resource.CreateAlarmValveDataResource;
import com.consulting.rpd.shared.mapping.EnhancedModelMapper;

@Component
public class AlarmValveDataMapper {
    @Autowired
    private EnhancedModelMapper mapper;

    public AlarmValveDataResource toResource(AlarmValveData model) {
        return mapper.map(model, AlarmValveDataResource.class);
    }

    public AlarmValveData toModel(CreateAlarmValveDataResource model) {
        return mapper.map(model, AlarmValveData.class);
    }

    public Page<AlarmValveData> modelListPage(List<AlarmValveData> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, AlarmValveData.class), pageable, modelList.size());
    }
}
