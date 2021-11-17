package com.example.consumer.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;
import wiremock.org.apache.http.HttpHeaders;

import java.util.Arrays;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment= WebEnvironment.NONE)
@AutoConfigureWireMock(port = 8081)
public class CustomerGatewayWithMockTest {

    @Autowired
    private CustomerGateway gateway;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllCustomersWithMock() throws Exception {
        stubFor(get(urlEqualTo("/customers"))
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .withBody(jsonForCustomer(
                                        new Customer(1L, "Mock 01"),
                                        new Customer(2L, "Mock 02")))));

        List<Customer> customers = this.gateway.getAllCustomers();
        BDDAssertions.then(customers).size().isEqualTo(2);
        BDDAssertions.then(customers.iterator().next().getId()).isEqualTo(1L);
        BDDAssertions.then(customers.iterator().next().getName()).isEqualTo("Mock 01");
    }

    private String jsonForCustomer(Customer... customers) throws Exception {
        List<Customer> customerList = Arrays.asList(customers);
        return this.objectMapper.writeValueAsString(customerList);
    }
}