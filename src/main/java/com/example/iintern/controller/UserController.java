package com.example.iintern.controller;

import com.example.iintern.controller.dto.UserCreateDto;
import com.example.iintern.service.UserInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserInterface userInterface;

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody @Validated UserCreateDto dto) {
        if(userInterface.findByUsername(dto.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        userInterface.registration(dto);
        return ResponseEntity.ok("User registered");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserCreateDto dto) {
        return ResponseEntity.ok(userInterface.login(dto));
    }
}
