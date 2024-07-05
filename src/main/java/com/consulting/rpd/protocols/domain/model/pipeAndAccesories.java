package com.consulting.rpd.protocols.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Table(name = "pipeAndAccesories")
public class PipeAndAccesories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    @Size(min = 1, max = 25)
    private String pipeType;

    @Column(nullable = true)
    private Integer properInstallation;

    @Column(nullable = true)
    private Integer accessoryType;

    @Column(nullable = true)
    @Size(min = 1, max = 80)
    private String explanation;

    @Column(nullable = true)
    private Integer pipeCleaned;

    @Column(nullable = true)
    private Integer clearOfResidue;

    @Column(nullable = true)
    private Integer approvedForPressures;

    @Column(nullable = true)
    private Integer nozzlesObstructed;

    @Column(nullable = true)
    private Integer accordingToDrawings;

    @Column(nullable = true)
    private Integer leakageTest;

    @Column(nullable = true)
    private Integer supplierCertificate;

    @Column(nullable = true)
    @Size(min = 1, max = 200)
    private String pipesObs;

    @NotNull
    private Integer pipeCleaningCertf;

    @NotNull
    private Integer oilResidueInspection;

    @NotNull
    private Integer pressureApproval;

    @NotNull
    private Integer obstructionCheck;

    @NotNull
    private Integer complianceWithDrawings;

    @NotNull
    private Integer propeInstallationCheck;

    //Relationships
    @OneToOne
    @JoinColumn(name = "protocol_header_id")
    private ProtocolHeader protocolHeader;
}
