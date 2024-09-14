package com.cdc.democampay.thirdparty;

import com.cdc.democampay.thirdparty.valueobjects.LinkData;

import java.util.Optional;

public interface CampayClient {
    Optional<String> getPaymentLink(LinkData linkData);
}
