package com.example.BookShop.component;

import com.example.BookShop.JPA.AuthorJPA;
import com.example.BookShop.exception.AllException;
import com.example.BookShop.model.Author;

import com.example.BookShop.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthorComponent {

    @Autowired
    AuthorJPA authorJPA;
    private final RestTemplate restTemplate = new RestTemplate();
    public void addAuthor(Author Author)
    {
        if(Author.getName()==null)
        {
            throw new AllException("The name is empty",HttpStatus.BAD_REQUEST,Author);
        }
        authorJPA.save(Author);
    }
    public void DeleteAuthor(Integer id) {
       try {
           restTemplate.delete("http://localhost:8080/DeleteAuthorBooks/" + id);
           authorJPA.deleteById(id);
       }catch (EmptyResultDataAccessException e)
       {
           throw new AllException("This Author is Not in our BookShop",HttpStatus.NOT_FOUND);
       }
    }

    public List<Author> GetAuthors() {
        List<Author> Authors= new ArrayList<Author>();
        authorJPA.findAll().forEach(Authors::add);
        return Authors;
    }


}
