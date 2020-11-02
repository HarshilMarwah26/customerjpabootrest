package com.cg.customerapp.controllers;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.customerapp.dto.CreateCustomerRequest;
import com.cg.customerapp.dto.CustomerDetails;
import com.cg.customerapp.dto.UpdateCustomerRequest;
import com.cg.customerapp.entities.Customer;
import com.cg.customerapp.service.ICustomerService;

@RequestMapping("/customers")
@RestController
public class CustomerController {
	
	@Autowired
    private ICustomerService service;
	
	
	@ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public CustomerDetails add(@RequestBody CreateCustomerRequest requestData) {
        Customer customer = new Customer(requestData.getName());
        customer = service.register(customer);
        CustomerDetails details = toDetails(customer);
        return details;
    }

    @PutMapping("/update")
    public CustomerDetails update(@RequestBody UpdateCustomerRequest requestData) {
        Customer customer = new Customer(requestData.getName());
        customer.setId(requestData.getId());
        customer = service.updateName(customer.getId(),customer.getName());
        CustomerDetails details = toDetails(customer);
        return details;
    }
    
    @GetMapping("/get/{id}")
    public CustomerDetails fetchCustomer(@PathVariable("id") Long id) {
        Customer customer = service.findById(id);
        CustomerDetails details = toDetails(customer);
        return details;
    }

    @GetMapping
    public List<CustomerDetails> fetchAll() {
        List<Customer> customer = service.findAll();
        // List<StudentDetails>response= students.stream().map(student->toDetails(student)).collect(Collectors.toList());
        List<CustomerDetails> response = toDetails(customer);
        return response;
    }
    public List<CustomerDetails> toDetails(Collection<Customer> customers) {
        List<CustomerDetails> desired = new ArrayList<>();
        for (Customer customer : customers) {
        	CustomerDetails details = toDetails(customer);
            desired.add(details);
        }
        return desired;
    }
    
    
    public CustomerDetails toDetails(Customer customer) {
    	CustomerDetails details = new CustomerDetails(customer.getId(), customer.getName());
        return details;
    }
}
