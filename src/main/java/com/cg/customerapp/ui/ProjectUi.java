package com.cg.customerapp.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.customerapp.entities.Customer;
import com.cg.customerapp.service.ICustomerService;


@Component
public class ProjectUi {
	@Autowired
	private ICustomerService service;

	public void run()
	{
		Customer customer = add("A");
		Customer customer1 = add("B");
		Customer customer2= add( "C");
		Long id1 = customer.getId();
		System.out.println("Before update: "+customer.toString());
		customer = update(id1, "C1");
		System.out.println("After update: "+customer.toString());
		System.out.println("Before update: "+customer1.toString());
		Long id2 = customer1.getId();
		customer1 = update(id2, "C2");
		System.out.println("After update: "+customer1.toString());
		System.out.println(customer2.toString());
	}
	
	public Customer add(String name)
	{
		Customer customer = new Customer(name);
		customer = service.register(customer);
		return customer;
	}
	
	public Customer update(Long id, String newName)
	{
		return service.updateName(id, newName);
	}
	
}
