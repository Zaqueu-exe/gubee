package com.alves.model.dao;

import com.alves.db.DB;
import com.alves.model.dao.impl.PessoaDaoJDBC;
import com.alves.model.dao.impl.Proxy;
import com.alves.model.entities.Pessoa;

public class ConcreteFactoryPessoa implements AbstractFactory{

    @Override
    public Proxy createProxyPessoa(){
        return new Proxy(new PessoaDaoJDBC(DB.getConnection()));
    }

    @Override
    public Pessoa createPessoa() {
        return new Pessoa();
    }
}
