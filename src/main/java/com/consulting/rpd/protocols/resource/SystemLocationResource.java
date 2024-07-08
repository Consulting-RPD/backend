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
public class SystemLocationResource {
    private Long systemLocationId;
    private String name;
    private String feedingBuilding;
}
