package com.practice.User.dtoRequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Validated
public record AuthCreateUserRequestDto(String photoUrl,
                                       @NotBlank(message = "El nombre es obligatorio") String name,
                                       @NotBlank(message = "El apellido es obligatorio") String lastName,
                                       @NotBlank(message = "El correo es obligatorio") @Email(message = "El correo no es valido") String email,
                                       @NotBlank(message = "La contraseña es obligatoria") String password,
                                       @NotNull(message = "El telefono es obligatorio") Integer  phoneNumber,
                                       @NotNull(message = "La fecha de nacimiento es obligatoria") LocalDateTime birthDate,
                                       @Valid AuthCreateRoleRequestDto roleDto) {
}
