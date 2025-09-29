package com.evytechno.blog_service.controller;

import com.evytechno.blog_service.dtos.BlogRequest;
import com.evytechno.blog_service.dtos.BlogResponse;
import com.evytechno.blog_service.entity.Blog;
import com.evytechno.blog_service.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {
       private final BlogService blogService;

       @PostMapping
       public ResponseEntity<String>   addBlog(@RequestBody BlogRequest request){
           blogService.addBlog(request);
           return ResponseEntity.status(HttpStatus.CREATED).body("blog added successfully");
       }

       @GetMapping("/{id}")
       public ResponseEntity<BlogResponse>   getBlogById(@PathVariable Long id){
           return ResponseEntity.ok(blogService.getBlogById(id));
       }
}
