package com.consulting.rpd.projects.api.rest;

import com.consulting.rpd.projects.domain.service.ClientService;
import com.consulting.rpd.projects.mapping.ClientMapper;
import com.consulting.rpd.projects.resource.ClientResource;
import com.consulting.rpd.projects.resource.CreateClientResource;
import com.consulting.rpd.projects.resource.UpdateClientResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.PushBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/projects/clients", produces = "application/json")
@Tag(name = "Clients", description = "Create, read, update and delete profiles")
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper mapper;

    public ClientController(ClientService clientService, ClientMapper mapper) {
        this.clientService = clientService;
        this.mapper = mapper;
    }

    @Operation(summary = "Get all clients")
    @GetMapping
    public Page<ClientResource> getAllClients(Pageable pageable) {
        return mapper.modelListPage(clientService.getAll(), pageable);
    }

    @Operation(summary = "Get profile by ID")
    @GetMapping("{clientId}")
    public ClientResource getClientById(@PathVariable Long clientId) {
        return mapper.toResource(clientService.getById(clientId));
    }

    @Operation(summary = "Create client", responses = {
            @ApiResponse(
                    description = "Client succesfully created",
                    responseCode = "201",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ClientResource.class)
                    )
            )
    })
    @PostMapping
    public ResponseEntity<ClientResource> createClient(@RequestBody CreateClientResource resource) {
        return new ResponseEntity<>(mapper.toResource(clientService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @Operation(summary = "Update Client", responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Client successfully udpated",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ClientResource.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Client not found"
            )
    })
    @PutMapping("{clientId}")
    public ClientResource updateClient(@PathVariable Long clientId, @RequestBody UpdateClientResource resource) {
        return mapper.toResource(clientService.update(clientId, mapper.toModel(resource)));
    }

    @Operation(summary = "Delete client", responses = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Client successfully deleted"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Client not found"
            )
    })
    @DeleteMapping("{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId) {
        return clientService.delete(clientId);
    }
}
