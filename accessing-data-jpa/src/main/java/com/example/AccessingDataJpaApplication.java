package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);
	
	@Autowired
	private CustomerService customerService;
	
	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository)
	{
		return (args) ->{
			customerService.insert(new Customer("Jack","Bauer"));
			
//			repository.save(new Customer("Jack","Bauer"));
			repository.save(new Customer("Rahul","Dhingra"));
			repository.save(new Customer("Rohit","Dhingra"));
			repository.save(new Customer("Anchal","Dhingra"));
			repository.save(new Customer("Gargi","Dhingra"));
			
			log.info("Customer found with findAll method");
			for(Customer customer: repository.findAll())
			{
				log.info(customer.toString());
			}
			log.info("Customer found with findById method");
			Customer cust = repository.findById(1);
			log.info(cust.toString());
			
			log.info("Customer found with LastName method");
			repository.findByLastName("Dhingra").forEach(obj -> log.info(obj.toString()));
//			log.info(cust.toString());
			
		};
		
		
	}

}
