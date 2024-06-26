package com.consulting.rpd.protocols.domain.model;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name = "signatures")
public class Signature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 80)
    private String installerContractor;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 80)
    private String signatureName;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 50)
    private String signatureRepresentative;

    @NotNull
    private Date date;

    //Relationships
    @OneToOne
    @JoinColumn(name = "protocol_header_id")
    private ProtocolHeader protocolHeader;
}
