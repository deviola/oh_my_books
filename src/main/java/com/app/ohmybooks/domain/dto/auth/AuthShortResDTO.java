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
public class AuthShortResDTO {

    private Long id;

    private String login;

    private String email;

    private Boolean canLogin;

    private Boolean isAdmin;

    private String languageCode;

    public AuthShortResDTO(Login login) {
        this.id = login.getId();
        this.login = login.getLogin();
        this.email = login.getEmail();
        this.canLogin = login.getCanLogin();
        this.isAdmin = login.getIsAdmin();
        this.languageCode = login.getUser() != null && login.getUser().getLanguage() != null ?
                            login.getUser().getLanguage().getCode() : null;
    }

}
