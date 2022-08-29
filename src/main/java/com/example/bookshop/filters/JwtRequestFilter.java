package com.example.bookshop.filters;

import com.example.bookshop.models.Username;
import com.example.bookshop.services.JwtUtil;
import com.example.bookshop.services.MyUserDetailsService;
import net.bytebuddy.asm.MemberSubstitution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //look into the header examine jwt if its valid then if its valid it took the user details from userDetails service and save it in security context so it needs userDetails service instance and jwt util
    final String authorizationHeader=request.getHeader("Authorization");
    String username=null;
    String jwt=null;
    if(authorizationHeader!=null&&authorizationHeader.startsWith("Bearer ")){
        jwt=authorizationHeader.substring(7);
        username=jwtUtil.extractUsername(jwt);
    }
    if(username!=null&& SecurityContextHolder.getContext().getAuthentication()==null){
        UserDetails userDetails =this.myUserDetailsService.loadUserByUsername(username);
        if(jwtUtil.validateToken(jwt,userDetails)){
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(username,null,userDetails.getAuthorities());
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
    }
        filterChain.doFilter(request,response);
    }
}
