package com.example.BookShop.JPA;

import com.example.BookShop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerJPA extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByBooksId(Integer bookId);
}
