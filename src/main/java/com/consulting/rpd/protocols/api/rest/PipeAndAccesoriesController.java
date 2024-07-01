package com.consulting.rpd.protocols.api.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consulting.rpd.protocols.domain.model.PipeAndAccesories;
import com.consulting.rpd.protocols.domain.service.PipeAndAccesoriesService;
import com.consulting.rpd.protocols.mapping.PipeAndAccesoriesMapper;
import com.consulting.rpd.protocols.resource.CreatePipeAndAccesoriesResource;
import com.consulting.rpd.protocols.resource.PipeAndAccesoriesResource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/protocols/pipes", produces = "application/json")
@Tag(name = "Pipe and Accesories", description = "Create and read pipes and accesories")
public class PipeAndAccesoriesController {
    private final PipeAndAccesoriesService pipeAndAccesoriesService;
    private final PipeAndAccesoriesMapper mapper;

    @Operation(summary = "Get pipe and accesories by ID")
    @GetMapping("{pipeId}")
    public PipeAndAccesoriesResource getPipeAndAccesoriesById(@PathVariable Long pipeId) {
        return mapper.toResource(pipeAndAccesoriesService.getById(pipeId));
    }

    @Operation(summary = "Create pipe and accesories for a specific protocol" , responses = {
        @ApiResponse(
            description = "Pipe and accesories succesfully created",
            responseCode = "201",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = PipeAndAccesories.class)
            )
        )
    })
    @PostMapping("/{protocolHeaderId}")
    public ResponseEntity<PipeAndAccesoriesResource> createPipeAndAccesories(@PathVariable Long protocolHeaderId, @RequestBody CreatePipeAndAccesoriesResource resource){
        return new ResponseEntity<>(mapper.toResource(pipeAndAccesoriesService.create(protocolHeaderId, mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
