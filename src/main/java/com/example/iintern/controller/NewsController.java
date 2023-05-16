package com.example.iintern.controller;

import com.example.iintern.controller.dto.NewsCreateDto;
import com.example.iintern.model.News;
import com.example.iintern.service.NewsInterface;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class NewsController {
    private final NewsInterface newsInterface;
    @PostMapping("/api/news")
    public News createNews(@RequestBody NewsCreateDto createDto) throws Exception {
        return newsInterface.createNews(createDto);
    }
    @PutMapping("/api/news/{id}")
    public News updateNews(@PathVariable Long id, @RequestBody NewsCreateDto createDto) throws Exception {
        return newsInterface.updateNews(id,createDto);
    }
    @GetMapping("/api/news-all")
    public List<News> getByAll() throws Exception {
        return newsInterface.getByAll();
    }
    @GetMapping("/api/news/{id}")
    public News getById(@PathVariable Long id) throws Exception {
        return newsInterface.getById(id);
    }
    @DeleteMapping ("/api/news/{id}")
    public void deleteCoffee(@PathVariable Long id) throws Exception {
        newsInterface.deleteById(id);
    }

}
