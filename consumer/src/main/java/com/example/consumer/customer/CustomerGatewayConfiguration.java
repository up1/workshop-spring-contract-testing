package com.example.consumer.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerGatewayConfiguration {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    CustomerGateway client(RestTemplate restTemplate) {
        return new CustomerGateway(restTemplate);
    }
}
