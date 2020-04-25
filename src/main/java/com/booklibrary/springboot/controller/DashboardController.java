package com.booklibrary.springboot.controller;

import com.booklibrary.springboot.model.BookDetailsRequestModel;
import com.booklibrary.springboot.model.BookModel;
import com.booklibrary.springboot.model.UserModel;
import com.booklibrary.springboot.service.DashboardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = "/dashboard")
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

//    @Autowired
//    public DashboardController(DashboardService dashboardService) {
//        this.dashboardService = dashboardService;
//    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookModel>> getAll(){
        LinkedList<BookModel> result = dashboardService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookModel> getBookById(@PathVariable int id){
        BookModel result = dashboardService.getBookById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookModel>> saveBook(
            @RequestBody BookDetailsRequestModel bookDetails){
        LinkedList<BookModel> result = dashboardService.saveBook(
                bookDetails.getTitle(), bookDetails.getAuthor(), bookDetails.getReleasedDate(), bookDetails.getGenre());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookModel> deleteBookWithId(@PathVariable int id){
        BookModel result = dashboardService.deleteBookWithId(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
