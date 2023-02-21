package com.prashanthIt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashanthIt.entity.BookOrder;
import com.prashanthIt.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Override
	public boolean saveOrderDetails(BookOrder order) {
		BookOrder save = orderRepo.save(order);
		return save.getOrderId() != null;
	}

	@Override
	public List<BookOrder> getAllOrderDetails() {
		return orderRepo.findAll();
	}

	@Override
	public BookOrder findOrderById(Integer orderId) {
		Optional<BookOrder> getOrderById = orderRepo.findById(orderId);
		if (getOrderById.isPresent()) {
			BookOrder bookOrder = getOrderById.get();
			return bookOrder;
		}
		return null;
	}

	@Override
	public boolean deleteOrderById(Integer orderId) {
		orderRepo.deleteById(orderId);
		return true;
	}

}
