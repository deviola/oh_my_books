package com.app.ohmybooks.entity;

import com.app.ohmybooks.component.entity.BaseEntity;
import com.app.ohmybooks.entity.auth.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User extends BaseEntity {

    @Column(name = "`firstName`")
    @NotNull
    private String firstName;

    @Column(name = "`lastName`")
    @NotNull
    private String lastName;

    @Column
    private Character gender;

    @Column(name="`birthDate`")
    private OffsetDateTime birthDate;

    @Column(name="`isActive`")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "`languageId`")
    private Language language;



    //TODO przenieść do innej tabeli - bez sensu tu siedzi
//    @OneToMany(
//            targetEntity = Rent.class,
//            mappedBy = "user",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY)
//    private List<Rent> rentalsList = new ArrayList<>();


}
