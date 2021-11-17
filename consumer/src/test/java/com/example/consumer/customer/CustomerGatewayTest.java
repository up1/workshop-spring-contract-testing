package com.example.consumer.customer;

import com.example.consumer.ConsumerApplication;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment= WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = "com.example:provider:+:8081", stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class CustomerGatewayTest {

    @Autowired
    private CustomerGateway gateway;

    @Test
    void getAllCustomers() {
        List<Customer> customers = this.gateway.getAllCustomers();
        BDDAssertions.then(customers).size().isEqualTo(2);
        BDDAssertions.then(customers.iterator().next().getId()).isEqualTo(1L);
        BDDAssertions.then(customers.iterator().next().getName()).isEqualTo("Test 01");
    }
}