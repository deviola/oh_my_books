package com.app.ohmybooks.entity;

import com.app.ohmybooks.component.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "public", name = "`AUTHORS_2_BOOK`")
public class Author2Book extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "bookId", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "authorId", nullable = false)
    private Author author;

}
