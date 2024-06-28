package com.consulting.rpd.protocols.domain.service;

import com.consulting.rpd.protocols.domain.model.InitialVerification;

public interface InitialVerificationService {
    InitialVerification getById(Long initialVerificationId);
    InitialVerification create(Long protocolHeaderId,InitialVerification initialVerification);
    //InitialVerification update(Long initialVerificationId,InitialVerification initialVerification);
}
