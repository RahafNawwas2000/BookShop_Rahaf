package com.example.bookshop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="Author")
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;
    @Column(name ="name")
    String name;
    @Column(name = "username")
    String username;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonBackReference
    List<Book> books;


    public Author() {
    	super();
    }

    public Author(Integer id, String name,String username) {
        this.id = id;
        this.name = name;
        this.username=username;

    }
    @Override
    public String toString() {
        return "author{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
