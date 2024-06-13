package com.consulting.rpd.protocols.api.rest;

import com.consulting.rpd.protocols.domain.service.DocumentationService;
import com.consulting.rpd.protocols.mapping.DocumentationMapper;
import com.consulting.rpd.protocols.resource.*;
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
@RequestMapping(value = "/api/v1/protocols/documentation", produces = "application/json")
@Tag(name = "Documentation", description = "Create, read, update and delete documentation")
public class DocumentationController {
    private final DocumentationService documentationService;
    private DocumentationMapper mapper;

    public DocumentationController(DocumentationService documentationService, DocumentationMapper mapper) {
        this.documentationService = documentationService;
        this.mapper = mapper;
    }

    @Operation(summary = "Get all documentation")
    @GetMapping
    public Page<DocumentationResource> getAllDocumentation(Pageable pageable) {
        return mapper.modelListPage(documentationService.getAll(),pageable);
    }

    @Operation(summary = "Get documentation by ID")
    @GetMapping("{documentationId}")
    public DocumentationResource getAllDocumentation(@PathVariable Long documentationId) {
        return mapper.toResource(documentationService.getById(documentationId));
    }

    @Operation(summary = "Create documentation", responses = {
            @ApiResponse(
                    description = "Documentation succesfully created",
                    responseCode = "201",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = DocumentationResource.class)
                    )
            )
    })
    @PostMapping
    public DocumentationResource createDocumentation(@RequestBody CreateDocumentationResource resource) {
        return mapper.toResource(documentationService.create(mapper.toModel(resource)));
    }

    @Operation(summary = "Update documentation", responses = {
            @ApiResponse(
                    description = "Documentation succesfully updated",
                    responseCode = "201",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = DocumentationResource.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Documentation not found"
            )
    })
    @PutMapping("{documentationId}")
    public DocumentationResource updateDocumentation(@PathVariable Long documentationId, @RequestBody UpdateDocumentationResource resource) {
        return mapper.toResource(documentationService.update(documentationId, mapper.toModel(resource)));
    }

    @Operation(summary = "Delete documentation", responses = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Documentation successfully deleted"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Documentation not found"
            )
    })
    @DeleteMapping("{DocumentationId}")
    public ResponseEntity<?> deleteDocumentation(@PathVariable Long documentationId) {
        return documentationService.delete(documentationId);
    }
}
