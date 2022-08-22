package com.example.bookshop.services;

import com.example.bookshop.repositories.BookRepository;
import com.example.bookshop.repositories.CustomerRepository;
import com.example.bookshop.exceptions.AllException;
import com.example.bookshop.models.Book;
import com.example.bookshop.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    BookRepository bookRepository;
    public List<Customer> GetAllCustomer()
    {
        return customerRepository.findAll();
    }

    public void DeleteCustomerById(Integer CustomerId)
    {
        customerRepository.deleteById(CustomerId);
    }

    public Customer addCustomer(Customer customer)
    {
       return customerRepository.save(customer);
    }

    public void BuyBookByCustomer(Integer customerId, Integer bookId) {
         try {
             Customer customer = customerRepository.findById(customerId).get();
             Book book = bookRepository.findById(bookId).get();
             customer.addBookToList(book);
             customerRepository.save(customer);
         }
         catch (NoSuchElementException e)
         {
             throw new AllException("Not Found222");
         }

    }

    public List<Book> GetCustomerBooks(Integer customerId) {
        return customerRepository.findById(customerId).get().getBooks();
    }

    public List<Customer> GetBookCustomers(Integer bookId) {
        return customerRepository.findAllByBooksId(bookId);
    }
}
