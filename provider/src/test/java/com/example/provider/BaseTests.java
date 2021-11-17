package com.example.provider;

import com.example.provider.customers.Customer;
import com.example.provider.customers.CustomerRepository;
import com.example.provider.customers.CustomerRestController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@SpringBootTest (classes = ProviderApplication.class)
class BaseTests {

	@Autowired
	private CustomerRestController customerRestController;

	@MockBean
	private CustomerRepository customerRepository;

	@BeforeEach
	public void before() {
		when(this.customerRepository.findAll())
				.thenReturn(Arrays.asList(new Customer(1L, "Test 01"), new Customer(2L, "Test 02")));
		RestAssuredMockMvc.standaloneSetup(this.customerRestController);
	}

}
