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

import com.prashanthIt.entity.BookDetails;
import com.prashanthIt.entity.Category;
import com.prashanthIt.service.BookDetailsService;
import com.prashanthIt.service.CategoryService;

@Controller
public class BookDetailsController {

	@Autowired
	private BookDetailsService bookService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/loadBookForm")
	public String loadBookForm(Model model) {
		List<Category> category = categoryService.getAllBooksCategory();
		model.addAttribute("category", category);
		model.addAttribute("bookDetails", new BookDetails());
		return "bookHome";
	}

	@PostMapping("/saveBookDetails")
	public String addBookDetails(@ModelAttribute("bookDetails") BookDetails bookDetails, RedirectAttributes model) {
		boolean saveBook = bookService.saveBook(bookDetails);
		if (saveBook) {
			model.addFlashAttribute("successMsg", "Book Record saved");
		} else {
			model.addFlashAttribute("errorMsg", "unable to save record");
		}
		return "redirect:/loadBookForm";
	}

	@GetMapping("/getAllBookRecords")
	public String retrieveAllBookRecords(Model model) {
		List<BookDetails> bookList = bookService.getAllBookRecords();
		model.addAttribute("bookList", bookList);
		return "bookList";
	}

	@GetMapping("/editBook/{bookId}")
	public String editBookById(@PathVariable("bookId") Integer bookId, Model model) {
		BookDetails bookDetails = bookService.getBookById(bookId);
		model.addAttribute("bookDetails", bookDetails);
		return "editBook";
	}

	@GetMapping("/deleteBook/{bookId}")
	public String deleteBookById(@PathVariable("bookId") Integer bookId,RedirectAttributes attribute) {
		boolean deleteBook = bookService.deleteBookById(bookId);
		if(deleteBook){
			attribute.addFlashAttribute("successMsg", "Record Deleted");
		} else {
			attribute.addFlashAttribute("errorMsg", "unable to delete record");
		}
		return "redirect:/getAllBookRecords";
	}
}
