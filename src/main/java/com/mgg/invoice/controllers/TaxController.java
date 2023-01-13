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

import com.mgg.invoice.beans.Tax;
import com.mgg.invoice.repositories.TaxRepository;

@RestController
@RequestMapping(value = "/taxes")
public class TaxController {

	@Autowired
	private TaxRepository taxRepository;

	@GetMapping
	public ResponseEntity<List<Tax>> getAll() {
		List<Tax> list = taxRepository.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tax> getById(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<>(taxRepository.getReferenceById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Tax> save(@RequestBody Tax tax) {
		return new ResponseEntity<>(taxRepository.save(tax), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Tax> update(@PathVariable(name = "id") Long id, @RequestBody Tax tax) {
		return new ResponseEntity<>(taxRepository.save(tax), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
		taxRepository.delete(taxRepository.getReferenceById(id));
		return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
	}

}
