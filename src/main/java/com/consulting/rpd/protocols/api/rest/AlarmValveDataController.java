package com.consulting.rpd.protocols.api.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consulting.rpd.protocols.domain.model.AlarmValveData;
import com.consulting.rpd.protocols.domain.service.AlarmValveDataService;
import com.consulting.rpd.protocols.mapping.AlarmValveDataMapper;
import com.consulting.rpd.protocols.resource.AlarmValveDataResource;
import com.consulting.rpd.protocols.resource.CreateAlarmValveDataResource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/protocols/alarmValveData", produces = "application/json")
@Tag(name = "Alarm Valve Data", description = "Create and read alarm valve data")
public class AlarmValveDataController {
    private final AlarmValveDataService alarmValveDataService;
    private final AlarmValveDataMapper mapper;

    @Operation(summary = "Get alarm valve data by ID")
    @GetMapping("{alarmValveDataId}")
    public AlarmValveDataResource getAlarmValveDataById(@PathVariable Long alarmValveDataId) {
        return mapper.toResource(alarmValveDataService.getById(alarmValveDataId));
    }

    @Operation(summary = "Create alarm valve data for a specific alarm valve", responses = {
        @ApiResponse(
            description = "Alarm valve data succesfully created",
            responseCode = "201",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = AlarmValveData.class)
            )
        )
    })
    @PostMapping("/{alarmValveId}")
    public ResponseEntity<AlarmValveDataResource> createAlarmValveData(@PathVariable Long alarmValveId, @RequestBody CreateAlarmValveDataResource resource){
        return new ResponseEntity<>(mapper.toResource(alarmValveDataService.create(alarmValveId, mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
