package com.pu.warehouse.controller;

import com.pu.warehouse.model.dto.UserLoginDTO;
import com.pu.warehouse.model.dto.UserRegisterDTO;
import com.pu.warehouse.service.AuthService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody UserRegisterDTO userRegisterDTO) {

        authService.registerUser(userRegisterDTO);
    }

    @PostMapping("/login")
    public void login(@RequestBody UserLoginDTO userLoginDTO){

        authService.login();

    }


}
