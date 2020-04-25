package com.booklibrary.springboot.service;

import com.booklibrary.springboot.exception.NotFoundException;
import com.booklibrary.springboot.exception.ServiceErrorCode;
import com.booklibrary.springboot.model.BookModel;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Optional;

@Service
public class DashboardService {
    LinkedList<BookModel> books;

    public DashboardService() {
        this.books = new LinkedList<>();
        for(int i = 0; i < 10; i++){
            this.books.add(new BookModel(i, "title_field", "author_field", "released_date_field", "genre_field"));
        }
    }

    public LinkedList<BookModel> getAll(){
        return this.books;
    }

    public BookModel getBookByTitle(String title){
        return this.books.stream()
                .filter(book -> title.equals(book.getTitle()))
                .findAny()
                .orElseThrow(
                        () ->new NotFoundException(String.format("Book with title=%s not found", title),
                        ServiceErrorCode.BOOK_NOT_FOUND));
    }

    public BookModel getBookById(int id){
        return this.books.stream()
                .filter(book -> id==book.getId())
                .findAny()
                .orElseThrow(
                        () ->new NotFoundException(String.format("Book with id=%d not found", id),
                                ServiceErrorCode.BOOK_NOT_FOUND));
    }



    public LinkedList<BookModel> saveBook(String title, String author, String releasedDate, String genre){
        int new_book_id = this.books.indexOf(this.books.get(this.books.size()));
        this.books.add(new BookModel(new_book_id, title, author, releasedDate, genre));
        return this.books;
    }

    public void deleteBookWithTitle(String title){
        Optional<BookModel> bookItem = Optional.ofNullable(this.books.stream()
                .filter(book -> title.equals(book.getTitle()))
                .findAny()
                .orElseThrow(
                        () -> new NotFoundException(
                                String.format("Book with title=%s not found", title),
                                ServiceErrorCode.BOOK_NOT_FOUND)));

        if(bookItem.isPresent()) {
            this.books.remove(bookItem);
        }
    }

    public BookModel deleteBookWithId(int id){
        Optional<BookModel> bookItem = Optional.ofNullable(this.books.stream()
                .filter(book -> id == book.getId())
                .findAny()
                .orElseThrow(
                        () -> new NotFoundException(
                                String.format("Book with id=%s not found", id),
                                ServiceErrorCode.BOOK_NOT_FOUND)));

        if(bookItem != null) {
            this.books.remove(bookItem);
        }

        return bookItem.orElse(null);
    }
}
