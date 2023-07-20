package org.itstep.city;

import lombok.Data;

@Data
public class CityState {
    private Long id;
    private String name;
    private String stateName;
    private Double latitude;
    private Double longitude;
}
