package com.app.ohmybooks.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookReqDto {

    private String title;
    private String authorName;
    private String authorLastName;
    private String isbn;
    private Long year;

}
