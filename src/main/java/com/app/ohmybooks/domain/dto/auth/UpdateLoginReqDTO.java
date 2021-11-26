package com.app.ohmybooks.domain.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLoginReqDTO {

    private String firstName;

    private String lastName;

}
