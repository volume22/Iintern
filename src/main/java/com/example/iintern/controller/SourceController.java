package com.example.iintern.controller;


import com.example.iintern.controller.dto.SourceCreateDto;
import com.example.iintern.model.Source;
import com.example.iintern.service.SourceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SourceController {
    private final SourceInterface sourceInterface;
    @PostMapping("/api/source")
    public Source createNews(@RequestBody SourceCreateDto createDto) throws Exception {
        return sourceInterface.createSource(createDto);
    }
    @PutMapping("/api/source/{id}")
    public Source updateNews(@PathVariable Long id, @RequestBody SourceCreateDto createDto) throws Exception {
        return sourceInterface.updateSource(id,createDto);
    }
    @GetMapping("/api/source-all")
    public List<Source> getbyAll() throws Exception {
        return sourceInterface.getByAll();
    }
    @GetMapping("/api/source/{id}")
    public Source getById(@PathVariable Long id) throws Exception {
        return sourceInterface.getById(id);
    }
    @DeleteMapping ("/api/source/{id}")
    public void deleteCoffee(@PathVariable Long id) throws Exception {
        sourceInterface.deleteById(id);
    }
}
