package com.alves.model.dao;

import com.alves.db.DB;
import com.alves.model.dao.impl.PessoaDaoJDBC;
import com.alves.model.dao.impl.Proxy;

public interface AbstractFactory {

     static PessoaDaoJDBC createPessoaDao(){
        return new PessoaDaoJDBC(DB.getConnection());
    }
     static Proxy createProxy(){
        return new Proxy(createPessoaDao());
    }
}
