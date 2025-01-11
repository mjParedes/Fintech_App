package com.practice.User.dtoRequest;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequestDto(@NotBlank(message = "El email es obligatorio") String email,
                                  @NotBlank(message = "La contraseña es obligatoria") String password) {
}
