package com.consulting.rpd.protocols.domain.service;

import com.consulting.rpd.protocols.domain.model.ProtocolHeader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProtocolHeaderService {
    List<ProtocolHeader> getAll();
    Page<ProtocolHeader> getAll(Pageable pageable);
    ProtocolHeader getById(Long protocolHeaderId);
    ProtocolHeader create(ProtocolHeader protocolHeader);
    ProtocolHeader update(Long protocolHeaderId,ProtocolHeader protocolHeader);
    ResponseEntity<?> delete(Long protocolHeaderId);
}
