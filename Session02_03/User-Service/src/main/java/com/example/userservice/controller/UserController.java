package com.example.userservice.controller;

import com.example.userservice.dto.request.CreateUserRequest;
import com.example.userservice.dto.response.ApiResponse;
import com.example.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAllUsers() {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Lấy danh sách người dùng thành công!",
                userService.findAll(),
                null,
                LocalDateTime.now()
        ), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ApiResponse<?>> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Tạo người dùng mới thành công!",
                userService.create(createUserRequest),
                null,
                LocalDateTime.now()
        ), HttpStatus.CREATED);
    }
}
