package com.example.bookshop.controllers;
import com.example.bookshop.services.AuthorService;
import com.example.bookshop.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AutherController {

    @Autowired
    AuthorService AuhtorComp;
    //http://localhost:8080/authors/all
    @RequestMapping(value = "/all")
    public List<Author> GetAuthors()
    {
        return AuhtorComp.GetAuthors();
    }
    //http://localhost:8080/authors/deleteAuthor/{AuthorID}
    @RequestMapping(method = RequestMethod.DELETE,value = "/deleteAuthor/{AuthorID}")
    public void DeleteAuhtor(@PathVariable Integer AuthorID, @RequestHeader)
    {

        System.out.println("dELETE 2 "+AuthorID);
        AuhtorComp.DeleteAuthor(AuthorID);
        System.out.println("dELETE 3 "+AuthorID);
    }
    //http://localhost:8080/authors/addAuthor
    @RequestMapping(method = RequestMethod.POST,value = "/addAuthor/")
    public void AddAuthor(@RequestBody Author Author) {
        AuhtorComp.addAuthor(Author);
    }

}
