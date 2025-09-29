package com.evytechno.user_service.service;

import com.evytechno.user_service.dtos.UserRequestDto;
import com.evytechno.user_service.dtos.UserResponseDto;
import com.evytechno.user_service.dtos.UserWithProduct;

public interface UserService {

    void addUser(UserRequestDto request);

    UserResponseDto  getUserById(Long id);

    UserWithProduct getUserWithProduct(Long userId,Long productId);

}
