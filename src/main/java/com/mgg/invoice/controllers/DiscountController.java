package com.mgg.invoice.controllers;

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

import com.mgg.invoice.beans.Discount;
import com.mgg.invoice.repositories.DiscountRepository;

@RestController
@RequestMapping(value = "/discounts")
public class DiscountController {

	@Autowired
	private DiscountRepository discountRepository;

	@GetMapping
	public ResponseEntity<List<Discount>> getAll() {
		List<Discount> list = discountRepository.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Discount> getById(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<>(discountRepository.getReferenceById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Discount> save(@RequestBody Discount discount) {
		return new ResponseEntity<>(discountRepository.save(discount), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Discount> update(@PathVariable(name = "id") Long id, @RequestBody Discount discount) {
		return new ResponseEntity<>(discountRepository.save(discount), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
		discountRepository.delete(discountRepository.getReferenceById(id));
		return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
	}

}
