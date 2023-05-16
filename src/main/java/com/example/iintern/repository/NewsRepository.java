package com.example.iintern.repository;

import com.example.iintern.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NewsRepository extends JpaRepository<News,Long> {
    List<News> findAllByNewsSource_Id(Long sourceId);
    List<News> findAllByTheme_Id(Long themeId);

}
