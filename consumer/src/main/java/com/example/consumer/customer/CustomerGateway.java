package com.example.consumer.customer;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CustomerGateway {
    private final RestTemplate restTemplate;

    public CustomerGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Customer> getAllCustomers() {

        ParameterizedTypeReference<List<Customer>> ptr =
                new ParameterizedTypeReference<List<Customer>>() {
                };

        ResponseEntity<List<Customer>> responseEntity =
                this.restTemplate.exchange("http://localhost:8081/customers", HttpMethod.GET, null, ptr);

        return responseEntity.getBody();
    }
}
