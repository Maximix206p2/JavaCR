package org.itstep.state;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class State {
    private Long id;
    private String name;
    private String countryId;
    private String countryCode;
    private String fipsCode;
    private String iso2;
    private String type;
    private Double latitude;
    private Double longitude;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer flag;
    private String wikidataid;
}
