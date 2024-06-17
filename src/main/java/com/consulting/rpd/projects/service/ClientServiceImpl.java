package com.consulting.rpd.projects.service;

import com.consulting.rpd.projects.domain.model.Client;
import com.consulting.rpd.projects.domain.persistance.ClientRepository;
import com.consulting.rpd.projects.domain.service.ClientService;
import com.consulting.rpd.shared.exception.FetchNotFoundException;
import com.consulting.rpd.shared.exception.ResourceNotFoundException;
import com.consulting.rpd.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private static final String ENTITY= "Client";

    private final ClientRepository clientRepository;
    private final Validator validator;

    @Transactional
    @Override
    public Client create(Client client) {
        Set<ConstraintViolation<Client>> violation = validator.validate(client);
        if (violation.isEmpty()) {
            return clientRepository.save(client);
        }
        throw new ResourceValidationException(ENTITY, violation);
    }

    @Transactional
    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Transactional
    @Override
    public Client update(Long id, Client client) {
        if(clientRepository.existsById(id)) {
            client.setId(id);
            client.setProjects(getClientById(id).getProjects());
            return clientRepository.save(client);
        }
        throw new ResourceValidationException(ENTITY, "Client not found");
    }

    @Transactional
    @Override
    public boolean delete(Long id) {
        if(clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return !clientRepository.existsById(id);
        }
        throw new ResourceNotFoundException(ENTITY, id);
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        for (Client client : clients) {
            Hibernate.initialize(client.getProjects());
        }
        return clients;
    }

    @Override
    public Client findByTradeName(String tradeName) {
        Optional<Client> optionalClient = clientRepository.findByTradeName(tradeName);
        if(optionalClient.isPresent()) {
            return optionalClient.get();
        }
        throw new FetchNotFoundException(ENTITY, "TradeName", tradeName);
    }
}
