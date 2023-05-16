package com.example.iintern.repository;

import com.example.iintern.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface NewsRepository extends JpaRepository<News,Long> {
    List<News> findAllByNewsSource_Id(Long sourceId);
    List<News> findAllByTheme_Id(Long themeId);
    @Query(value = "SELECT DISTINCT n FROM News n JOIN FETCH n.newsSource")
    List<News> findAllFetchNewsSource();


}
