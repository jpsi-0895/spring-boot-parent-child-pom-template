package com.evytechno.user_service.controller;


import com.evytechno.user_service.dtos.UserRequestDto;
import com.evytechno.user_service.dtos.UserResponseDto;
import com.evytechno.user_service.dtos.UserWithProduct;
import com.evytechno.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
       private final UserService userService;

       @PostMapping
        public ResponseEntity<String>   addUser(@RequestBody UserRequestDto request){
           userService.addUser(request);
           return ResponseEntity.ok("user added successfully");
       }

       @GetMapping("/{userId}/with-product/{productId}")
       public ResponseEntity<UserWithProduct>  getUserWithProduct(@PathVariable Long userId,@PathVariable Long productId){
           return ResponseEntity.ok(userService.getUserWithProduct(userId,productId));
       }

       @GetMapping("/{id}")
      public  ResponseEntity<UserResponseDto>  getUserById(@PathVariable Long id){
           return ResponseEntity.ok(userService.getUserById(id));
       }
}
