package com.example.iintern.service;

import com.example.iintern.controller.dto.NewsCreateDto;
import com.example.iintern.model.News;

import java.util.List;

public interface NewsInterface {
    News createNews(NewsCreateDto createDto)throws Exception;
    News updateNews(Long id,NewsCreateDto createDto)throws Exception;
    News getById(Long id)throws Exception;
    List<News> getByAll()throws Exception;
    void deleteById(Long id)throws Exception;
}
