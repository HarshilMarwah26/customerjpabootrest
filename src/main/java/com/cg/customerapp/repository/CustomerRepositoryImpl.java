package com.cg.customerapp.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import com.cg.customerapp.entities.Customer;
import com.cg.customerapp.exception.CustomerNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
//@Component
public class CustomerRepositoryImpl implements ICustomerRepository {
	
	
	 @PersistenceContext
	 private EntityManager entityManager;

	

	
	@Override
	public Customer add(Customer customer) {
		entityManager.persist(customer);
		//entityManager.persist(customer);
		return customer;
	}
	
	@Override
	public List<Customer> findAll() {
		String ql="from Customer";
        TypedQuery<Customer>query=entityManager.createQuery(ql,Customer.class);
        List<Customer>list=query.getResultList();
        return list;
	}

	@Override
	public Customer update(Customer customer) {
		boolean success=checkExists(customer.getId());
		if(!success){
            throw new CustomerNotFoundException("Can't update, customer doesn't exist for id="+customer.getId());
        }
        customer = entityManager.merge(customer);
        return customer;
	}
	
	public boolean checkExists(Long id){
        Customer customer = entityManager.find(Customer.class, id);
        boolean result= customer!=null;
        return result;
    }
	
	@Override
	public Customer findById(Long id) {
		Customer customer = entityManager.find(Customer.class, id);
        if (customer == null) {
            throw new CustomerNotFoundException("customer not found for id=" + id);
        }
        return customer;
	}

}
