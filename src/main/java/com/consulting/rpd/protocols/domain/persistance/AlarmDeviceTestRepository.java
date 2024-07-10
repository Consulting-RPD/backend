package com.consulting.rpd.protocols.domain.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consulting.rpd.protocols.domain.model.AlarmDeviceTest;

public interface AlarmDeviceTestRepository extends JpaRepository<AlarmDeviceTest, Long>{
    
}
