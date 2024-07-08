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
@Table(name = "sprinklers")
public class Sprinkler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)    
    private String brand;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)   
    private String model;

    @NotNull
    private Integer productionYear;

    @NotNull
    private Integer kFactor;

    @NotNull
    private Integer quantity;

    @NotNull
    private Float temperature;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 80)   
    private String answer;

    //Relationships
    @OneToOne
    @JoinColumn(name = "protocol_header_id")
    private ProtocolHeader protocolHeader;
}
