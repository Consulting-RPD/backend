package com.consulting.rpd.protocols.api.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consulting.rpd.protocols.domain.model.AlarmValve;
import com.consulting.rpd.protocols.domain.service.AlarmValveService;
import com.consulting.rpd.protocols.mapping.AlarmValveMapper;
import com.consulting.rpd.protocols.resource.AlarmValveResource;
import com.consulting.rpd.protocols.resource.CreateAlarmValveResource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/protocols/alarm-valve", produces = "application/json")
@Tag(name = "Alarm Valve", description = "Create and read alarm valve")
public class AlarmValeController {
    private final AlarmValveService alarmValveService;
    private final AlarmValveMapper mapper;

    @Operation(summary = "Get alarm valve by ID")
    @GetMapping("{alarmValveId}")
    public AlarmValveResource getAlarmValveById(@PathVariable Long alarmValveId) {
        return mapper.toResource(alarmValveService.getById(alarmValveId));
    }

    @Operation(summary = "Create alarm valve for a specific protocol", responses = {
        @ApiResponse(
            description = "Alarm valve succesfully created",
            responseCode = "201",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = AlarmValve.class)
            )
        )
    })
    @PostMapping("/{protocolHeaderId}")
    public ResponseEntity<AlarmValveResource> createAlarmValve(@PathVariable Long protocolHeaderId, @RequestBody CreateAlarmValveResource resource){
        return new ResponseEntity<>(mapper.toResource(alarmValveService.create(protocolHeaderId, mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
