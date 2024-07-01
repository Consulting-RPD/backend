package com.consulting.rpd.protocols.domain.service;

import com.consulting.rpd.protocols.domain.model.PipeAndAccesories;

public interface PipeAndAccesoriesService {
    PipeAndAccesories getById(Long pipeAndAccesoriesId);
    PipeAndAccesories create(Long protocolHeaderId,PipeAndAccesories pipeAndAccesories);
    //PipeAndAccesories update(Long pipeAndAccesoriesId,PipeAndAccesories pipeAndAccesories);
}
