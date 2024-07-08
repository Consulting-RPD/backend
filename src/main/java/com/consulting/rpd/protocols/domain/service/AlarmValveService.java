package com.consulting.rpd.protocols.domain.service;

import com.consulting.rpd.protocols.domain.model.AlarmValve;

public interface AlarmValveService {
    AlarmValve getById(Long alarmValveId);
    AlarmValve create(Long protocolHeaderId,AlarmValve alarmValve);
}
