package com.consulting.rpd.protocols.domain.service;

import com.consulting.rpd.protocols.domain.model.Documentation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DocumentationService {
    List<Documentation> getAll();
    Page<Documentation> getAll(Pageable pageable);
    Documentation getById(Long documentationId);
    Documentation create(Documentation documentation);
    Documentation update(Long documentationId, Documentation documentation);
    ResponseEntity<?> delete(Long documentationId);
}
