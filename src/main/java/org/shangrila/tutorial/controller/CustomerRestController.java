package org.shangrila.tutorial.controller;

import java.util.List;

import org.shangrila.tutorial.model.Customer;
import org.shangrila.tutorial.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomerRepository repository;
	
	@RequestMapping("customer/")
	public List<Customer> findAll(){
		final List<Customer> customers = repository.findAll();
		log.info("Fetching customers from database {}" , customers);
		return customers;
	}
	
	@RequestMapping(value = "customer/" , method = RequestMethod.POST)
	public void save(@RequestBody Customer customer){
		log.info("Storing customer in database {}", customer);
		repository.save(customer);
	}
	
}
