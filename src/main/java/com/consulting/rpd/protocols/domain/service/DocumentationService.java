package com.consulting.rpd.protocols.domain.service;

import com.consulting.rpd.protocols.domain.model.Documentation;

public interface DocumentationService {
    Documentation getById(Long documentationId);
    Documentation create(Long protocolHeaderId,Documentation documentation);
    //Documentation update(Long documentationId,Documentation documentation);
}
