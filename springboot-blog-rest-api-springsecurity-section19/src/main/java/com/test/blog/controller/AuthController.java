package com.test.blog.controller;

import com.test.blog.dtos.LoginDTO;
import com.test.blog.dtos.RegisterDTO;
import com.test.blog.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //Build Login/Sign in REST API
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        String response = authService.login(loginDTO);
        return ResponseEntity.ok(response);
    }

    //Build Register REST API
    @PostMapping(value={"/register","/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {
        String response = authService.register(registerDTO);
        //return ResponseEntity.ok(response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
