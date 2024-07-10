package com.consulting.rpd.protocols.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name = "alarm_valves_detail")
public class AlarmValvesDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Relationships
    @OneToOne
    @JoinColumn(name = "alarm_valve_id")
    private AlarmValve alarmValve;

    @OneToOne
    @JoinColumn(name = "alarm_device_test_id")
    private AlarmDeviceTest alarmDeviceTest;
}
