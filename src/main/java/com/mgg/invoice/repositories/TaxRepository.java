package com.mgg.invoice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mgg.invoice.beans.Tax;

@Repository
public interface TaxRepository extends CrudRepository<Tax, Long>, JpaRepository<Tax, Long> {

}
