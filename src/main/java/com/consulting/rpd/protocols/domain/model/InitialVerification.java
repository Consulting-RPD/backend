package com.consulting.rpd.protocols.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@With
@Entity
@Table(name = "initial_verification")
public class InitialVerification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Integer equipmentListed;

    @Column(nullable = true)
    private Integer oilLevel;

    @Column(nullable = true)
    private Integer coolingValves;

    @Column(nullable = true)
    private Integer batteryLevel;


    @Column(nullable = true)
    private Integer engineHeaters;

    @Column(nullable = true)
    private Integer waterReserve;

    @Column(nullable = true)
    private Integer exhaustLine;

    @Column(nullable = true)
    private Integer pumpBaseGrouted;

    @Column(nullable = true)
    private Integer motorPumpoAligned;

    @Column(nullable = true)
    private Integer traiendPersonnel;

    @Column(nullable = true)
    private String lastPumpStart;
    
    @Column(nullable = true)
    private String hourmeterReading;

    @Column(nullable = true)
    private Integer partsProtected;

    //Relationship
    @OneToOne
    @JoinColumn(name = "protocol_header_id")
    private ProtocolHeader protocolHeader;
}
