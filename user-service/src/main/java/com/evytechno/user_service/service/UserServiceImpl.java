package com.evytechno.user_service.service;

import com.evytechno.user_service.dtos.ProductResponseDto;
import com.evytechno.user_service.dtos.UserRequestDto;
import com.evytechno.user_service.dtos.UserResponseDto;
import com.evytechno.user_service.dtos.UserWithProduct;
import com.evytechno.user_service.entity.User;
import com.evytechno.user_service.feign.ProductClient;
import com.evytechno.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final ProductClient productClient;
    @Override
    public void addUser(UserRequestDto request) {
        User user = new User();
        user.setName(request.name());
        userRepository.save(user);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found"));

         return new UserResponseDto(
                 user.getId(),
                 user.getName()
         );
    }

    @Override
    public UserWithProduct getUserWithProduct(Long userId, Long productId) {
        Optional<User> user = userRepository.findById(userId);
        UserResponseDto userResponse = new UserResponseDto(
                userId,
                user.get().getName()
        );
        ProductResponseDto product = productClient.getProduct(productId);
        return new UserWithProduct(userResponse,product);
    }
}
