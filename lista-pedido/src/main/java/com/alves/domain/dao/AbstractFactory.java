package com.alves.domain.dao;

import com.alves.domain.dao.daoAbstract.ProdutoDao;
import com.alves.domain.dao.daoAbstract.TecnologiaDao;
import com.alves.domain.dao.enums.TypeDao;

public interface AbstractFactory {

    public static AbstractFactory getDaoFactory(TypeDao type){
        return switch (type){
            case DAOJDBC -> new FactoryDaoJDBC();
            default -> null;
        };
    }
    public ProdutoDao getProdutoDao();

    public TecnologiaDao getTecnologiaDao();

}
