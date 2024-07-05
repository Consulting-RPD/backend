package com.consulting.rpd.projects.domain.persistance;

import com.consulting.rpd.projects.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByClientCode(String clientCode);
    boolean existsByClientCode(String clientCode);
}
