package com.cdc.democampay.application;

import com.cdc.democampay.services.PaymentService;
import com.cdc.democampay.thirdparty.valueobjects.WebhookResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("webhooks")
@Slf4j
public class WebhookResource {

    private final PaymentService paymentService;

    public WebhookResource(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("campay")
    void handleCampayEvents(WebhookResponse response) {
        paymentService.handleHook(response);
    }

}
