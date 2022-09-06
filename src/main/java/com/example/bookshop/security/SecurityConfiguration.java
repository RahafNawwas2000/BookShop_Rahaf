//package com.example.bookshop.security;
//import com.example.bookshop.filters.JwtRequestFilter;
//import com.example.bookshop.services.MyUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.Filter;
//
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private MyUserDetailsService myUserDetailsService;
//    @Autowired
//    private JwtRequestFilter jwtRequestFilter;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        System.out.println("config");
//        auth.userDetailsService(myUserDetailsService);
//    }
//
//    @Bean
//    public PasswordEncoder getPasswordEncoder()
//    {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//                //.authorizeRequests().antMatchers("authors/all").hasRole("ADMIN")
//                //.authorizeRequests().antMatchers("/authenticate").permitAll().and().an.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http
//                .httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/authenticate").permitAll()
//                .and()
//                .authorizeRequests()
//                //.anyRequest().authenticated()
//                .antMatchers(HttpMethod.POST,"/authors/addAuthor/").hasAnyRole("ADMIN")
//                .and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.DELETE,"/authors/deleteAuthor/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//
//
//    }
//}
