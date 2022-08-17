package com.example.BookShop.JPA;

import com.example.BookShop.model.Author;
import com.example.BookShop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface BookJPA extends JpaRepository<Book, Integer> {
   public List<Book> findAllByAuthorId(Integer AuthorId);
   @Transactional
   void deleteAllByAuthorId(Integer authorID);
}
