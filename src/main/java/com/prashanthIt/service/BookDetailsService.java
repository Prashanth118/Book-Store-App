package com.prashanthIt.service;

import java.util.List;

import com.prashanthIt.entity.BookDetails;

public interface BookDetailsService {

	public boolean saveBook(BookDetails book);
	
	public List<BookDetails> getAllBookRecords();

	public BookDetails getBookById(Integer bookId);

	public boolean deleteBookById(Integer bookId);
}
