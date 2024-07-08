package com.consulting.rpd.protocols.domain.service;

import com.consulting.rpd.protocols.domain.model.AlarmValveData;

public interface AlarmValveDataService {
    AlarmValveData qetById(Long id);
    AlarmValveData create(Long alarmValveId, AlarmValveData alarmValveData);
}
