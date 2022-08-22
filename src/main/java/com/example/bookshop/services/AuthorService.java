package com.example.bookshop.services;

import com.example.bookshop.repositories.AuthorRepository;
import com.example.bookshop.exceptions.AllException;
import com.example.bookshop.models.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    public void addAuthor(Author Author)
    {
        if(Author.getName()==null)
        {
            throw new AllException("The name is empty",HttpStatus.BAD_REQUEST,Author);
        }
        authorRepository.save(Author);
    }
    public void DeleteAuthor(Integer id) {
       try {
           restTemplate.delete("http://localhost:8080/DeleteAuthorBooks/" + id);
           authorRepository.deleteById(id);
       }catch (EmptyResultDataAccessException e)
       {
           throw new AllException("This Author is Not in our BookShop",HttpStatus.NOT_FOUND);
       }
    }

    public List<Author> GetAuthors() {
        List<Author> Authors= new ArrayList<Author>();
        authorRepository.findAll().forEach(Authors::add);
        return Authors;
    }


}
