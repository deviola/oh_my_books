package com.app.ohmybooks.domain.dto;

import com.app.ohmybooks.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {

    private String title;
    private String authorName;
    private String authorLastName;
    private String isbn;
    private Long year;

    public BookResponseDTO(Book book) {
        this.title = book.getTitle();
        this.authorName = book.getAuthor().getFirstName();
        this.authorLastName = book.getAuthor().getLastName();
        this.isbn = book.getIsbn();
        this.year = book.getPublicationYear();
    }
}
