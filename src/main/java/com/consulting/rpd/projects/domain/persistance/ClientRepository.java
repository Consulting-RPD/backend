package com.consulting.rpd.projects.domain.persistance;

import com.consulting.rpd.projects.domain.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> getAll();
    Page<Client> getAll(Pageable pageable);
    Client getById(Long clientId);
    Client create(Client client);
    Client update(Long clientId, Client client);
    ResponseEntity<?> delete(Long clientId);
}
