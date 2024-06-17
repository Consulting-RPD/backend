package com.consulting.rpd.projects.api.rest;

import com.consulting.rpd.projects.domain.model.Client;
import com.consulting.rpd.projects.domain.service.ClientService;
import com.consulting.rpd.projects.mapping.ClientMapper;
import com.consulting.rpd.projects.resource.ClientResource;
import com.consulting.rpd.projects.resource.CreateClientResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(value = "api/v1/projects/clients", produces = "application/json")
@Tag(name = "Clients", description = "Create, read, update and delete profiles")
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper mapper;
    private final ClientMapper clientMapper;

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
    public ResponseEntity<ClientResource> create(@RequestBody CreateClientResource createClientResource) {
        return new ResponseEntity<>(clientMapper.toResource(clientService.create(mapper.toEntity(createClientResource))), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all clients")
    @GetMapping
    public ResponseEntity<List<ClientResource>> getAllClients() {
        return new ResponseEntity<>(clientService.getAllClients().stream().map(this::convertToResource).collect(Collectors.toList()),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClientResource> getClientById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapper.toResource(clientService.getClientById(id)), HttpStatus.OK);
    }

    @Operation(summary = "Update client", responses = {
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

    private ClientResource convertToResource(Client client) {
        return mapper.toResource(client);
    }
}
