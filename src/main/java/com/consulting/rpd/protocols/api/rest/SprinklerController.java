package com.consulting.rpd.protocols.api.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consulting.rpd.protocols.domain.service.SprinklerService;
import com.consulting.rpd.protocols.mapping.SprinklerMapper;
import com.consulting.rpd.protocols.resource.CreateSprinklerResource;
import com.consulting.rpd.protocols.resource.SprinklerResource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/protocols/sprinklers", produces = "application/json")
@Tag(name = "Sprinkler", description = "Create and read sprinklers")
public class SprinklerController {
    private final SprinklerService sprinklerService;
    private final SprinklerMapper mapper;

    @Operation(summary = "Get sprinkler by ID")
    @GetMapping("{sprinklerId}")
    public SprinklerResource getSprinklerById(@PathVariable Long sprinklerId) {
        return mapper.toResource(sprinklerService.getById(sprinklerId));
    }

    @Operation(summary = "Create sprinkler for a specific protocol", responses = {
        @ApiResponse(
            description = "Sprinkler succesfully created",
            responseCode = "201",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = SprinklerResource.class)
            )
        )
    })
    @PostMapping("/{protocolHeaderId}")
    public ResponseEntity<SprinklerResource> createSprinkler(@PathVariable Long protocolHeaderId, @RequestBody CreateSprinklerResource resource){
        return new ResponseEntity<>(mapper.toResource(sprinklerService.create(protocolHeaderId, mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
