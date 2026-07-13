package com.example.userservice.service.Impl;

import com.example.userservice.dto.request.CreateUserRequest;
import com.example.userservice.dto.response.UserResponseDTO;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserResponseDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> UserResponseDTO.builder()
                        .userId(user.getId())
                        .fullName(user.getFullName())
                        .build()
                ).toList();
    }

    @Override
    public UserResponseDTO create(CreateUserRequest createUserRequest) {
        if (userRepository.existsByUsername(createUserRequest.getUsername())) {
            throw new IllegalArgumentException("Username already exists!");
        }
        if (userRepository.existsByEmail(createUserRequest.getEmail())) {
            throw new IllegalArgumentException("Email already exists!");
        }
        if (userRepository.existsByPhone(createUserRequest.getPhone())) {
            throw new IllegalArgumentException("Phone already exists!");
        }
        User user = User.builder()
                .username(createUserRequest.getUsername())
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .email(createUserRequest.getEmail())
                .phone(createUserRequest.getPhone())
                .fullName(createUserRequest.getFullName())
                .build();
        userRepository.save(user);
        return UserResponseDTO.builder()
                .userId(user.getId())
                .fullName(user.getFullName())
                .build();
    }
}
