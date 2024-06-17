package com.consulting.rpd.projects.domain.service;

import com.consulting.rpd.projects.domain.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientService {
    Client create(Client client);
    Client getClientById(Long id);
    Client update(Long id, Client client);
    boolean delete(Long id);
    List<Client> getAllClients();
    Client findByTradeName(String name);
}
