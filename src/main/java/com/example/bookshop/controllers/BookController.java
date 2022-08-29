package com.example.bookshop.controllers;

import com.example.bookshop.services.BookService;
import com.example.bookshop.models.Book;
import com.example.bookshop.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    BookService bookComp;


    //http://localhost:8080/books/createBook/?authorId=1
    @RequestMapping(method = RequestMethod.POST,value ="/createBook" )
    public void CreateBook(@RequestParam("authorId") Integer authorID, @RequestBody Book book) {
        System.out.println("Id"+authorID);
        book.setAuthor(new Author(authorID,""));
        bookComp.CreateBook(book);
    }
    //http://localhost:8080/books/all
    @RequestMapping(value = "/all")
    public List<Book> GetBooks()
    {
        return bookComp.GetAllBooks();
    }
    //http://localhost:8080/books/getBooksByAuthor?authorId=1
    @RequestMapping(value = "/getBooksByAuthor")
    public List<Book> GetBooksByAuthorId(@RequestParam("authorId") Integer authorId)
    {
        return bookComp.GetBookByAuthorId(authorId);
    }
    //http://localhost:8080/books/getBookID/1
    @RequestMapping(value = "getBookID/{BookID}")
    public Book GetBookByID(@PathVariable Integer BookID)
    {
        return bookComp.GetBook(BookID);
    }
    //http://localhost:8080/books/deleteBook/1
    @RequestMapping(value = "/deleteBook/{BookId}",method = RequestMethod.DELETE)
    public void DeleteBook(@PathVariable Integer BookId) {
        bookComp.DeleteBook(BookId);
    }
    @RequestMapping(value ="deleteAuthorBooks/{AuthorID}",method = RequestMethod.DELETE)
    public void DeleteAuthorBooks(@PathVariable Integer AuthorID){
       bookComp.DeleteAuthorBooks(AuthorID);
    }

}
