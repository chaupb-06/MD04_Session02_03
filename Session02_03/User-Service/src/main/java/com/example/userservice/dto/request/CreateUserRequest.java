package com.example.userservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUserRequest {
    @NotBlank(message = "Không được để trống tên đăng nhập!")
    private String username;
    @NotBlank(message = "Không được để trống mật khẩu!")
    private String password;
    @NotBlank(message = "Không được để trống email!")
    @Email(message = "Sai định dạng email!")
    private String email;
    @NotBlank(message = "Không được để trống số điện thoại!")
    @Pattern(regexp = "^0[1-9]\\d{8}$", message = "Sai định dạng số điện thoại!")
    private String phone;
    @NotBlank(message = "Không được để trống họ và tên!")
    private String fullName;
}
