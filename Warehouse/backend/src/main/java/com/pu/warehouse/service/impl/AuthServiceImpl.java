package com.pu.warehouse.service.impl;

import com.pu.warehouse.model.dto.UserRegisterDTO;
import com.pu.warehouse.model.entity.User;
import com.pu.warehouse.repository.UserRepository;
import com.pu.warehouse.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {


    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void registerUser(UserRegisterDTO userRegisterDTO) {

        User user = new User();

        user.setUsername(userRegisterDTO.getUsername());
        user.setEmail(userRegisterDTO.getEmail());
        user.setPassword(userRegisterDTO.getPassword());

        userRepository.save(user);
    }
}
