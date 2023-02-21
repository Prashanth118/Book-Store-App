package com.prashanthIt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BOOK_ORDER_DETAILS_TBL")
public class BookOrder {

	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	private Integer orderId;
	@Column(name = "ORDERED_DATE")
	private Date orderedDate;
	@Column(name = "SHIPPING_ADDRESS")
	private String shippingAddress;
	@Column(name = "RECIPIENT_NAME")
	private String recipientName;
	@Column(name = "PHONE_NUMBER")
	private Long recipientPhone;
	@Column(name = "PAYMENT_MODE")
	private String paymentMode;
	@Column(name = "TOTAL_AMOUNT")
	private Double totalAmount;
	@Column(name = "ORDER_STATUS")
	private String status;

	/*@ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)
	private Customer customer;*/
}
