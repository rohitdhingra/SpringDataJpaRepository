package com.example.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.entities.Customer;

@Service
public class CustomerService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public long insert(Customer customer)
	{
		entityManager.persist(customer);
		return customer.getId();
	}
	
}
