package com.example.provider.customers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerRestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private CustomerRepository customerRepository;

    @BeforeEach
    public void initialDependencies() {
        when(this.customerRepository.findAll())
                .thenReturn(Arrays.asList(new Customer(1L, "Test 01"), new Customer(2L, "Test 02")));
    }

    @Test
    public void getAllCustomers() {
        Customer[] customers = restTemplate.getForObject("/customers", Customer[].class);
        assertEquals(2, customers.length, "Size of customer");
    }
}