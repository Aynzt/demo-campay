package com.cdc.democampay.application;

import com.cdc.democampay.thirdparty.valueobjects.WebhookResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("webhooks")
@Slf4j
public class WebhookResource {

    @PostMapping("campay")
    void handleCampayEvents(@RequestBody WebhookResponse response) {
        log.info(response.toString());
    }

}
