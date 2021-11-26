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
public class LoginShortResDTO {

    private Long loginId;

    private String login;

    private String email;

    private Long userId;

    private String firstName;

    private String lastName;

    public LoginShortResDTO(Login login) {
        this.loginId = login.getId();
        this.login = login.getLogin();
        this.email = login.getEmail();
        this.userId = login.getUser() != null ? login.getUser().getId() : null;
        this.firstName = login.getUser() != null ? login.getUser().getFirstName() : null;
        this.lastName = login.getUser() != null ? login.getUser().getLastName() : null;
    }

}
