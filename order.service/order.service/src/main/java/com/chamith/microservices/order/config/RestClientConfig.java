package com.chamith.microservices.order.config;

import com.chamith.microservices.order.client.InventoryClient;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

    @Value("${inventory.url}")
    private String inventoryServiceUrl;
    private final ObservationRegistry observationRegistry;

    public RestClientConfig(ObservationRegistry observationRegistry) {
        this.observationRegistry = observationRegistry;
    }

    @Bean
    public InventoryClient inventoryClientClient() {
        RestClient restClient = RestClient.builder().baseUrl(inventoryServiceUrl).
//                requestFactory(getClientRequestFactor()).
                observationRegistry(observationRegistry).
                build();
        var restClientAdapter = RestClientAdapter.create(restClient);
        var httpServiceProxyFactor = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return httpServiceProxyFactor.createClient(InventoryClient.class);
    }

//    private ClientHttpRequestFactory getClientRequestFactor() {
//
//    }
}
