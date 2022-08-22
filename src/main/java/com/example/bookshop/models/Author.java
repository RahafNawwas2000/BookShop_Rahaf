package com.example.bookshop.models;

import javax.persistence.*;


@Entity
@Table(name="Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;
    @Column(name ="name")
    String name;


//    @OneToMany(mappedBy = "author")
//    List<Book> books;


    public Author() {
    	super();
    }

    public Author(Integer id, String name) {
        this.id = id;
        this.name = name;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "author{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
