package com.prashanthIt.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prashanthIt.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Serializable> {

}
