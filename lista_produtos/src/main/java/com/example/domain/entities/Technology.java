package com.example.domain.entities;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Data
@Builder
public class Technology implements Serializable {

    private Long id;

    private String name;

}
