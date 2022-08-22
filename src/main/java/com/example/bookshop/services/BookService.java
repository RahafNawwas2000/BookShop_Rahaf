package com.example.bookshop.services;

import com.example.bookshop.repositories.AuthorRepository;
import com.example.bookshop.repositories.BookRepository;
import com.example.bookshop.exceptions.AllException;
import com.example.bookshop.models.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class BookService {
    @Autowired
    BookRepository BOOK_JPA;
    @Autowired
    AuthorRepository authorRepository;
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
