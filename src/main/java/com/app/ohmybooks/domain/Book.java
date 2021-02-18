package com.app.ohmybooks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    @NotNull
    private BookTitle bookTitle;

    @Column(name = "STATUS")
    @NotNull
    private String status;

    @OneToMany(
            targetEntity = Rent.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Rent> rent = new ArrayList<>();

    public Book(@NotNull BookTitle bookTitle, @NotNull String status) {
        this.bookTitle = bookTitle;
        this.status = status;
    }
}
