package com.example.iintern.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NewsCreateDto {
    private List<Long> sourceId;
    private Long themeId;
    private String description;
}
