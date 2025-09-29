package com.evytechno.product_service.feign;

import com.evytechno.product_service.dtos.BlogResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "blog-service",url = "${blog.service.url}")
public interface BlogClient {

    @GetMapping("blog/{id}")
    BlogResponse  getBlog(@PathVariable Long id);
}
