package com.example.provider.customers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void test01() {
        customerRepository.save(new Customer(1L, "Fake 01"));
        // Act
        List<Customer> custoners = customerRepository.findAll();
        // Assert
        assertEquals(1, custoners.size());
    }

}