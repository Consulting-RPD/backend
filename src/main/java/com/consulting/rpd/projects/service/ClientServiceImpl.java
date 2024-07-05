package com.consulting.rpd.projects.service;

import com.consulting.rpd.projects.domain.model.Client;
import com.consulting.rpd.projects.domain.persistance.ClientRepository;
import com.consulting.rpd.projects.domain.service.ClientService;
import com.consulting.rpd.shared.exception.ResourceNotFoundException;
import com.consulting.rpd.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private static final String ENTITY= "Client";

    private final ClientRepository clientRepository;
    private final Validator validator;

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Page<Client> getAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public Client getById(Long clientId){
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, clientId));
    }

    @Override
    public Client create(Client client) {
        Set<ConstraintViolation<Client>> violations = validator.validate(client);

        if(!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        if(clientRepository.findByClientCode(client.getClientCode()).isPresent()) {
            throw new ResourceValidationException(ENTITY, "A client with this code already exists");
        }

        return clientRepository.save(client);
    }

    @Override
    public Client update(Long clientId, Client client) {
        Set<ConstraintViolation<Client>> violations = validator.validate(client);

        if(!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        Optional<Client> optionalClient = clientRepository.findByClientCode(client.getClientCode());

        if(optionalClient.isPresent() && !optionalClient.get().getId().equals(client.getId())) {
            throw new ResourceValidationException(ENTITY, "A role with the same code already exists");
        }

        return clientRepository.findById(clientId)
                .map(clientToUpdate -> clientRepository.save(clientToUpdate.withClientCode(client.getClientCode())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, clientId));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return clientRepository.findById(id)
                .map(client -> {
                    clientRepository.delete(client);
                    return ResponseEntity.ok().build();
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }
}
