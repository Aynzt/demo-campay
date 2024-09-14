package com.cdc.democampay.thirdparty.valueobjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollectData {
    private int amount;
    private String currency = "XAF";
    private String from;
    private String description;
    @JsonProperty("external_reference")
    private String reference;
}
