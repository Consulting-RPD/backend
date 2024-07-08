package com.consulting.rpd.protocols.domain.service;

import com.consulting.rpd.protocols.domain.model.Sprinkler;

public interface SprinklerService {
    Sprinkler getById(Long sprinklerId);
    Sprinkler create(Long protocolHeaderId,Sprinkler sprinkler);
}
