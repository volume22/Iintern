package com.example.iintern.service;

import com.example.iintern.controller.dto.SourceCreateDto;
import com.example.iintern.controller.dto.ThemeCreateDto;
import com.example.iintern.model.Theme;

import java.util.List;

public interface ThemeInterface {
    Theme createTheme(ThemeCreateDto createDto)throws Exception;
    Theme updateTheme(Long id, ThemeCreateDto createDto)throws Exception;
    Theme getById(Long id)throws Exception;
    List<Theme> getByAll()throws Exception;
    void deleteById(Long id)throws Exception;
}
