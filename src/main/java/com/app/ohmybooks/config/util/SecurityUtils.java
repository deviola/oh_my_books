package com.app.ohmybooks.config.util;

import com.app.ohmybooks.component.entity.BaseEntity;
import com.app.ohmybooks.config.token.LoginPrincipal;
import com.app.ohmybooks.entity.auth.Login;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public final class SecurityUtils {

    public static Long getCurrentLoggedUserID() {
        return getCurrentLoggedUser()
                .map(LoginPrincipal::getLogin)
                .map(BaseEntity::getId)
                .orElse(null);
    }

    public static Optional<LoginPrincipal> getCurrentLoggedUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();

        return Optional.ofNullable(securityContext.getAuthentication())
                .map(authentication -> {
                    if(authentication.getPrincipal() instanceof LoginPrincipal) {
                        return (LoginPrincipal) authentication.getPrincipal();
                    }
                    return null;
                });
    }

    public static String getLanguage() {
        Login login = getCurrentLoggedLogin();

        return login.getUser() != null && login.getUser().getLanguage() != null ?
                login.getUser().getLanguage().getCode() : "pl";
    }

    public static Login getCurrentLoggedLogin() {
        return getCurrentLoggedUser().get().getLogin();
    }

}
