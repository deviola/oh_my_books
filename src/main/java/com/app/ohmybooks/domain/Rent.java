package com.app.ohmybooks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RENTALS")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @NotNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    @NotNull
    private Book book;

    @Column(name = "RENTED_FROM")
    @NotNull
    private LocalDate rentedFrom;

    @Column(name = "RENTED_TO")
    @NotNull
    private LocalDate rentedTo;

    public Rent(User user, Book book, LocalDate rentedFrom, LocalDate rentedTo) {
        this.user = user;
        this.book = book;
        this.rentedFrom = rentedFrom;
        this.rentedTo = rentedTo;
    }
}
