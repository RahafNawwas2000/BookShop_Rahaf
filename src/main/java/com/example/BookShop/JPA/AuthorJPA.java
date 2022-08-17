package com.example.BookShop.JPA;
import com.example.BookShop.model.Author;
import com.example.BookShop.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorJPA extends CrudRepository<Author, Integer> {

}
