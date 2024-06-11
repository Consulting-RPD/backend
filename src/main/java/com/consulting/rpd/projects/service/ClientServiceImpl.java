package com.consulting.rpd.projects.service;

import com.consulting.rpd.projects.domain.model.Client;
import com.consulting.rpd.projects.domain.persistance.ClientRepository;
import com.consulting.rpd.projects.domain.service.ClientService;
import com.consulting.rpd.shared.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {
    private static final String ENTITY= "Profile";

    private final ClientRepository clientRepository;
    private final Validator validator;

    public ClientServiceImpl(ClientRepository clientRepository, Validator validator) {
        this.clientRepository = clientRepository;
        this.validator = validator;
    }

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

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        return clientRepository.save(client);
    }

    @Override
    public Client update
}
