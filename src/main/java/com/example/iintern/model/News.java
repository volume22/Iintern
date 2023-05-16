package com.example.iintern.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "news")
@Getter
@Setter
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Description;
    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;
    @ManyToMany
    private List<Source> newsSource;
}
