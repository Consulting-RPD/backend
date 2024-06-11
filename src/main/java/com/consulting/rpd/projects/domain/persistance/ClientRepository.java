package com.consulting.rpd.projects.domain.persistance;

import com.consulting.rpd.projects.domain.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByClientName(String clientName);
    Page<Client> findByClientNameContaining(String clientName, Pageable pageable);
}
