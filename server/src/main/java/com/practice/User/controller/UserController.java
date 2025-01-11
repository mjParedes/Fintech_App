package com.practice.User.controller;

import com.practice.User.dtoRequest.AuthCreateUserRequestDto;
import com.practice.User.dtoRequest.AuthLoginRequestDto;
import com.practice.User.dtoResponse.AuthResponseDto;
import com.practice.User.dtoResponse.AuthResponseRegisterDto;
import com.practice.User.service.CloudinaryService;
import com.practice.User.service.impl.UserDetailsServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Authentication API")
@Validated
@RequiredArgsConstructor
public class UserController {

    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final CloudinaryService cloudinaryService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthLoginRequestDto authDto) {
        AuthResponseDto response = this.userDetailsServiceImpl.loginUser(authDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @Operation(summary = "Subir foto de usuario")
    @PostMapping(value = "/upload-photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadPhoto(@RequestParam("photo") MultipartFile photo) {
        try {
            String photoUrl = cloudinaryService.uploadImage(photo);
            return ResponseEntity.ok(photoUrl);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
        }
    }


    @Operation(summary = "Registrar nuevo usuario")
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthResponseRegisterDto> register(@RequestBody @Valid AuthCreateUserRequestDto authCreateUserDto) {
        AuthResponseRegisterDto response = userDetailsServiceImpl.createUser(authCreateUserDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
