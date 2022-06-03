package com.example.domain.entities;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
public @Data class Product implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String targetMarket;
    private List<Technology> technologies = new ArrayList<>();
}
