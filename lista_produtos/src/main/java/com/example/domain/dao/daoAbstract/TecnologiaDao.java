package com.example.domain.dao.daoAbstract;

import com.example.domain.entities.Tecnologia;

import java.util.List;

public interface TecnologiaDao {

    void inserir(Tecnologia tecnologia);

    List<Tecnologia> findAll();
}
