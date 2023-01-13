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

import com.mgg.invoice.beans.Invoice;
import com.mgg.invoice.repositories.InvoiceRepository;

@RestController
@RequestMapping(value = "/invoices")
public class InvoiceController {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@GetMapping
	public ResponseEntity<List<Invoice>> getAll() {
		List<Invoice> list = invoiceRepository.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Invoice> getById(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<>(invoiceRepository.getReferenceById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Invoice> save(@RequestBody Invoice invoice) {
		return new ResponseEntity<>(invoiceRepository.save(invoice), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Invoice> update(@PathVariable(name = "id") Long id, @RequestBody Invoice invoice) {
		return new ResponseEntity<>(invoiceRepository.save(invoice), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
		invoiceRepository.delete(invoiceRepository.getReferenceById(id));
		return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
	}

}
