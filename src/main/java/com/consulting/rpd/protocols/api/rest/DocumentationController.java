package com.consulting.rpd.protocols.api.rest;

import com.consulting.rpd.protocols.domain.model.Documentation;
import com.consulting.rpd.protocols.domain.service.DocumentationService;
import com.consulting.rpd.protocols.mapping.DocumentationMapper;
import com.consulting.rpd.protocols.resource.CreateDocumentationResource;
import com.consulting.rpd.protocols.resource.DocumentationResource;
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
@RequestMapping(value = "/api/v1/protocols/documentation", produces = "application/json")
@Tag(name = "Documentation", description = "Create and read documentation")
public class DocumentationController {
    private final DocumentationService documentationService;
    private final DocumentationMapper mapper;

    @Operation(summary = "Get documentation by ID")
    @GetMapping("{documentationId}")
    public DocumentationResource getDocumentationById(@PathVariable Long documentationId) {
        return mapper.toResource(documentationService.getById(documentationId));
    }

    @Operation(summary = "Create documentation for a specific protocol", responses = {
            @ApiResponse(
                    description = "Documentation succesfully created",
                    responseCode = "201",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Documentation.class)
                    )
            )
    })
    @PostMapping("/{protocolHeaderId}")
    public ResponseEntity<DocumentationResource> createDocumentation(@PathVariable Long protocolHeaderId, @RequestBody CreateDocumentationResource resource){
        return new ResponseEntity<>(mapper.toResource(documentationService.create(protocolHeaderId, mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
