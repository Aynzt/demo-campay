package com.cdc.democampay.thirdparty;

import com.cdc.democampay.thirdparty.valueobjects.LinkData;
import com.cdc.democampay.thirdparty.valueobjects.LinkResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
@Slf4j
public class CampayClientImpl implements CampayClient {

    @Value("${provider.campay.token}")
    private String token;
    @Value("${provider.campay.baseUrl}")
    private String baseUrl;

    @Override
    public Optional<String> getPaymentLink(LinkData linkData) {
        try {
            RestClient restClient = RestClient.builder()
                    .defaultHeader(HttpHeaders.AUTHORIZATION, "Token " + token)
                    .build();

            URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
                    .pathSegment("get_payment_link")
                    .build()
                    .toUri();

            ResponseEntity<LinkResponse> response = restClient.post()
                    .uri(uri)
                    .body(linkData)
                    .retrieve()
                    .toEntity(LinkResponse.class);

            if (response.getBody() == null)
                return Optional.empty();

            return Optional.of(response.getBody().link());
        } catch (RestClientResponseException e) {
            log.error(e.getMessage(), e);
            return Optional.empty();
        }
    }
}
