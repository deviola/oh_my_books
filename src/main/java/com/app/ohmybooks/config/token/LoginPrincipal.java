package com.app.ohmybooks.config.token;

import com.app.ohmybooks.entity.auth.Login;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@Slf4j
public class LoginPrincipal implements UserDetails {

    private Login login;
    private Collection<? extends GrantedAuthority> authorities;


    private LoginPrincipal(Login login, Collection<? extends GrantedAuthority> authorities) {
        this.login = login;
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return login.getLogin();
    }

    @Override
    public String getPassword() {
        return login.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginPrincipal that = (LoginPrincipal) o;
        return Objects.equals(login.getId(), that.login.getId());
    }

    @Override
    public String toString() {
        return "LoginPrincipal{" +
                "user=" + login.getLogin() +
                '}';
    }

}
