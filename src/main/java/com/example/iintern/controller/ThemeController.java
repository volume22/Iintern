package com.example.iintern.controller;


import com.example.iintern.controller.dto.ThemeCreateDto;

import com.example.iintern.model.Theme;

import com.example.iintern.service.ThemeInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ThemeController {
    private final ThemeInterface themeInterface;
    @PostMapping("/api/theme")
    public Theme createNews(@RequestBody ThemeCreateDto createDto) throws Exception {
        return themeInterface.createTheme(createDto);
    }
    @PutMapping("/api/theme/{id}")
    public Theme updateNews(@PathVariable Long id, @RequestBody ThemeCreateDto createDto) throws Exception {
        return themeInterface.updateTheme(id,createDto);
    }
    @GetMapping("/api/theme-all")
    public List<Theme> getbyAll() throws Exception {
        return themeInterface.getByAll();
    }
    @GetMapping("/api/theme/{id}")
    public Theme getById(@PathVariable Long id) throws Exception {
        return themeInterface.getById(id);
    }
    @DeleteMapping ("/api/theme/{id}")
    public void deleteCoffee(@PathVariable Long id) throws Exception {
        themeInterface.deleteById(id);
    }
}
