package com.prashanthIt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashanthIt.entity.Category;
import com.prashanthIt.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public boolean addBookCategory(Category category) {
		Category save = categoryRepo.save(category);
		return save.getCategoryId() != null;
	}

	@Override
	public List<Category> getAllBooksCategory() {

		return categoryRepo.findAll();
	}

	@Override
	public Category getBookCatgoryById(Integer categoryId) {
		Optional<Category> findById = categoryRepo.findById(categoryId);
		if (findById.isPresent()) {
			Category category = findById.get();
			return category;
		}
		return null;
	}

	@Override
	public boolean deleteBookCategoryById(Integer categoryId) {
		categoryRepo.deleteById(categoryId);
		return true;
	}


}
