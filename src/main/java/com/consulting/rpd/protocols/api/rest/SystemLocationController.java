package com.consulting.rpd.protocols.api.rest;

import org.springframework.web.bind.annotation.RestController;

import com.consulting.rpd.protocols.domain.model.SystemLocation;
import com.consulting.rpd.protocols.domain.service.SystemLocationService;
import com.consulting.rpd.protocols.mapping.SystemLocationMapper;
import com.consulting.rpd.protocols.resource.CreateSystemLocationResource;
import com.consulting.rpd.protocols.resource.SystemLocationResource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/protocols/system-location", produces = "application/json")
@Tag(name = "System Location", description = "Create and read system location")
public class SystemLocationController {
    private final SystemLocationService systemLocationService;
    private final SystemLocationMapper mapper;

    @Operation(summary = "Get system location by ID")
    @GetMapping("{systemLocationId}")
    public SystemLocationResource getSystemLocationById(@PathVariable Long systemLocationId) {
        return mapper.toResource(systemLocationService.getById(systemLocationId));
    }

    @Operation(summary = "Create system location for a specific protocol", responses = {
            @ApiResponse(
                    description = "System location succesfully created",
                    responseCode = "201",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = SystemLocation.class)
                    )
            )
    })
    @PostMapping("/{protocolHeaderId}")
    public ResponseEntity<SystemLocationResource> createSystemLocation(@PathVariable Long protocolHeaderId, @RequestBody CreateSystemLocationResource resource){
        return new ResponseEntity<>(mapper.toResource(systemLocationService.create(protocolHeaderId, mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
