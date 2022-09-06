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
        book.setAuthor(new Author(authorID,"",""));
        bookComp.CreateBook(book);
    }
    //http://localhost:8080/books/all
    @RequestMapping(value = "/all")
    public List<Book> getBooks()
    {
        return bookComp.GetAllBooks();
    }
    //http://localhost:8080/books/getBooksByAuthor?authorId=1
    @RequestMapping(value = "/getBooksByAuthor")
    public List<Book> getBooksByAuthorId(@RequestParam("authorId") Integer authorId)
    {
        return bookComp.GetBookByAuthorId(authorId);
    }
    //http://localhost:8080/books/getBookID/1
    @RequestMapping(value = "getBookID/{BookID}")
    public Book getBookByID(@PathVariable Integer BookID)
    {
        return bookComp.GetBook(BookID);
    }
    //http://localhost:8080/books/deleteBook/1
    @RequestMapping(value = "/deleteBook/{BookId}",method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable Integer BookId) {
        bookComp.DeleteBook(BookId);
    }
    @RequestMapping(value ="deleteAuthorBooks/{AuthorID}",method = RequestMethod.DELETE)
    public void deleteAuthorBooks(@PathVariable Integer AuthorID)
    {
       bookComp.DeleteAuthorBooks(AuthorID);
    }

    @RequestMapping(value = "/getBookByName/{bookName}")
    public Book getBookByName(@PathVariable String bookName)
    {
        return bookComp.getBookByName(bookName);
    }
    @RequestMapping(value = "/getBookByISBN/{bookISBN}")
    public Book getBookByISBN(@PathVariable String bookISBN)
    {
        return bookComp.getBookByISBN(bookISBN);
    }
    @RequestMapping(value = "/getBookStock/{bookId}")
    public int getBookStock(@PathVariable int bookId)
    {
        return bookComp.getBookStock(bookId);
    }
    @RequestMapping(value = "/increaseStock",method = RequestMethod.PUT)
    public void increaseStock(@RequestParam("BookId")int BookId){
             bookComp.increaseStock(BookId);
    }
    @RequestMapping(value = "/decreaseStock",method = RequestMethod.PUT)
    public void decreaseStock(@RequestParam("BookId")int BookId){
        bookComp.decreaseStock(BookId);
    }




}
