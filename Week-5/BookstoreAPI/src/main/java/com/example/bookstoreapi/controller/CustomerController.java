package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    // Exercise 4: POST method to register a new customer using JSON request body
    @PostMapping
    public Customer registerCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    // GET method to retrieve all customers (for testing purposes)
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customers;
    }
}