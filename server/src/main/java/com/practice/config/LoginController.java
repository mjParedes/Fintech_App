package com.practice.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class LoginController {

    @GetMapping
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("Login successful");
    }
}
