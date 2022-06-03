package com.example.domain.dao;

import com.example.domain.dao.daoAbstract.ProductDao;
import com.example.domain.dao.daoAbstract.TechnologyDao;

public interface AbstractDaoFactory {


    public ProductDao getProductDao();

    public TechnologyDao getTechnologyDao();

}
