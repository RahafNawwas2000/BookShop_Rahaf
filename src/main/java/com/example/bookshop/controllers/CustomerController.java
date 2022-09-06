package com.example.bookshop.controllers;

import com.example.bookshop.DTOS.CustomerDTO;
import com.example.bookshop.services.CustomerService;
import com.example.bookshop.models.Book;
import com.example.bookshop.models.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerService CustomerComp;
    @Autowired
    private ModelMapper modelMapper;
    @RequestMapping(value = "/all")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers()
    {
        return new ResponseEntity<List<CustomerDTO>>(CustomerComp.GetAllCustomer().stream().map(customer -> modelMapper.map(customer, CustomerDTO.class)).collect(Collectors.toList()),HttpStatus.OK);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/deleteCustomer/{CustomerId}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer CustomerId)
    {
         CustomerComp.DeleteCustomerById(CustomerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/customers/{CustomerId}/books")
    public ResponseEntity<List<Book>> getCustomerBooks(@PathVariable Integer CustomerId) {
        return new ResponseEntity<List<Book>>(CustomerComp.GetCustomerBooks(CustomerId),HttpStatus.OK);          //cutomer for specific book
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/customers/books/{BookId}")
    public ResponseEntity<List<CustomerDTO>> getBookCustomer(@PathVariable Integer BookId)
    {
        return new ResponseEntity<List<CustomerDTO>>(CustomerComp.GetBookCustomers(BookId).stream().map(customer -> modelMapper.map(customer, CustomerDTO.class)).collect(Collectors.toList()),HttpStatus.OK);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/createCustomer",method = RequestMethod.POST)
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody Customer customer)
    {
         Customer custom=CustomerComp.addCustomer(customer);
         CustomerDTO customerDTO=modelMapper.map(custom, CustomerDTO.class);
         return new ResponseEntity<CustomerDTO>(customerDTO,HttpStatus.CREATED);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/rentBook")
    public void rentBook(@RequestParam("CustomerId") Integer CustomerId,@RequestParam("BookId") Integer BookId) {

        CustomerComp.rentBook(CustomerId,BookId);
    }

    @RequestMapping(value = "/returnBook")
    public void returnBook(@RequestParam("CustomerId") Integer CustomerId,@RequestParam("BookId") Integer BookId) {

        CustomerComp.returnBook(CustomerId,BookId);
    }


}
