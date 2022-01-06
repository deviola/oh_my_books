package com.app.ohmybooks.entity;

import com.app.ohmybooks.component.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "public", name = "`BOOKS`")
public class Book extends BaseEntity {

    @JoinColumn(name = "title", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "`authorId`", nullable = false)
    private Author author;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "`publicationYear`", nullable = false)
    private Long publicationYear;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    public enum BookStatus {
        AVAILABLE, BOOKED, RENTED
    }

}
