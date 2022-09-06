package com.example.bookshop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
//@Table(name = "Customer")
public class Customer extends LibraryUser{
//   @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//   int id;
   String name;
//    @Column(unique = true)
//    String username;
//    String password;
//    String role;

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

    public Customer(int id,String userName,String name,String password,String role, List<Book> books) {
//        this.id = id;
//        this.name = name;
        super(id,userName,password,true,"ROLE_CUSTOMER");
        this.books = books;
        this.name=name;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + getId() +
                ", name='" + getUserName() + '\'' +
                ", books=" + books +
                '}';
    }

    public void addBookToList(Book book)
    {
        books.add(book);
    }


}
