package com.example.domain.dao;

import com.example.db.h2.DBH2;
import com.example.domain.dao.daoAbstract.ProductDao;
import com.example.domain.dao.daoAbstract.TechnologyDao;
import com.example.domain.dao.impl.ProductDaoJDBC;
import com.example.domain.dao.impl.TechnologyDaoJDBC;

public class DAOFactory implements AbstractDaoFactory{

    @Override
    public ProductDao getProductDao() {
        return new ProductDaoJDBC(DBH2.getConnection());
    }

    @Override
    public TechnologyDao getTechnologyDao() {
        return new TechnologyDaoJDBC(DBH2.getConnection());
    }
}
