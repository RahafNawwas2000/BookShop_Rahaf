package com.example.BookShop.Controller;

import com.example.BookShop.component.BookComponent;
import com.example.BookShop.model.Book;
import com.example.BookShop.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookComponent bookComp;

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
