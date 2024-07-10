package com.consulting.rpd.protocols.api.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consulting.rpd.protocols.domain.service.AlarmDeviceTestService;
import com.consulting.rpd.protocols.mapping.AlarmDeviceTestMapper;
import com.consulting.rpd.protocols.resource.AlarmDeviceTestResource;
import com.consulting.rpd.protocols.resource.CreateAlarmDeviceTestResource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/protocols/alarmDeviceTest", produces = "application/json")
@Tag(name = "Alarm Device Test", description = "Create and read alarm device test")
public class AlarmDeviceTestController {
    private final AlarmDeviceTestService alarmDeviceTestService;
    private final AlarmDeviceTestMapper mapper;

    @Operation(summary = "Get alarm device test by ID")
    @GetMapping("{alarmDeviceTestId}")
    public AlarmDeviceTestResource getAlarmDeviceTestById(@PathVariable Long alarmDeviceTestId) {
        return mapper.toResource(alarmDeviceTestService.getById(alarmDeviceTestId));
    }

    @Operation(summary = "Create alarm device test for a specific alarm valve")
    @PostMapping("/{alarmValveId}")
    public ResponseEntity<AlarmDeviceTestResource> createAlarmDeviceTest(@PathVariable Long alarmValveId, @RequestBody CreateAlarmDeviceTestResource resource){
        return new ResponseEntity<>(mapper.toResource(alarmDeviceTestService.create(alarmValveId, mapper.toModel(resource))), HttpStatus.CREATED);
    }   
}
