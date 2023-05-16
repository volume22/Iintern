package com.example.iintern.service.impl;

import com.example.iintern.controller.dto.NewsCreateDto;
import com.example.iintern.model.News;
import com.example.iintern.model.Source;
import com.example.iintern.repository.NewsRepository;
import com.example.iintern.service.NewsInterface;
import com.example.iintern.service.SourceInterface;
import com.example.iintern.service.ThemeInterface;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<Source, Integer> getNewsCountBySource() {
        List<News> allNews = newsRepository.findAllFetchNewsSource();
        Map<Source, Integer> sourceNewsCount = new HashMap<>();

        for (News news : allNews) {
            Hibernate.initialize(news.getNewsSource());

            List<Source> newsSources = news.getNewsSource();

            for (Source source : newsSources) {
                sourceNewsCount.put(source, sourceNewsCount.getOrDefault(source, 0) + 1);
            }
        }

        return sourceNewsCount;
    }


    @Override
    public void deleteById(Long id) throws Exception {
        newsRepository.deleteById(id);
    }


}
