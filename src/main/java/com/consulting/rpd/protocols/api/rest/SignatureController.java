package com.consulting.rpd.protocols.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.consulting.rpd.protocols.domain.model.Signature;
import com.consulting.rpd.protocols.domain.service.Signatureservice;
import com.consulting.rpd.protocols.mapping.SignatureMapper;
import com.consulting.rpd.protocols.resource.CreateSignatureResource;
import com.consulting.rpd.protocols.resource.SignatureResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/protocols/signature", produces = "application/json")
@Tag(name = "Signature", description = "Create and read signatures")
public class SignatureController {
    private final Signatureservice signatureService;
    private final SignatureMapper mapper;

    @Operation(summary = "Get signature by ID")
    @GetMapping("{signatureId}")
    public SignatureResource getSignatureById(@PathVariable Long signatureId) {
        return mapper.toResource(signatureService.getById(signatureId));
    }

    @Operation(summary = "Create signature for a specific protocol", responses = {
        @ApiResponse(
            description = "Signature succesfully created",
            responseCode = "201",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Signature.class)
            )
        )
    })
    @PostMapping("/{protocolHeaderId}")
    public ResponseEntity<SignatureResource> createSignature(@PathVariable Long protocolHeaderId, @RequestBody CreateSignatureResource resource){
        return new ResponseEntity<>(mapper.toResource(signatureService.create(protocolHeaderId, mapper.toModel(resource))), HttpStatus.CREATED);
    }

}
