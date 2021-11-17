package com.example.provider.customers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerRestController {

    private final CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
//        List<Customer> customers = new ArrayList<>();
//        customers.add(new Customer(1L, "Name 01"));
//        customers.add(new Customer(2L, "Name 03"));
//        return customers;
    }

}
