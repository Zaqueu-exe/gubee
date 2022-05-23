package com.example.domain.dao;

import com.example.db.DB;
import com.example.domain.dao.daoAbstract.ProdutoDao;
import com.example.domain.dao.daoAbstract.TecnologiaDao;
import com.example.domain.dao.impl.ProdutoDaoJDBC;
import com.example.domain.dao.impl.ProdutoProxy;
import com.example.domain.dao.impl.TecnologiaDaoJDBC;
import com.example.domain.dao.impl.TecnologiaProxy;

public class FactoryDaoJDBC implements AbstractFactory{

    @Override
    public ProdutoDao getProdutoDao(){
        return new ProdutoProxy(new ProdutoDaoJDBC(DB.getConnection()));
    }

    @Override
    public TecnologiaDao getTecnologiaDao(){
        return new TecnologiaProxy(new TecnologiaDaoJDBC(DB.getConnection()));
    }
}
