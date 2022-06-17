package com.alves.domain.entities;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class Product implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String targetMarket;
    private List<Technology> technologies = new ArrayList<>();
}
