package com.hack.springboottutorial.controller;

import com.hack.springboottutorial.domain.dto.LoginDto;
import com.hack.springboottutorial.domain.dto.SignupDto;
import com.hack.springboottutorial.domain.entity.User;
import com.hack.springboottutorial.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginDto loginDto){
        return loginService.login(loginDto.toEntity());
    }
    @PostMapping("/signup")
    public User signup(@RequestBody SignupDto signupDto){
        return loginService.signup(signupDto.toEntity());
    }
}
