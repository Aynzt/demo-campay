package com.cdc.democampay.services;

import com.cdc.democampay.services.valueobjects.PaymentLinkData;
import com.cdc.democampay.thirdparty.valueobjects.WebhookResponse;

public interface PaymentService {
    String fetchPaymentLink(PaymentLinkData data);

    void handleHook(WebhookResponse response);
}
