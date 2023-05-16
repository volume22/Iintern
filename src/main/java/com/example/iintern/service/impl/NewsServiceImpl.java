package com.example.iintern.service.impl;

import com.example.iintern.controller.dto.NewsCreateDto;
import com.example.iintern.model.News;
import com.example.iintern.model.Source;
import com.example.iintern.repository.NewsRepository;
import com.example.iintern.service.NewsInterface;
import com.example.iintern.service.SourceInterface;
import com.example.iintern.service.ThemeInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsInterface {
    private final NewsRepository newsRepository;

    private final ThemeInterface themeInterface;
    private final SourceInterface sourceInterface;

    @Override
    public News createNews(NewsCreateDto createDto) throws Exception {
        News news = new News();
        List<Source> sources = new ArrayList<>();
        news.setDescription(createDto.getDescription());
        news.setTheme(themeInterface.getById(createDto.getThemeId()));
        for (Long in : createDto.getSourceId()) {
            sources.add(sourceInterface.getById(in));
        }
        news.setNewsSource(sources);
        return newsRepository.save(news);
    }

    @Override
    public News updateNews(Long id, NewsCreateDto createDto) throws Exception {
        News news = newsRepository.findById(id).orElseThrow();
        if (id != null) {
            news.setDescription(createDto.getDescription());
            news.setTheme(themeInterface.getById(createDto.getThemeId()));
            for (Long in : createDto.getSourceId()) {
                news.setNewsSource((List<Source>) sourceInterface.getById(in));
            }
        }
        return newsRepository.save(news);
    }

    @Override
    public News getById(Long id) throws Exception {
        return newsRepository.findById(id).orElseThrow();
    }

    @Override
    public List<News> getByAll() {
        return newsRepository.findAll();
    }

    @Override
    public Page<News> findNewsWithPagination(int offset, int pagSize) {
        Page<News> news = newsRepository.findAll(PageRequest.of(offset, pagSize));
        return news;
    }

    @Override
    public Page<News> getNewsBySortPaginate(int offset, int pagSize, String id) {
        Page<News> news = newsRepository.findAll(PageRequest.of(offset, pagSize).withSort(Sort.by(id)));
        return news;
    }

    @Override
    public List<News> getNewsBySource_Id(Long sourceId) {
        return newsRepository.findAllByNewsSource_Id(sourceId);
    }

    @Override
    public List<News> findAllByTheme_Id(Long themeId) {
        return newsRepository.findAllByTheme_Id(themeId);
    }


    @Override
    public void deleteById(Long id) throws Exception {
        newsRepository.deleteById(id);
    }


}
