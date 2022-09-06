package com.example.bookshop.services;
import com.example.bookshop.exceptions.nullObject;
import com.example.bookshop.exceptions.stockEqualZero;
import com.example.bookshop.repositories.BookRepository;
import com.example.bookshop.repositories.CustomerRepository;
import com.example.bookshop.models.Book;
import com.example.bookshop.models.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    BookRepository bookRepository;
    public List<Customer> GetAllCustomer()
    {
        logger.warn("get all book");
        return customerRepository.findAll();
    }

    public void DeleteCustomerById(Integer CustomerId)
    {
        customerRepository.deleteById(CustomerId);
    }

    public Customer addCustomer(Customer customer)
    {
       customerRepository.saveToUserTable(customer.getId(),customer.getUserName(),customer.getPassword(),true,customer.getRoles());
        //customer.setUser(new Username(customer.getId(),customer.getUsername(),customer.getPassword(),true,customer.getRole()));
       return customerRepository.save(customer);
    }

    public void rentBook(Integer customerId, Integer bookId) {
             logger.info("Customer is going to rent book ...");
             Customer customer = customerRepository.findById(customerId).orElse(null);
             Book book = bookRepository.findById(bookId).orElse(null);

             if (book != null) {
                 if(book.getStock()>0)
                 book.setStock(book.getStock()-1);

                 else {
                     logger.warn("no longer available");
                     throw new stockEqualZero("stock for this book = 0", HttpStatus.BAD_REQUEST, book);
                 }
             }
             else {
                 logger.warn("book not found");
                 throw new nullObject("Book is not found");}
             if (customer != null) {
                 customer.addBookToList(book);
                 customerRepository.save(customer);
             }
             else throw new nullObject("Customer is not found");
    }

    public List<Book> GetCustomerBooks(Integer customerId) {
        return customerRepository.findById(customerId).orElseThrow(() ->new nullObject("not found")).getBooks();
    }

    public List<Customer> GetBookCustomers(Integer bookId) {
        return customerRepository.findAllByBooksId(bookId);
    }

    public void returnBook(int customerId,int bookId){
        customerRepository.findById(customerId).orElseThrow(()->new nullObject("this customer Id does not found ")).getBooks().stream().findFirst().filter(book -> book.getId()==bookId);
    }
}
