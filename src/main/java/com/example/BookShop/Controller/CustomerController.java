package com.example.BookShop.Controller;

import com.example.BookShop.component.CustomerComponent;
import com.example.BookShop.model.Book;
import com.example.BookShop.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerComponent CustomerComp;

    @RequestMapping(value = "/Customers")
    public List<Customer> GetAllCustomers()
    {
        return CustomerComp.GetAllCustomer();
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/DeleteCustomer/{CustomerId}",method = RequestMethod.DELETE)
    public void DeleteCustomer(@PathVariable Integer CustomerId)
    {
         CustomerComp.DeleteCustomerById(CustomerId);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/Customers/{CustomerId}/Books")
    public List<Book> GetCustomerBooks(@PathVariable Integer CustomerId) {
        return CustomerComp.GetCustomerBooks(CustomerId);          //cutomer for specific book
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/Customers/Books/{BookId}")
    public List<Customer> GetBookCustomer(@PathVariable Integer BookId)
    {
        return CustomerComp.GetBookCustomers(BookId);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/CreateCustomer",method = RequestMethod.POST)
    public Customer AddCustomer(@RequestBody Customer customer)
    {
        return CustomerComp.addCustomer(customer);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/Customer/{CustomerId}/BuyBook/{BookId}")
    public void BuyBook(@PathVariable Integer CustomerId,@PathVariable Integer BookId) {

        CustomerComp.BuyBookByCustomer(CustomerId,BookId);
    }
}
