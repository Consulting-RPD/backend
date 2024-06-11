package com.consulting.rpd.protocols.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "protocol_header")
public class ProtocolHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 25)
    private String protected_area;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 35)
    private String address;

    @NotNull
    @NotBlank
    private int type;

    @NotNull
    @NotBlank
    private Date date;

    @NotNull
    @NotBlank
    private Time hour;

    //Relationships
}
