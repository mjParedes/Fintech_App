package com.practice.User.controller;

import com.practice.User.dtoRequest.AuthCreateUserRequestDto;
import com.practice.User.dtoRequest.UserRequestDto;
import com.practice.User.dtoResponse.UserPageResponse;
import com.practice.User.dtoResponse.UserResponseDto;
import com.practice.User.mapper.UserMapper;
import com.practice.User.model.UserModel;
import com.practice.User.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "User Controller")
@Validated
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve una lista paginada de usuarios.")
    @ApiResponse(responseCode = "200", description = "Usuarios obtenidos exitosamente")
    @GetMapping
    public ResponseEntity<UserPageResponse> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        UserPageResponse response = userService.getAllUsers(page, size);
        return ResponseEntity.ok(response);
    }

    // Obtener un usuario por ID
    @Operation(summary = "Obtener un usuario por ID", description = "Devuelve un usuario por su ID.")
    @ApiResponse(responseCode = "200", description = "Usuario obtenido exitosamente")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
        UserResponseDto user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Actualizar un usuario
    @Operation(summary = "Actualizar un usuario", description = "Actualiza los detalles de un usuario existente.")
    @ApiResponse(responseCode = "200", description = "Usuario actualizado exitosamente")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    @PatchMapping("/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody @Valid UserRequestDto updatedUserDto) {
        UserModel updatedUser = userService.updateUser(id, updatedUserDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Eliminar un usuario
    @Operation(summary = "Eliminar un usuario", description = "Elimina un usuario por su ID.")
    @ApiResponse(responseCode = "204", description = "Usuario eliminado exitosamente")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
