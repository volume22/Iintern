package com.example.iintern.service.impl;

import com.example.iintern.controller.dto.ThemeCreateDto;
import com.example.iintern.model.Theme;
import com.example.iintern.repository.ThemeRepository;
import com.example.iintern.service.ThemeInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThemeServiceImpl implements ThemeInterface {
    private final ThemeRepository themeRepository;
    @Override
    public Theme createTheme(ThemeCreateDto createDto) throws Exception {
        Theme theme = new Theme();
        theme.setName(createDto.getName());
        return themeRepository.save(theme);
    }

    @Override
    public Theme updateTheme(Long id, ThemeCreateDto createDto) throws Exception {
        Theme theme = themeRepository.findById(id).orElseThrow();
        if (id != null) {
            theme.setName(createDto.getName());
        }
        return themeRepository.save(theme);
    }

    @Override
    public Theme getById(Long id) throws Exception {
        return themeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Theme> getByAll() throws Exception {
        return themeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) throws Exception {
        themeRepository.deleteById(id);
    }
}
