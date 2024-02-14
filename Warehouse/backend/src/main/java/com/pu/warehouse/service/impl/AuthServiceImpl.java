package com.pu.warehouse.service.impl;

import com.pu.warehouse.model.dto.UserRegisterDTO;
import com.pu.warehouse.model.entity.User;
import com.pu.warehouse.repository.UserRepository;
import com.pu.warehouse.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void registerUser(UserRegisterDTO userRegisterDTO) {

        User user = new User();

        user.setUsername(userRegisterDTO.getUsername());
        user.setEmail(userRegisterDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        user.setPhoneNumber(userRegisterDTO.getPhoneNumber());

        userRepository.save(user);
    }
}
