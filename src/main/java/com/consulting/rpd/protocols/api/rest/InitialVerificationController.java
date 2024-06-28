package com.consulting.rpd.protocols.api.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consulting.rpd.protocols.domain.model.InitialVerification;
import com.consulting.rpd.protocols.domain.service.InitialVerificationService;
import com.consulting.rpd.protocols.mapping.InitialVerificationMapper;
import com.consulting.rpd.protocols.resource.CreateInitialVerificationResource;
import com.consulting.rpd.protocols.resource.InitialVerificationResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/protocols/initial-verification", produces = "application/json")
@Tag(name = "Initial Verification", description = "Create and read initial verification")
public class InitialVerificationController {
    private final InitialVerificationService initialVerificationService;
    private final InitialVerificationMapper mapper;

    @Operation(summary = "Get initial verification by ID")
    @GetMapping("{initialVerificationId}")
    public InitialVerificationResource getInitialVerificationById(@PathVariable Long initialVerificationId) {
        return mapper.toResource(initialVerificationService.getById(initialVerificationId));
    }

    @Operation(summary = "Create initial verification for a specific protocol", responses = {
            @ApiResponse(
                    description = "Initial verification succesfully created",
                    responseCode = "201",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = InitialVerification.class)
                    )
            )
    })
    @PostMapping("/{protocolHeaderId}")
    public ResponseEntity<InitialVerificationResource> createInitialVerification(@PathVariable Long protocolHeaderId, @RequestBody CreateInitialVerificationResource resource){
        return new ResponseEntity<>(mapper.toResource(initialVerificationService.create(protocolHeaderId, mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
