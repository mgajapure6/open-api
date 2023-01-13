package com.mgg.invoice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mgg.invoice.beans.Discount;

@Repository
public interface DiscountRepository extends CrudRepository<Discount, Long>, JpaRepository<Discount, Long> {

}
