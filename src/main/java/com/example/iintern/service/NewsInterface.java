package com.example.iintern.service;

import com.example.iintern.controller.dto.NewsCreateDto;
import com.example.iintern.model.News;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface NewsInterface {
    News createNews(NewsCreateDto createDto) throws Exception;

    News updateNews(Long id, NewsCreateDto createDto) throws Exception;

    News getById(Long id) throws Exception;

    List<News> getByAll();

    Page<News> findNewsWithPagination(int offset, int pagSize);

    Page<News> getNewsBySortPaginate(int offset, int pagSize, String id);

    List<News> getNewsBySource_Id(Long sourceId);

    List<News> findAllByTheme_Id(Long themeId);

    void deleteById(Long id) throws Exception;

}
