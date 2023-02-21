package com.prashanthIt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashanthIt.entity.BookDetails;
import com.prashanthIt.repository.BookDetailsRepository;

@Service
public class BookDetailsServiceImpl implements BookDetailsService {

	@Autowired
	private BookDetailsRepository bookRepo;

	@Override
	public boolean saveBook(BookDetails book) {
		BookDetails save = bookRepo.save(book);
		return save.getBookId() != null;
	}

	@Override
	public List<BookDetails> getAllBookRecords() {
		return bookRepo.findAll();
	}

	@Override
	public BookDetails getBookById(Integer bookId) {
		Optional<BookDetails> findById = bookRepo.findById(bookId);
		if (findById.isPresent()) {
			BookDetails bookDetails = findById.get();
			return bookDetails;
		}
		return null;
	}

	@Override
	public boolean deleteBookById(Integer bookId) {
		bookRepo.deleteById(bookId);
		return true;
	}

}
