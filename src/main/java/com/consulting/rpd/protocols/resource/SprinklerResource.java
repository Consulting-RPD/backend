package com.consulting.rpd.protocols.resource;

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
public class SprinklerResource {
    private Long id;    
    private String brand; 
    private String model;
    private Integer productionYear;
    private Integer kFactor;
    private Integer quantity;
    private Double temperature;
    private String answer;
}
