package com.alves.model.dao;

import com.alves.model.dao.impl.Proxy;
import com.alves.model.entities.Pessoa;

public interface AbstractFactory {
     Proxy createProxyPessoa();

     Pessoa createPessoa();
}
