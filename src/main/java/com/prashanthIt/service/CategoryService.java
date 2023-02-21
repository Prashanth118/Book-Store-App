package com.prashanthIt.service;

import java.util.List;

import com.prashanthIt.entity.Category;

public interface CategoryService {

	public boolean addBookCategory(Category category);

	public List<Category> getAllBooksCategory();

	public Category getBookCatgoryById(Integer categoryId);

	public boolean deleteBookCategoryById(Integer categoryId);
}
