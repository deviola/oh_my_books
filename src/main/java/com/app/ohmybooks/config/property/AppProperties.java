package com.app.ohmybooks.config.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.List;

@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
@PropertySources({
        @PropertySource(value = "classpath:git.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "classpath:META-INF/build-info.properties", ignoreResourceNotFound = true)
})
@Getter
@Setter
public class AppProperties {

    private String timeZone;

    private boolean migration;

    private boolean reinstall;

    private boolean repair;

    private final Security security = new Security();

    private final BaseUrl baseUrl = new BaseUrl();


    @Setter
    @Getter
    public static class Security {
        private final Authentication authentication = new Authentication();

        @Getter
        @Setter
        public static class Authentication{
            private final AccessToken accessToken = new AccessToken();

            @Getter
            @Setter
            public static class AccessToken{
                private String secret;
                private long tokenValidity;
                private long tokenValiditySocial;
                private long tokenValidityForRememberMe;
                private long tokenValidityForContext;
                private long tokenValidityAnonymous;
            }
        }
    }

    @Getter
    @Setter
    public static class BaseUrl {
        private String main;
        private String confirmAccount;
        private String confirmInvitation;
        private String downloadFile;
        private String resetPassword;
        private String subscription;
    }

}