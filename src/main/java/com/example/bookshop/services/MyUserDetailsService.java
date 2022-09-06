//package com.example.bookshop.services;
//import com.example.bookshop.models.LibraryUser;
//import com.example.bookshop.repositories.UserRepository;
//import com.example.bookshop.security.MyUserDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//    @Autowired
//    UserRepository UserRep;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        LibraryUser user=UserRep.findByUserName(username);
//        System.out.println(user);
//        return new MyUserDetails(user);
//    }
//}
