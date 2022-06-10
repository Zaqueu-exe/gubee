package com.example.domain.entities;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
public class Technology implements Serializable {

    private Long id;

    private String name;

}
