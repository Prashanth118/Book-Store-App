package com.prashanthIt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prashanthIt.entity.Customer;
import com.prashanthIt.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService cService;

	@GetMapping({ "/", "loadForm" })
	public String loadForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "home";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes attribute) {
		boolean save = cService.registerCustomer(customer);
		if (save) {
			if (customer.getCustomerId() != null) {
				attribute.addFlashAttribute("SuccMsg", "Updated the customer details");
			} else {
				attribute.addFlashAttribute("SuccMsg", "Your registration successfull");
			}
		} else {
			attribute.addFlashAttribute("errMsg", "Unable to register");
		}
		return "redirect:loadForm";
	}

	@GetMapping("/getCustomerList")
	public String getAllCustomers(Model model) {
		List<Customer> list = cService.retrieveAllCustomers();
		model.addAttribute("customerList", list);
		return "customerList";
	}

	@GetMapping("/updatedCustomer/{customerId}")
	public String updateCustomerDetails(@PathVariable("customerId") Integer customerId, Model model) {
		Customer customer = cService.getCustomerById(customerId);
		model.addAttribute("customer", customer);
		return "edit";
	}
	
	@GetMapping("/deleteCustomer/{customerId}")
	public String deleteCustomer(@PathVariable("customerId") Integer customerId,RedirectAttributes attribute) {
		boolean delete = cService.deleteCustomerById(customerId);
		if(delete) {
			attribute.addFlashAttribute("succMsg", "Deleted Successfully");
		}else {
			attribute.addFlashAttribute("errMsg", "Unable to delete");
		}
		return "redirect:/getCustomerList";
	}
}
