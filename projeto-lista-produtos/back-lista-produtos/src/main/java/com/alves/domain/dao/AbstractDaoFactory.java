package com.alves.domain.dao;

import com.alves.domain.dao.daoAbstract.ProductDao;
import com.alves.domain.dao.daoAbstract.TechnologyDao;

public interface AbstractDaoFactory {


    public ProductDao getProductDao();

    public TechnologyDao getTechnologyDao();

}
