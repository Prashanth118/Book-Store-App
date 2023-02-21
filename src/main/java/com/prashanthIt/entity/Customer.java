package com.prashanthIt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CUSTOMER_BOOK_TBL_DTLS")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "CUSTOMER_ID")
	private Integer customerId;
	@Column(name = "CUSTOMER_NAME")
	private String customerFullName;
	@Column(name = "CUSTOMER_EMAIL")
	private String customerEmail;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "ZIP_CODE")
	private Integer zipCode;
	@Column(name = "REGISTERED_DATE")
	private String registeredDate;
}
