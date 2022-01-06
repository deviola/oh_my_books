package com.app.ohmybooks.entity.auth;

import com.app.ohmybooks.component.entity.BaseEntity;
import com.app.ohmybooks.entity.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "public", name = "`LOGINS`")
public class Login extends BaseEntity {

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String email;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "`userId`")
    private User user;

    @Column(name = "`canLogin`")
    private Boolean canLogin;

    @Column(name="`isAdmin`")
    private @Builder.Default Boolean isAdmin = Boolean.FALSE;

}
