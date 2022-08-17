package com.example.BookShop.Controller;

import com.example.BookShop.component.AuthorComponent;
import com.example.BookShop.model.Author;
import com.example.BookShop.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutherController {

    @Autowired
    AuthorComponent AuhtorComp;

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
