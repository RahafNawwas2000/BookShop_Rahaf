package com.example.bookshop.controllers;
import com.example.bookshop.services.AuthorService;
import com.example.bookshop.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutherController {

    @Autowired
    AuthorService AuhtorComp;

    @RequestMapping(value = "/Authors")
    public List<Author> GetAuthors()
    {
        return AuhtorComp.GetAuthors();
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/DeleteAuthor/{AuthorID}")
    public void DeleteAuhtor(@PathVariable Integer AuthorID)
    {
        AuhtorComp.DeleteAuthor(AuthorID);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/AddAuthor/")
    public void AddAuthor(@RequestBody Author Author) {
        AuhtorComp.addAuthor(Author);
    }

}
