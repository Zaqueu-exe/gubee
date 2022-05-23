package com.example.domain.dao;

import com.example.domain.dao.daoAbstract.ProdutoDao;
import com.example.domain.dao.daoAbstract.TecnologiaDao;
import com.example.domain.dao.enums.TypeDao;

public interface AbstractFactory {

    public static AbstractFactory getDaoFactory(TypeDao type) {
        AbstractFactory obj = null;
        switch (type) {
            case DAOJDBC:
                obj = new FactoryDaoJDBC();
                break;
        }
        
        return obj;
    }

    public ProdutoDao getProdutoDao();

    public TecnologiaDao getTecnologiaDao();

}
