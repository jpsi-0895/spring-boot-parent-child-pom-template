package com.evytechno.product_service.controller;


import com.evytechno.product_service.dtos.ProductResponseDto;
import com.evytechno.product_service.dtos.ProductRequestDto;
import com.evytechno.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<String>  addProduct(@RequestBody ProductRequestDto request){
        productService.addProduct(request);
        return ResponseEntity.ok("product added successfully");
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

}
