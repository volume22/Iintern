package com.example.iintern.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsCreateDto {
    private Long sourceId;
    private Long themeId;
    private String description;
}
