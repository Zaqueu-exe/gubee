package com.alves.domain.dao.impl;

import com.alves.domain.dao.daoAbstract.TecnologiaDao;
import com.alves.domain.entities.Tecnologia;

import java.util.List;

public class TecnologiaProxy implements TecnologiaDao {

    private TecnologiaDao service;

    public TecnologiaProxy(TecnologiaDao service) {
        this.service = service;
    }

    @Override
    public void inserir(Tecnologia tecnologia) {
        if(tecnologia.getNome() == null){
            throw new IllegalArgumentException("Tecnologia without name! ");
        }
        service.inserir(tecnologia);
    }

    @Override
    public List<Tecnologia> findAll() {
        return service.findAll();
    }
}
