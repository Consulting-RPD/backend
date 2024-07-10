package com.consulting.rpd.protocols.domain.service;

import com.consulting.rpd.protocols.domain.model.AlarmDeviceTest;

public interface AlarmDeviceTestService {
    AlarmDeviceTest getById(Long id);
    AlarmDeviceTest create(Long alarmValveId, AlarmDeviceTest alarmDeviceTest);
}
