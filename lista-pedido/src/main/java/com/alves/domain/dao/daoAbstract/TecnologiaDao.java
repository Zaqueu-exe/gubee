package com.alves.domain.dao.daoAbstract;

import com.alves.domain.entities.Tecnologia;

import java.util.List;

public interface TecnologiaDao {

    void inserir(Tecnologia tecnologia);

    List<Tecnologia> findAll();
}
