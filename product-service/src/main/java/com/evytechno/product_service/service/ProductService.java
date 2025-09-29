package com.evytechno.product_service.service;

import com.evytechno.product_service.dtos.ProductResponseDto;
import com.evytechno.product_service.dtos.ProductRequestDto;

public interface ProductService {

      void    addProduct(ProductRequestDto request);
      ProductResponseDto getProductById(Long id);
}
