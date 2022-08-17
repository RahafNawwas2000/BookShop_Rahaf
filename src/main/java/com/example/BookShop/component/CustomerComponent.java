package com.example.BookShop.component;

import com.example.BookShop.JPA.BookJPA;
import com.example.BookShop.JPA.CustomerJPA;
import com.example.BookShop.exception.AllException;
import com.example.BookShop.model.Book;
import com.example.BookShop.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class CustomerComponent {

    @Autowired
    CustomerJPA customerJPA;
    @Autowired
    BookJPA bookJPA;
    public List<Customer> GetAllCustomer()
    {
        return customerJPA.findAll();
    }

    public void DeleteCustomerById(Integer CustomerId)
    {
        customerJPA.deleteById(CustomerId);
    }

    public Customer addCustomer(Customer customer)
    {
       return customerJPA.save(customer);
    }

    public void BuyBookByCustomer(Integer customerId, Integer bookId) {
         try {
             Customer customer = customerJPA.findById(customerId).get();
             Book book = bookJPA.findById(bookId).get();
             customer.addBookToList(book);
             customerJPA.save(customer);
         }
         catch (NoSuchElementException e)
         {
             throw new AllException("Not Found222");
         }

    }

    public List<Book> GetCustomerBooks(Integer customerId) {
        return customerJPA.findById(customerId).get().getBooks();
    }

    public List<Customer> GetBookCustomers(Integer bookId) {
        return customerJPA.findAllByBooksId(bookId);
    }
}
