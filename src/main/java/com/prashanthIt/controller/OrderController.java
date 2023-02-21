package com.prashanthIt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prashanthIt.entity.BookOrder;
import com.prashanthIt.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService service;

	@GetMapping({ "/loadOrderForm" })
	public String loadOrderForm(Model model) {
		model.addAttribute("bookOrder", new BookOrder());
		return "orderForm";
	}

	@PostMapping("/saveOrderDetails")
	public String saveOrder(@ModelAttribute("bookOrder") BookOrder bookOrder, RedirectAttributes attribute) {
		boolean saveOrderDetails = service.saveOrderDetails(bookOrder);
		if (saveOrderDetails) {
			attribute.addFlashAttribute("successMsg", "Order details saved successfully");
		} else {
			attribute.addFlashAttribute("errorMsg", "Unable to save order details");
		}

		return "redirect:loadOrderForm";
	}
}
