package com.example.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(nullable = false, unique = true, length = 100)
    private String username;
    @Column(length = 200, nullable = false)
    private String password;
    @Column(length = 200, nullable = false, unique = true)
    private String email;
    @Column(length = 15, nullable = false, unique = true)
    private String phone;
    @Column(length = 200, nullable = false)
    private String fullName;
}
