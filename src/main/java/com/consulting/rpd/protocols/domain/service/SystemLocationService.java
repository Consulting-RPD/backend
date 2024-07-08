package com.consulting.rpd.protocols.domain.service;

import com.consulting.rpd.protocols.domain.model.SystemLocation;

public interface SystemLocationService {
    SystemLocation getById(Long systemId);
    SystemLocation create(Long protocolHeaderId,SystemLocation systemLocation);
}
