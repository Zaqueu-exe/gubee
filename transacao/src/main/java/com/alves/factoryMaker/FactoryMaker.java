package com.alves.factoryMaker;

import com.alves.factoryMaker.enums.PessoaType;
import com.alves.model.dao.ConcreteFactoryPessoa;
import com.alves.model.dao.PessoaDao;
import com.alves.model.entities.Pessoa;

public class FactoryMaker {

    public static Pessoa createPessoa(PessoaType type){
        return switch (type){
            case PESSOA -> new ConcreteFactoryPessoa().createPessoa();
            default -> null;
        };
    }

    public static PessoaDao createProxy(PessoaType type){
        return switch (type){
            case PESSOA -> new ConcreteFactoryPessoa().createProxyPessoa();
            default -> null;
        };
    }
}
