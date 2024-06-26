package com.consulting.rpd.protocols.domain.persistance;

import com.consulting.rpd.protocols.domain.model.Documentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentationRepository extends JpaRepository<Documentation, Long> {
}
