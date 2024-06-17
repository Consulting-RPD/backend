package com.consulting.rpd.projects.domain.persistance;

import com.consulting.rpd.projects.domain.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    public boolean existsById(Long id);
    Optional<Client> findByTradeName(String tradeName);
}
