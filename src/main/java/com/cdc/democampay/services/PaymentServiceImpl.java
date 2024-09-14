package com.cdc.democampay.services;

import com.cdc.democampay.services.valueobjects.PaymentLinkData;
import com.cdc.democampay.thirdparty.CampayClient;
import com.cdc.democampay.thirdparty.valueobjects.LinkData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Value("${provider.campay.redirectUrl}")
    private String redirectURl;

    private final CampayClient campayClient;

    public PaymentServiceImpl(CampayClient campayClient) {
        this.campayClient = campayClient;
    }

    @Override
    public String fetchPaymentLink(PaymentLinkData data) {
        return campayClient.getPaymentLink(new LinkData()
                        .setPaymentMethod("MOMO")
                        .setAmount(data.amount())
                        .setCurrency("XAF")
                        .setReference(UUID.randomUUID().toString())
                        .setRedirectUrl(redirectURl)
                        .setFailedRedirectUrl(redirectURl))
                .orElseThrow();
    }
}
