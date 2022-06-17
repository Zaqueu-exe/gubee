package com.alves.domain.dao.daoAbstract;

import com.alves.domain.entities.Technology;

import java.util.List;

public interface TechnologyDao {

    void insert(Technology technology);

    List<Technology> findAll();
}
