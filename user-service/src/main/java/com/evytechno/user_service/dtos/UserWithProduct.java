package com.evytechno.user_service.dtos;

public record UserWithProduct(
        UserResponseDto user,
        ProductResponseDto product
) {
}
