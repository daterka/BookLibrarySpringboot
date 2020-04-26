package com.booklibrary.springboot.controller;

import com.booklibrary.springboot.model.BookDetailsRequestModel;
import com.booklibrary.springboot.model.BookModel;
import com.booklibrary.springboot.model.UserModel;
import com.booklibrary.springboot.service.DashboardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = "/dashboard")
public class DashboardController {

//    @Configuration
//    @EnableGlobalMethodSecurity(
//            prePostEnabled = true,
//            securedEnabled = true,
//            jsr250Enabled = true)
//    public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration { }

    @Autowired
    private DashboardService dashboardService;

//    @Autowired
//    public DashboardController(DashboardService dashboardService) {
//        this.dashboardService = dashboardService;
//    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookModel>> getAll(){
        LinkedList<BookModel> result = dashboardService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookModel> getBookById(@PathVariable int id){
        BookModel result = dashboardService.getBookById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookModel>> saveBook(
            @RequestBody BookDetailsRequestModel bookDetails){
        System.out.println("log : DashBoardController : PostMapping \"/\"");
        System.out.println(bookDetails.getTitle());
        System.out.println(bookDetails.getAuthor());
        System.out.println(bookDetails.getReleasedDate());
        System.out.println(bookDetails.getGenre());
        LinkedList<BookModel> result = dashboardService.saveBook(
                bookDetails.getTitle(), bookDetails.getAuthor(), bookDetails.getReleasedDate(), bookDetails.getGenre());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookModel> deleteBookWithId(@PathVariable int id){
        BookModel result = dashboardService.deleteBookWithId(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
