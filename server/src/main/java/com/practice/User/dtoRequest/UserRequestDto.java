package com.practice.User.dtoRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO para representar un usuario")
public class UserRequestDto {

    @Schema(description = "URL de la foto", required = false, example = "https://example.com/photo.jpg")
    private String photoUrl;

    @Schema(description = "Nombre del usuario", required = true, example = "Juan")
    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @Schema(description = "Apellido del usuario", required = true, example = "Perez")
    @NotBlank(message = "El apellido es obligatorio")
    private String lastName;

    @Schema(description = "Correo del usuario", required = true, example = "7o5f1@example.com")
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no es valido")
    private String email;

    @Schema(description = "Contraseña del usuario", required = true, example = "password123")
    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

    @Schema(description = "Telefono del usuario", required = true, example = "1234567890")
    @NotNull(message = "El telefono es obligatorio")
    private Integer phoneNumber;

    @Schema(description = "Fecha de nacimiento del usuario", required = true, example = "1990-01-01T00:00:00")
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDateTime birthDate;
}
