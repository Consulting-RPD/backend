package com.consulting.rpd.protocols.domain.persistance;

import com.consulting.rpd.protocols.domain.model.ProtocolHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProtocolHeaderRepository extends JpaRepository<ProtocolHeader, Long> {
    List<ProtocolHeader> findByProjectId(Long projectId);
}
