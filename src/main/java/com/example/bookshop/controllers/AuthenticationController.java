package com.example.bookshop.controllers;

import com.example.bookshop.models.AuthenticationRequest;
import com.example.bookshop.models.AuthenticationResponse;
import com.example.bookshop.services.JwtUtil;
import com.example.bookshop.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @RequestMapping(method = RequestMethod.POST,value = "/authenticate")
    public ResponseEntity<AuthenticationResponse> Authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        UserDetails userDetails = null;
        try {
            System.out.println(authenticationRequest.getUsername()+" "+authenticationRequest.getPassword());
            //authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
            System.out.println("from controller2");
            userDetails=myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        }
        catch (BadCredentialsException e)
        {

        }
        final String jwt= jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
