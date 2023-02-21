package com.prashanthIt.service;

import java.util.List;

import com.prashanthIt.entity.BookOrder;

public interface OrderService {

	public boolean saveOrderDetails(BookOrder order);

	public List<BookOrder> getAllOrderDetails();

	public BookOrder findOrderById(Integer orderId);

	public boolean deleteOrderById(Integer orderId);
}
