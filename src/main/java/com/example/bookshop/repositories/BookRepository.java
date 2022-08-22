package com.example.bookshop.repositories;

import com.example.bookshop.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
   public List<Book> findAllByAuthorId(Integer AuthorId);
   @Transactional
   void deleteAllByAuthorId(Integer authorID);
}
