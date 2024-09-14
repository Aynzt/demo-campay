package com.cdc.democampay.application;

import com.cdc.democampay.services.PaymentService;
import com.cdc.democampay.services.valueobjects.PaymentLinkData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payments")
@Slf4j
public class PaymentWebResource {

    private final PaymentService paymentService;

    public PaymentWebResource(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    String fetchPaymentLink(@RequestBody PaymentLinkData data) {
        log.info("Fetching payment link");
        return paymentService.fetchPaymentLink(data);
    }
}
