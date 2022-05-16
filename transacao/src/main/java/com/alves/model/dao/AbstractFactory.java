package com.alves.model.dao;

import com.alves.db.DB;
import com.alves.model.dao.enums.PessoaType;
import com.alves.model.dao.impl.PessoaDaoJDBC;
import com.alves.model.dao.impl.Proxy;
import com.alves.model.entities.Pessoa;
import com.alves.model.entities.abstractPessoa.PessoaAbstrata;

public interface AbstractFactory {
     public static PessoaAbstrata createPessoa(PessoaType type){
          return switch (type){
               case PESSOA -> new Pessoa();
               default -> null;
          };
     }

     public static PessoaDao createProxy(PessoaType type){
          return switch (type){
               case PESSOA -> new Proxy(new PessoaDaoJDBC(DB.getConnection()));
               default -> null;
          };
     }
}
