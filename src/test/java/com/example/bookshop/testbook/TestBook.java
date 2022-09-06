//package com.example.bookshop.testbook;
//import com.example.bookshop.models.Author;
//import com.example.bookshop.services.BookService;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.net.URI;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//public class TestBook {
//    //@InjectMocks
//    @Autowired
//    private BookService bookService;
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//    private MockMvc mockMvc;
//
////    @Mock
////    private BookRepository bookRepository;
//
//    @BeforeEach
//    void setUp() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//
//    }
//
//    @Test
//    final void testGetBookByID() throws Exception {
////        mockMvc.perform(get("/books/all")).andExpect(status().isOk())
////                .andExpect(jsonPath("$.isbn").value("emp1")).andExpect(jsonPath("$.name").value("manager"))
////                .andExpect(jsonPath("$.empId").value("1"));
//
//        RestTemplate restTemplate=new RestTemplate();
//        String url= "http://localhost:8081/authors/addAuthor/";
//        URI uri=new URI(url);
//        Author author=new Author(77,"ahmad44");
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization","eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYWhhZiIsImV4cCI6MTY2MTk3NTY2MCwiaWF0IjoxNjYxOTM5NjYwfQ.hupe8RKIb5UA-qEHfdB6HEsFt9owlxTOhfGXr4kVi5Q");
//        HttpEntity<Author> request = new HttpEntity<>(author, headers);
//        ResponseEntity<String> result;
//        //= restTemplate.postForEntity(uri, request, String.class);
//        result=restTemplate.exchange(uri, HttpMethod.POST,request,String.class);
//        Assertions.assertEquals(200, result.getStatusCodeValue());
//    }
//
//}
