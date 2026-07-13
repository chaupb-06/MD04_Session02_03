package com.example.userservice.service;

import com.example.userservice.dto.request.CreateUserRequest;
import com.example.userservice.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> findAll();
    UserResponseDTO create(CreateUserRequest createUserRequest);
}
