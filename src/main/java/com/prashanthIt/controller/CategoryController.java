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

import com.prashanthIt.entity.Category;
import com.prashanthIt.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService service;

	@GetMapping("/loadCategoryForm")
	public String loadCategoryForm(Model model) {
		model.addAttribute("category", new Category());
		return "categoryHome";
	}

	@PostMapping("/addBookCategory")
	public String saveBookCategory(RedirectAttributes model, @ModelAttribute("category") Category category) {
		boolean addBookCategory = service.addBookCategory(category);
		if (addBookCategory) {
			model.addFlashAttribute("succMsg", "Successfully saved");
		} else {
			model.addFlashAttribute("errMsg", "Unable to save category");
		}
		return "redirect:/loadCategoryForm";
	}

	@GetMapping("/booksCategoryList")
	public String retrieveAllBooksCategory(Model model) {
		List<Category> categoryList = service.getAllBooksCategory();
		model.addAttribute("categoryList", categoryList);
		return "categoryList";
	}

	@GetMapping("/editBookCategory/{categoryId}")
	public String editCategoryDetails(@PathVariable("categoryId") Integer categoryId, Model model) {
		Category bookCategory = service.getBookCatgoryById(categoryId);
		model.addAttribute("bookCategory", bookCategory);
		return "editCategory";
	}

	@GetMapping("/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") Integer categoryId, RedirectAttributes attribute) {
		boolean delete = service.deleteBookCategoryById(categoryId);
		if (delete) {
			attribute.addFlashAttribute("succMsg", "Deleted");
		} else {
			attribute.addFlashAttribute("errMsg", "UnDelete");
		}
		return "redirect:/booksCategoryList";
	}
}
