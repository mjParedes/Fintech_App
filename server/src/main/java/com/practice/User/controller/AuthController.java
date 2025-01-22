package com.practice.User.controller;

import com.practice.User.dtoRequest.AuthCreateUserRequestDto;
import com.practice.User.dtoRequest.AuthLoginRequestDto;
import com.practice.User.dtoResponse.AuthResponseDto;
import com.practice.User.dtoResponse.AuthResponseRegisterDto;
import com.practice.User.service.CloudinaryService;
import com.practice.User.service.impl.UserDetailsServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
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
public class AuthController {

    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final CloudinaryService cloudinaryService;

    @Operation(summary = "Iniciar sesión", description = "Inicia sesión y obtiene un token de autenticación.")
    @ApiResponse(responseCode = "200", description = "Autenticación exitosa")
    @ApiResponse(responseCode = "401", description = "Credenciales incorrectas")
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody @Valid AuthLoginRequestDto authDto) {
        AuthResponseDto response = this.userDetailsServiceImpl.loginUser(authDto);

        // Incluir el token en el encabezado "Authorization"
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + response.token())
                .body(response);
    }



    @Operation(summary = "Subir foto de usuario", description = "Sube una foto de perfil para el usuario autenticado, " +
            "la foto debe ser una imagen (jpg, png, gif, bmp, webp).")
    @ApiResponse(responseCode = "200", description = "Url de la foto subida exitosamente")
    @ApiResponse(responseCode = "500", description = "Error al subir la foto")
    @PostMapping(value = "/upload-photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadPhoto(@RequestParam("photo") MultipartFile photo) {
        try {
            String photoUrl = cloudinaryService.uploadImage(photo);
            return ResponseEntity.ok(photoUrl);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
        }
    }


    @Operation(summary = "Registrar nuevo usuario", description = """
            Registra un nuevo usuario y obtiene un token de autenticación.\s
            Los roles del usuario deben ser 'USER' o 'ADMIN'. No se puede registrar otro tipo de rol.\s
            Todos los campos son obligatorios excepto la foto.
            El email debe ser único.
            """)
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthResponseRegisterDto> register(@RequestBody @Valid AuthCreateUserRequestDto authCreateUserDto) {
        AuthResponseRegisterDto response = userDetailsServiceImpl.createUser(authCreateUserDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
