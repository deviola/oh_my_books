package com.app.ohmybooks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    @NotNull
    private Long id;

    @Column(name = "FIRST_NAME")
    @NotNull
    private String firstName;

    @Column(name = "LAST_NAME")
    @NotNull
    private String lastName;

    @Column(name = "CREATION_DATE")
    private LocalDate created;

    @OneToMany(
            targetEntity = Rent.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Rent> rentalsList = new ArrayList<>();

    public User(@NotNull String firstName, @NotNull String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = LocalDate.now();
    }

    public User(@NotNull String firstName, @NotNull String lastName, @NotNull LocalDate created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = created;
    }
}
