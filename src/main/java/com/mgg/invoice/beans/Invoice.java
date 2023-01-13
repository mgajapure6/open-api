package com.mgg.invoice.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mgg.customer.beans.Customer;

@Entity
@Table
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String num;

	@Column
	private String date;
	@Column
	private String posoNum;
	@Column
	private String dueDate;
	@Column
	private String totalAmt;
	@Column
	private String discountAmt;
	@Column
	private String taxableAmt;
	@Column
	private String taxAmt;
	@Column
	private String recipientDesc;
	@Column
	private String status; // P=for paid, U=for unpaid, h=for half or partial paid

	@ManyToOne
	@JsonIgnore
	private Customer customer;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "invoice_invoiceProduct", joinColumns = {
			@JoinColumn(name = "invoice_id") }, inverseJoinColumns = { @JoinColumn(name = "invoiceProduct_id") })
	private Set<InvoiceProduct> products;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "invoice_invoicePayment", joinColumns = {
			@JoinColumn(name = "invoice_id") }, inverseJoinColumns = { @JoinColumn(name = "invoicePayment_id") })
	private Set<InvoicePayment> payments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPosoNum() {
		return posoNum;
	}

	public void setPosoNum(String posoNum) {
		this.posoNum = posoNum;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getDiscountAmt() {
		return discountAmt;
	}

	public void setDiscountAmt(String discountAmt) {
		this.discountAmt = discountAmt;
	}

	public String getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(String taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public String getTaxAmt() {
		return taxAmt;
	}

	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}

	public String getRecipientDesc() {
		return recipientDesc;
	}

	public void setRecipientDesc(String recipientDesc) {
		this.recipientDesc = recipientDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<InvoiceProduct> getProducts() {
		return products;
	}

	public void setProducts(Set<InvoiceProduct> products) {
		this.products = products;
	}

	public Set<InvoicePayment> getPayments() {
		return payments;
	}

	public void setPayments(Set<InvoicePayment> payments) {
		this.payments = payments;
	}

}
