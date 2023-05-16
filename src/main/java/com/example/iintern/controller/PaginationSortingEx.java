package com.example.iintern.controller;

import com.example.iintern.controller.dto.APIResponse;
import com.example.iintern.model.News;
import com.example.iintern.service.NewsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class PaginationSortingEx {
    @Autowired
    private NewsInterface newsInterface;
    @GetMapping
    private APIResponse<List<News>> getNews(){
        List<News> news = newsInterface.getByAll();
        return new APIResponse<>(news.size(),news);
    }
    @GetMapping("/news-source/{sourceId}")
    private APIResponse<List<News>> getNewsBySource(@PathVariable Long sourceId){
        List<News> news = newsInterface.getNewsBySource_Id(sourceId);
        return new APIResponse<>(news.size(),news);
    }
    @GetMapping("/news-theme/{themeId}")
    private APIResponse<List<News>> getNewsByTheme(@PathVariable Long themeId){
        List<News> news = newsInterface.findAllByTheme_Id(themeId);
        return new APIResponse<>(news.size(),news);
    }
    @GetMapping("/news-sort/{offset}/{pageSize}/{id}")
    private APIResponse<Page<News>> getNewsByPaginationAndSort(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String id ){
        Page<News> newsPage = newsInterface.getNewsBySortPaginate(offset,pageSize,id);
        return new APIResponse<>(newsPage.getSize(),newsPage);
    }
    @GetMapping("/news-pagination/{offset}/{pageSize}")
    private APIResponse<Page<News>> getNewsByPagination(@PathVariable int offset,@PathVariable int pageSize){
       Page<News> newsPage = newsInterface.findNewsWithPagination(offset,pageSize);
        return new APIResponse<>(newsPage.getSize(),newsPage);
    }

}
