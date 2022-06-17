package com.alves.domain.dao;

import com.alves.db.h2.DBH2;
import com.alves.domain.dao.daoAbstract.ProductDao;
import com.alves.domain.dao.daoAbstract.TechnologyDao;
import com.alves.domain.dao.impl.ProductDaoJDBC;
import com.alves.domain.dao.impl.TechnologyDaoJDBC;

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
