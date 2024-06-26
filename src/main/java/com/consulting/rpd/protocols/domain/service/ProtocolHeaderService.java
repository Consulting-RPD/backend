package com.consulting.rpd.protocols.domain.service;

import com.consulting.rpd.protocols.domain.model.ProtocolHeader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProtocolHeaderService {
    List<ProtocolHeader> getAll();
    List<ProtocolHeader> getAllByProjectId(Long projectId);
    Page<ProtocolHeader> getAll(Pageable pageable);
    ProtocolHeader getById(Long id);
    ProtocolHeader create(Long projectId, ProtocolHeader protocolHeader);
    //ProtocolHeader update(Long  protocolHeaderId,ProtocolHeader protocolHeader);
    //ResponseEntity<?> delete(Long protocolHeaderId);
}
