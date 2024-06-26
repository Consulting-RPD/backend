package com.consulting.rpd.protocols.domain.service;

import com.consulting.rpd.protocols.domain.model.Signature;

public interface Signatureservice {
    Signature getById(Long signatureId);
    Signature create(Long protocolHeaderId,Signature signature);
    //Signature update(Long signatureId,Signature signature);
}
