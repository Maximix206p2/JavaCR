package org.itstep.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ModelJson {
    @JsonProperty("id")
    private String idSymbol;
    private String name;
    @JsonProperty("cyrillic-name")
    private String cyrillicName;
    @JsonProperty("class")
    private String className;
    @JsonProperty("year-from")
    private Integer yearFrom;
    @JsonProperty("year-to")
    private Integer yearTo;
}
