package com.example.iintern.service;

import com.example.iintern.controller.dto.UserCreateDto;
import com.example.iintern.model.User;

import java.util.Optional;

public interface UserInterface {
    User registration(UserCreateDto dto);
    Optional<User> findByUsername(String username);
    String login(UserCreateDto dto);
}
