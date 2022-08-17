package com.example.BookShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    String isbn;
    String name;
    @ManyToOne
    private Author author;
    @JsonIgnore
//    @ManyToMany(mappedBy = "books")
//    private List<Customer> Customers;
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author authors) {
        author = authors;
    }
    public Book() {
    	super();
    }
    public Book(int id, String isbn, String name,Integer AuthorId) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.author=new Author(AuthorId,"");

    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +

                '}';
    }
}
