package com.app.ohmybooks.service;

import com.app.ohmybooks.constant.MessageConstant;
import com.app.ohmybooks.repository.UserRepository;
import com.google.common.base.Preconditions;
import com.app.ohmybooks.config.util.SecurityUtils;
import com.app.ohmybooks.domain.dto.auth.AuthShortResDTO;
import com.app.ohmybooks.domain.dto.auth.LoginResDTO;
import com.app.ohmybooks.domain.dto.auth.UpdateLoginReqDTO;
import com.app.ohmybooks.entity.User;
import com.app.ohmybooks.entity.auth.Login;
import com.app.ohmybooks.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginRepository loginRepository;
    private final UserRepository userRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository, UserRepository userRepository) {
        this.loginRepository = loginRepository;
        this.userRepository = userRepository;
    }

    public AuthShortResDTO getCurrentUser() {
        return new AuthShortResDTO((loginRepository.getOne(SecurityUtils.getCurrentLoggedUserID())));
    }

    public LoginResDTO updateLogin(UpdateLoginReqDTO updateLoginReqDTO) {
        Login login = loginRepository.getOne(SecurityUtils.getCurrentLoggedUserID());

        User user = login.getUser();

        Preconditions.checkArgument(user != null, MessageConstant.USER_NOT_FOUND);

        user.setFirstName(updateLoginReqDTO.getFirstName());
        user.setLastName(updateLoginReqDTO.getLastName());

        userRepository.save(user);

        return new LoginResDTO(login);
    }

}
