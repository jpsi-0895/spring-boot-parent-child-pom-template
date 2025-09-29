package com.evytechno.product_service.dtos;

public record ProductResponseDto(
        Long id,
        String productName,
        BlogResponse blog
) {
}
