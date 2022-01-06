package com.app.ohmybooks.domain.dto;

import com.app.ohmybooks.entity.Author;
import com.app.ohmybooks.entity.Author2Book;
import com.app.ohmybooks.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String title;
    private Author authors;
    private String isbnNum;
    private Long publicationYear;
    private Book.BookStatus status;

    public BookDto(Book book) {
        this.title = book.getTitle();
        this.authors = book.getAuthor();
        this.isbnNum = book.getIsbn();
        this.publicationYear = book.getPublicationYear();
        this.status = book.getStatus();
    }

}
