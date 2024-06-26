package com.consulting.rpd.protocols.domain.model;

import com.consulting.rpd.projects.domain.model.Project;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@With
@Entity
@Table(name = "protocol_header")
public class ProtocolHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String protocolNumber;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 25)
    private String protectedArea;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 250)
    private String address;

    @NotNull
    private Integer type;

    @NotNull
    private Date date;

    //Relationships
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    @JsonIgnore
    private Project project;

    @OneToOne(mappedBy = "protocolHeader", cascade = CascadeType.ALL)
    private Documentation documentation;
}
