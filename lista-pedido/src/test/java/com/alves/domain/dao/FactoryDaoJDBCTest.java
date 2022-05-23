package com.alves.domain.dao;

import com.alves.domain.dao.daoAbstract.ProdutoDao;
import com.alves.domain.dao.daoAbstract.TecnologiaDao;
import com.alves.domain.dao.impl.ProdutoProxy;
import com.alves.domain.dao.impl.TecnologiaProxy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class FactoryDaoJDBCTest {
    private FactoryDaoJDBC factoryDaoJDBC;
    @BeforeEach
    public void setUp(){
        factoryDaoJDBC = new FactoryDaoJDBC();
    }

    @Test
    void getProdutoDao() {
        ProdutoDao a = factoryDaoJDBC.getProdutoDao();
        Assertions.assertEquals(ProdutoProxy.class, a.getClass());
    }

    @Test
    void getTecnologiaDao() {
        TecnologiaDao a = factoryDaoJDBC.getTecnologiaDao();
        Assertions.assertEquals(TecnologiaProxy.class, a.getClass());
    }
}