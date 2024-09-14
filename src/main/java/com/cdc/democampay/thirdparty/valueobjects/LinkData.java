package com.cdc.democampay.thirdparty.valueobjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class LinkData {
    private int amount;
    private String currency = "XAF";
    private String from;
    private String description;
    @JsonProperty("external_reference")
    private String reference;
    @JsonProperty("redirect_url")
    private String redirectUrl;
    @JsonProperty("failed_redirect_url")
    private String failedRedirectUrl;
    @JsonProperty("payment_options")
    private String paymentMethod;
}
