package com.evytechno.user_service.feign;


import com.evytechno.user_service.dtos.ProductResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductClient {
        @GetMapping("/product/{id}")
        ProductResponseDto getProduct(@PathVariable Long id);

}


