package com.example.bookshop.repositories;

import com.example.bookshop.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByBooksId(Integer bookId);

    @Modifying
    @Query(value = "INSERT INTO Username (Id,user_name,pass,active,roles) VALUES (:id,:user_name,:pass,:active,:roles)", nativeQuery = true)
    @Transactional
    void saveToUserTable(@Param("id")int id,@Param("user_name") String user_name,@Param("pass") String pass,@Param("active")boolean active,@Param("roles")String roles);
}
