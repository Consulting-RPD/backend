package com.consulting.rpd.protocols.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "alarmDeviceTest")
public class AlarmDeviceTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 50)
    private String location;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 50)
    private String supervisedSectorization;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 50)
    private String panelSignal;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 50)
    private String deviceType;

    @NotNull
    private Integer operationTimeMinutes;

    @NotNull
    private Integer operationTimeSeconds;

    //Relationships
    @OneToOne
    @JoinColumn(name = "alarm_valve_id")
    private AlarmValve alarmValve;
}
