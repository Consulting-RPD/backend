package com.consulting.rpd.protocols.api.rest;

import com.consulting.rpd.projects.resource.ClientResource;
import com.consulting.rpd.protocols.domain.service.ProtocolHeaderService;
import com.consulting.rpd.protocols.mapping.ProtocolHeaderMapper;
import com.consulting.rpd.protocols.resource.CreateProtocolHeaderResource;
import com.consulting.rpd.protocols.resource.ProtocolHeaderResource;
import com.consulting.rpd.protocols.resource.UpdateProtocolHeaderResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/protocols/protocolHeader", produces = "application/json")
@Tag(name = "Protocol Header", description = "Create, read, update and delete protocol headers")
public class ProtocolHeaderController {
    private final ProtocolHeaderService protocolHeaderService;
    private ProtocolHeaderMapper mapper;

    public ProtocolHeaderController(ProtocolHeaderService protocolHeaderService, ProtocolHeaderMapper mapper) {
        this.protocolHeaderService = protocolHeaderService;
        this.mapper = mapper;
    }

    @Operation(summary = "Get all protocol headers")
    @GetMapping
    public Page<ProtocolHeaderResource> getAllProtocolHeaders(Pageable pageable) {
        return mapper.modelListPage(protocolHeaderService.getAll(),pageable);
    }

    @Operation(summary = "Get protocol header by ID")
    @GetMapping("{protocolHeaderId}")
    public ProtocolHeaderResource getProtocolHeaderById(@PathVariable Long protocolHeaderId) {
        return mapper.toResource(protocolHeaderService.getById(protocolHeaderId));
    }

    @Operation(summary = "Create protocol header", responses = {
            @ApiResponse(
                    description = "Protocol Header succesfully created",
                    responseCode = "201",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProtocolHeaderResource.class)
                    )
            )
    })
    @PostMapping
    public ProtocolHeaderResource createProtocolHeader(@RequestBody CreateProtocolHeaderResource resource) {
        return mapper.toResource(protocolHeaderService.create(mapper.toModel(resource)));
    }

    @Operation(summary = "Update protocol header", responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Protocol header successfully udpated",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProtocolHeaderResource.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Protocol header not found"
            )
    })
    @PutMapping("{protocolHeaderId}")
    public ProtocolHeaderResource updateProtocolHeader(@PathVariable Long protocolHeaderId, @RequestBody UpdateProtocolHeaderResource resource) {
        return mapper.toResource(protocolHeaderService.update(protocolHeaderId, mapper.toModel(resource)));
    }

    @Operation(summary = "Delete protocol header", responses = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Protocol header successfully deleted"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Protocol header not found"
            )
    })
    @DeleteMapping("{protocolHeaderId}")
    public ResponseEntity<?> deleteProtocolHeader(@PathVariable Long protocolHeaderId) {
        return protocolHeaderService.delete(protocolHeaderId);
    }
}
