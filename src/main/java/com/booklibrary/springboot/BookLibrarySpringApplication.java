package com.booklibrary.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookLibrarySpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookLibrarySpringApplication.class, args);
        System.out.println("Application has started");
    }

}

