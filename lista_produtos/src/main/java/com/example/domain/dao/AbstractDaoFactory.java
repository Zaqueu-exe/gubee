package com.example.domain.dao;

import com.example.db.DB;
import com.example.domain.dao.daoAbstract.ProdutoDao;
import com.example.domain.dao.daoAbstract.TecnologiaDao;
import com.example.domain.dao.impl.ProdutoDaoJDBC;
import com.example.domain.dao.impl.TecnologiaDaoJDBC;

public interface AbstractDaoFactory {


    public ProdutoDao getProdutoDao();

    public TecnologiaDao getTecnologiaDao();

}
