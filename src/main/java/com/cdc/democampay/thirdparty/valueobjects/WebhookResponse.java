package com.cdc.democampay.thirdparty.valueobjects;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebhookResponse {
    private String status;
    private String reference;
    private String amount;
    private String currency;
    private String operator;
    private String code;
    @JsonAlias("operator_reference")
    private String operatorReference;
    private String signature;
    private String endpoint;
    @JsonAlias("external_reference")
    private String externalReference;
    @JsonAlias("external_user")
    private String externalUser;
    @JsonAlias("extra_first_name")
    private String extraFirstName;
    @JsonAlias("extra_last_name")
    private String extraLastName;
    @JsonAlias("extra_email")
    private String extraEmail;
    @JsonAlias("phone_number")
    private String phone;
}
