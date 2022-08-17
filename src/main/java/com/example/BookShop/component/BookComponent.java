package com.example.BookShop.component;

import com.example.BookShop.JPA.AuthorJPA;
import com.example.BookShop.JPA.BookJPA;
import com.example.BookShop.exception.AllException;
import com.example.BookShop.model.Author;
import com.example.BookShop.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class BookComponent {
    @Autowired
    BookJPA BOOK_JPA;
    @Autowired
    AuthorJPA authorJPA;
    public void CreateBook(Book book) {
        if(book.getName()==null||book.getIsbn()==null)
        {
            throw new AllException("name or isbn is empty", HttpStatus.BAD_REQUEST,book);
        }
    BOOK_JPA.save(book);
    }

    public Book GetBook(Integer id) {
        try {
        return BOOK_JPA.findById(id).get();
        }catch (EmptyResultDataAccessException e)
        {
            throw new AllException("This Book is Not in our BookShop",HttpStatus.NOT_FOUND);
        }
    }

    public List<Book> GetAllBooks() {
        return (List<Book>) BOOK_JPA.findAll();
    }

    public List<Book> GetBookByAuthorId(Integer id) {
        return   BOOK_JPA.findAllByAuthorId(id);
    }

    public void DeleteBook(Integer BookId){
        BOOK_JPA.deleteById(BookId);
    }

    public void DeleteAuthorBooks(Integer authorID) {
        BOOK_JPA.deleteAllByAuthorId(authorID);
    }
}
