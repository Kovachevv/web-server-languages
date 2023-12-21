package com.pu.warehouse.service;

import com.pu.warehouse.model.dto.UserRegisterDTO;

public interface AuthService {

    void registerUser(UserRegisterDTO userRegisterDTO);
}
