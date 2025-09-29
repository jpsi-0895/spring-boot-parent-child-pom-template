package com.evytechno.product_service.service;

import com.evytechno.product_service.dtos.BlogResponse;
import com.evytechno.product_service.dtos.ProductResponseDto;
import com.evytechno.product_service.dtos.ProductRequestDto;
import com.evytechno.product_service.entity.Product;
import com.evytechno.product_service.feign.BlogClient;
import com.evytechno.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final BlogClient blogClient;

    @Override
    public void addProduct(ProductRequestDto request) {
        Product product = new Product();
        product.setProductName(request.productName());
        productRepository.save(product);
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("product not found"));
        BlogResponse blog = blogClient.getBlog(id);

        return  new ProductResponseDto(
                product.getId(),
                product.getProductName(),
                blog
        );
    }
}
