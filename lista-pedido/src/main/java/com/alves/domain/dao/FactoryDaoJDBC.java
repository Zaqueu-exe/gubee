package com.alves.domain.dao;

import com.alves.db.DB;
import com.alves.domain.dao.daoAbstract.ProdutoDao;
import com.alves.domain.dao.daoAbstract.TecnologiaDao;
import com.alves.domain.dao.impl.ProdutoDaoJDBC;
import com.alves.domain.dao.impl.ProdutoProxy;
import com.alves.domain.dao.impl.TecnologiaDaoJDBC;
import com.alves.domain.dao.impl.TecnologiaProxy;

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
