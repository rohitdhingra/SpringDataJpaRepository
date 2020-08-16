package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByLastName(String lastName);

	Customer findById(long id);
}
