package com.example.domain.dao.daoAbstract;

import com.example.domain.entities.Technology;

import java.util.List;

public interface TechnologyDao {

    void insert(Technology technology);

    List<Technology> findAll();
}
