package com.example.provider.customers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerRestController.class)
class CustomerRestControllerWithMockMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    void getAllCustomersWithMockMvc() throws Exception {
        mvc.perform(get("/customers").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}