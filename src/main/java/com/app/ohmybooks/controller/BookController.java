package com.app.ohmybooks.controller;

import com.app.ohmybooks.domain.dto.BookDto;
import com.app.ohmybooks.domain.dto.CreateBookReqDto;
import com.app.ohmybooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable("bookId") Long bookId) {
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBook(@RequestBody CreateBookReqDto createBookReqDto) {
        bookService.createBook(createBookReqDto);
        return ResponseEntity.ok().build();
    }

    //@
//    public ResponseEntity<?> updateBook() {
//
//    }
//
//    public ResponseEntity<?> deleteBook() {
//
//    }
}
