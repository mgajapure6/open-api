package com.mgg.invoice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mgg.invoice.beans.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long>, JpaRepository<Invoice, Long> {

}
