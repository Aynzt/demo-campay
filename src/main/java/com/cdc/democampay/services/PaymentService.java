package com.cdc.democampay.services;

import com.cdc.democampay.services.valueobjects.PaymentLinkData;

public interface PaymentService {
    String fetchPaymentLink(PaymentLinkData data);
}
