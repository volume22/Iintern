package com.example.iintern.service.impl;

import com.example.iintern.controller.dto.NewsCreateDto;
import com.example.iintern.model.News;
import com.example.iintern.repository.NewsRepository;
import com.example.iintern.service.NewsInterface;
import com.example.iintern.service.ThemeInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsInterface {
    private final NewsRepository newsRepository;
    private final ThemeInterface themeInterface;
    @Override
    public News createNews(NewsCreateDto createDto) throws Exception {
        News news = new News();
        news.setDescription(createDto.getDescription());
        news.setTheme(themeInterface.getById(createDto.getThemeId()));
        return newsRepository.save(news);
    }

    @Override
    public News updateNews(Long id, NewsCreateDto createDto) throws Exception {
        News news = newsRepository.findById(id).orElseThrow();
        if (id != null) {
            news.setDescription(createDto.getDescription());
            news.setTheme(themeInterface.getById(createDto.getThemeId()));
        }
        return newsRepository.save(news);
    }

    @Override
    public News getById(Long id) throws Exception {
        return newsRepository.findById(id).orElseThrow();
    }

    @Override
    public List<News> getByAll() throws Exception {
        return newsRepository.findAll();
    }

    @Override
    public void deleteById(Long id) throws Exception {
        newsRepository.deleteById(id);
    }

}
