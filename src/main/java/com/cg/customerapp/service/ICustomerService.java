package com.cg.customerapp.service;

import java.util.List;
import com.cg.customerapp.entities.Customer;

public interface ICustomerService {
	public Customer register(Customer customer);
	public Customer updateName(Long id, String name);
	public Customer findById(Long id);
	List<Customer>findAll();
}
