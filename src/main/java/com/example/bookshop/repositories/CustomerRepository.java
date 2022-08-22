package com.example.bookshop.repositories;

import com.example.bookshop.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByBooksId(Integer bookId);
}
