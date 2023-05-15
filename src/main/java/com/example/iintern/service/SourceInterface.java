package com.example.iintern.service;

import com.example.iintern.controller.dto.NewsCreateDto;
import com.example.iintern.controller.dto.SourceCreateDto;
import com.example.iintern.model.News;
import com.example.iintern.model.Source;

import java.util.List;

public interface SourceInterface {
    Source createSource(SourceCreateDto createDto)throws Exception;
    Source updateSource(Long id, SourceCreateDto createDto)throws Exception;
    Source getById(Long id)throws Exception;
    List<Source> getByAll()throws Exception;
    void deleteById(Long id)throws Exception;
}
