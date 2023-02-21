package com.prashanthIt.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashanthIt.entity.BookOrder;

public interface OrderRepository extends JpaRepository<BookOrder, Serializable> {

}
