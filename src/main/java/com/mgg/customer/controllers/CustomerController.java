package com.mgg.customer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mgg.customer.beans.Customer;
import com.mgg.customer.repositories.CustomerRepository;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAll() {
		List<Customer> list = customerRepository.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getById(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<>(customerRepository.getReferenceById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Customer> save(@RequestBody Customer customer) {
		return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> update(@PathVariable(name = "id") Long id, @RequestBody Customer customer) {
		return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
		customerRepository.delete(customerRepository.getReferenceById(id));
		return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
	}

}
