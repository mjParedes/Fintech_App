package com.practice.User.dtoResponse;

import com.practice.User.dtoRequest.AuthCreateUserRequestDto;
import com.practice.User.dtoRequest.UserRequestDto;

import java.util.List;

public record UserPageResponse (
        List<UserRequestDto> users,
        int totalPages,
        long totalElements
){
}
