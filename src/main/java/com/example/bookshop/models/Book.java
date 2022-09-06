package com.example.bookshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
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
    int Stock;

    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    private List<Customer> Customers;

    public Book() {
    	super();
    }
    public Book(int id, String isbn, String name,Integer AuthorId) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.author=new Author(AuthorId,"","");

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
