package org.itstep.country;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Country {
    private Long id;
    private String name;
    private String iso3;
    private String numericCode;
    private String iso2;
    private String phonecode;
    private String capital;
    private String currency;
    private String currencyName;
    private String currencySymbol;
    private String tld;
    private String native2;
    private String region;
    private String subregion;
    private String timezones;
    private String translations;
    private Double latitude;
    private Double longitude;
    private String emoji;
    private String emojiu;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer flag;
    private String wikidataid;
}
