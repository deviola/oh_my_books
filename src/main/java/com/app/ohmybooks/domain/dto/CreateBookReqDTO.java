package com.app.ohmybooks.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookReqDTO {

    private String title;
    private String authorFirstName;
    private String authorLastName;
    private String isbn;
    private Long year;

}
