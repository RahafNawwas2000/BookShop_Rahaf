package com.example.bookshop.repositories;


import com.example.bookshop.models.Username;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Username,Integer> {
    Username findByUserName(String Username);
}
