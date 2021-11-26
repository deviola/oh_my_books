package com.app.ohmybooks.controller;

import com.app.ohmybooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    public final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

//    public ResponseEntity<Void> getAllBooks() {
//
//    }
//
//    public ResponseEntity<?> getBookById() {
//
//    }
//
//    public ResponseEntity<?> createBook() {
//
//    }
//
//    public ResponseEntity<?> updateBook() {
//
//    }
//
//    public ResponseEntity<?> deleteBook() {
//
//    }
}
