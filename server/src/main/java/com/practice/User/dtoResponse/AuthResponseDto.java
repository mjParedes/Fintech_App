package com.practice.User.dtoResponse;

public record AuthResponseDto (Long id, String email, String message, String token, boolean success) {
}
