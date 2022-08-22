package com.example.bookshop.controllers;

import com.example.bookshop.services.BookService;
import com.example.bookshop.models.Book;
import com.example.bookshop.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookComp;

    @RequestMapping(method = RequestMethod.POST,value ="Author/{AuthorID}/CreateBook" )
    public void CreateBook(@PathVariable Integer AuthorID, @RequestBody Book book) {
        book.setAuthor(new Author(AuthorID,""));
        bookComp.CreateBook(book);
    }
    @RequestMapping(value = "/Books")
    public List<Book> GetBooks()
    {
        return bookComp.GetAllBooks();
    }
    @RequestMapping(value = "/Authors/{id}/Books")
    public List<Book> GetBooksByAuthorId(@PathVariable Integer id)
    {
        System.out.println("from Controller"+id);
        return bookComp.GetBookByAuthorId(id);
    }
    @RequestMapping(value = "/Authors/{id}/Books/{BookID}")
    public Book GetBookByID(@PathVariable Integer BookID)
    {
        return bookComp.GetBook(BookID);
    }

    @RequestMapping(value = "/DeleteBook/{BookId}",method = RequestMethod.DELETE)
    public void DeleteBook(@PathVariable Integer BookId) {
        bookComp.DeleteBook(BookId);
    }
    @RequestMapping(value ="DeleteAuthorBooks/{AuthorID}",method = RequestMethod.DELETE)
    public void DeleteAuthorBooks(@PathVariable Integer AuthorID){
       bookComp.DeleteAuthorBooks(AuthorID);
    }

}
