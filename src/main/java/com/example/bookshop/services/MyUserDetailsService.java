package com.example.bookshop.services;
import com.example.bookshop.models.Username;
import com.example.bookshop.repositories.UserRepository;
import com.example.bookshop.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository UserRep;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Username user=UserRep.findByUserName(username);
        System.out.println(user);
        return new MyUserDetails(user);
    }
}
