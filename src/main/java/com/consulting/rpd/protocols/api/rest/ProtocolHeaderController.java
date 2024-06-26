package com.consulting.rpd.protocols.api.rest;

import com.consulting.rpd.protocols.domain.model.ProtocolHeader;
import com.consulting.rpd.protocols.domain.service.ProtocolHeaderService;
import com.consulting.rpd.protocols.mapping.ProtocolHeaderMapper;
import com.consulting.rpd.protocols.resource.CreateProtocolHeaderResource;
import com.consulting.rpd.protocols.resource.ProtocolHeaderResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/protocols/protocolHeader", produces = "application/json")
@Tag(name = "Protocol Header", description = "Create and read protocol headers")
public class ProtocolHeaderController {
    private final ProtocolHeaderService protocolHeaderService;
    private final ProtocolHeaderMapper mapper;

    @Operation(summary = "Get all projects")
    @GetMapping
    public Page<ProtocolHeaderResource> getAllProtocolHeaders(Pageable pageable) {
        return mapper.modelListPage(protocolHeaderService.getAll(), pageable);
    }

    @Operation(summary = "Get protocol header by ID")
    @GetMapping("{protocolHeaderId}")
    public ProtocolHeaderResource getProtocolHeaderById(@PathVariable() Long protocolHeaderId) {
        return mapper.toResource(protocolHeaderService.getById(protocolHeaderId));
    }

    @Operation(summary = "Create protocol header for a specific project", responses = {
            @ApiResponse(
                    description = "Protocol header successfully created",
                    responseCode = "201",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProtocolHeader.class)
                    )
            )
    })
    @PostMapping("/{projectId}")
    public ResponseEntity<ProtocolHeaderResource> createProtocolHeader(@PathVariable Long projectId, @RequestBody CreateProtocolHeaderResource resource){
        return new ResponseEntity<>(mapper.toResource(protocolHeaderService.create(projectId, mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
