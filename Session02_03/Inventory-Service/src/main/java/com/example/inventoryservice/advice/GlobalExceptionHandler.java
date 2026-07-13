package com.example.inventoryservice.advice;

import com.example.inventoryservice.dto.response.ApiResponse;
import com.example.inventoryservice.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<?>> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(new ApiResponse<>(
                false,
                "Dữ liệu đã tồn tại!",
                null,
                e.getMessage(),
                LocalDateTime.now()
        ), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(new ApiResponse<>(
                false,
                "Dữ liệu không tồn tại!",
                null,
                e.getMessage(),
                LocalDateTime.now()
        ), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception e) {
        return new ResponseEntity<>(new ApiResponse<>(
                false,
                "Đã có lỗi xảy ra!",
                null,
                e.getMessage(),
                LocalDateTime.now()
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
