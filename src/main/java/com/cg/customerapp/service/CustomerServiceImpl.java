package com.cg.customerapp.service;

import java.util.List;

import com.cg.customerapp.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.customerapp.entities.Customer;
import com.cg.customerapp.repository.ICustomerRepository;

@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository repository;

	@Override
	public Customer findById(Long id) {
		Customer customer = repository.findById(id);
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> list = repository.findAll();
		return list;
	}

	@Override
	public Customer register(Customer customer) {
		ValidationUtil.checkArgumentNotNull(customer);
		ValidationUtil.checkName(customer.getName());
		customer = repository.add(customer);
		return customer;
	}

	@Override
	public Customer updateName(Long id, String name) {
		ValidationUtil.checkName(name);
		Customer customer = repository.findById(id);
		customer.setName(name);
		customer = repository.update(customer);
		return customer;
	}

}
