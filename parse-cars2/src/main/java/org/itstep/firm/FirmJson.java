package org.itstep.firm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.itstep.model.ModelJson;

import java.util.Set;

@Data
public class FirmJson {
    @JsonProperty("id")
    private String idSymbol;
    private String name;
    @JsonProperty("cyrillic-name")
    private String cyrillicName;
    private boolean popular;
    private String country;
    private Set<ModelJson> models;
}