package com.mgg.product.controllers;

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

import com.mgg.product.beans.Product;
import com.mgg.product.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public ResponseEntity<List<Product>> getAll() {
		List<Product> list = productRepository.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<>(productRepository.getReferenceById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product) {
		return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable(name = "id") Long id, @RequestBody Product product) {
		return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
		productRepository.delete(productRepository.getReferenceById(id));
		return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
	}

}
