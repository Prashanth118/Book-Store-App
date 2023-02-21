package com.prashanthIt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashanthIt.entity.BookDetails;

public interface BookDetailsRepository extends JpaRepository<BookDetails, Integer> {

}
