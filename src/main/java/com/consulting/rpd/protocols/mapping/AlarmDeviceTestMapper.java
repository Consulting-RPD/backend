package com.consulting.rpd.protocols.mapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.consulting.rpd.protocols.domain.model.AlarmDeviceTest;
import com.consulting.rpd.protocols.resource.AlarmDeviceTestResource;
import com.consulting.rpd.protocols.resource.CreateAlarmDeviceTestResource;
import com.consulting.rpd.shared.mapping.EnhancedModelMapper;

@Component
public class AlarmDeviceTestMapper {
    @Autowired
    private EnhancedModelMapper mapper;

    public AlarmDeviceTestResource toResource(AlarmDeviceTest model) {
        return mapper.map(model, AlarmDeviceTestResource.class);
    }

    public AlarmDeviceTest toModel(CreateAlarmDeviceTestResource model) {
        return mapper.map(model, AlarmDeviceTest.class);
    }

    public Page<AlarmDeviceTest> modelListPage(List<AlarmDeviceTest> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, AlarmDeviceTest.class));
    }
}
