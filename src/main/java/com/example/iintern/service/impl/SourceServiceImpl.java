package com.example.iintern.service.impl;

import com.example.iintern.controller.dto.SourceCreateDto;
import com.example.iintern.model.News;
import com.example.iintern.model.Source;
import com.example.iintern.repository.SourceRepository;
import com.example.iintern.service.SourceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SourceServiceImpl implements SourceInterface {

    private final SourceRepository sourceRepository;
    @Override
    public Source createSource(SourceCreateDto createDto) throws Exception {
        Source source = new Source();
        source.setName(createDto.getName());
        return sourceRepository.save(source);
    }

    @Override
    public Source updateSource(Long id, SourceCreateDto createDto) throws Exception {
        Source source = sourceRepository.findById(id).orElseThrow();
        if (id != null) {
            source.setName(createDto.getName());
        }
        return sourceRepository.save(source);
    }

    @Override
    public Source getById(Long id) throws Exception {
        return sourceRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Source> getByAll() throws Exception {
        return sourceRepository.findAll();
    }

    @Override
    public void deleteById(Long id) throws Exception {
        sourceRepository.deleteById(id);
    }
}
