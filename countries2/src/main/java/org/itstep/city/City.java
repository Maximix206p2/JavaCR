package org.itstep.city;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class City {
    private Long id;
    private String name;
    private String stateId;
    private String stateCode;
    private String countryId;
    private String countryCode;
    private Double latitude;
    private Double longitude;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer flag;
    private String wikidataid;
}
