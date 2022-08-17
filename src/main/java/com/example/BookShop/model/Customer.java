package com.example.BookShop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    String name;
    @ManyToMany
    @JoinTable(
            name = "Books_Customer",
            joinColumns = { @JoinColumn(name = "CustomerId")},
            inverseJoinColumns = { @JoinColumn(name = "BookId") }
    )
    List<Book> books=new ArrayList<>();

    public Customer() {
        super();
    }

    public Customer(int id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }

    public void addBookToList(Book book)
    {
        books.add(book);
    }
}
