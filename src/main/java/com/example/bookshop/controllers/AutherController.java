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
    public List<Author> getAuthors()
    {
      //  System.out.println(jwtUtil.extractUsername(token));
        return AuhtorComp.GetAuthors();
    }
    //http://localhost:8080/authors/deleteAuthor/{AuthorID}
    @RequestMapping(method = RequestMethod.DELETE,value = "/deleteAuthor/{AuthorID}")
    public void deleteAuhtor(@PathVariable Integer AuthorID)
    {
        AuhtorComp.DeleteAuthor(AuthorID);
    }
    //http://localhost:8080/authors/addAuthor
    @RequestMapping(method = RequestMethod.POST,value = "/addAuthor/")
    public void addAuthor(@RequestBody Author Author) {
        AuhtorComp.addAuthor(Author);
    }
    @RequestMapping(value = "/AuthorId")
    public Author getAuthorById(@RequestParam("AuthorId") int AuthorId){
        return AuhtorComp.getAuthorById(AuthorId);
    }

}
