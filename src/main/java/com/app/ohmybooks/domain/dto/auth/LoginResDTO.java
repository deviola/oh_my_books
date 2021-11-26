package com.app.ohmybooks.domain.dto.auth;

import com.app.ohmybooks.entity.auth.Login;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResDTO extends LoginShortResDTO {

    private Long languageId;

    private String languageCode;

    public LoginResDTO(Login login) {
        super(login);
        this.languageId = login.getUser() != null ? login.getUser().getLanguage().getId() : null;
        this.languageCode = login.getUser() != null ? login.getUser().getLanguage().getCode() : null;
    }

}