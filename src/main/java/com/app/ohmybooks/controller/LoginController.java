package com.app.ohmybooks.controller;

import com.app.ohmybooks.domain.dto.auth.AuthShortResDTO;
import com.app.ohmybooks.domain.dto.auth.LoginResDTO;
import com.app.ohmybooks.domain.dto.auth.UpdateLoginReqDTO;
import com.app.ohmybooks.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/logins/user")
    public ResponseEntity<AuthShortResDTO> getCurrentUser(){
        return ResponseEntity.ok(loginService.getCurrentUser());
    }

    @PutMapping("/logins/update")
    public ResponseEntity<LoginResDTO> updateLogin(@RequestBody UpdateLoginReqDTO updateLoginReqDTO){
        return ResponseEntity.ok(loginService.updateLogin(updateLoginReqDTO));
    }

}
