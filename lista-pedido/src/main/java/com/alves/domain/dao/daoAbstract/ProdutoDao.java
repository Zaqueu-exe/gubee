package com.alves.domain.dao.daoAbstract;

import com.alves.domain.entities.Produto;
import com.alves.domain.entities.Tecnologia;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface ProdutoDao {

    void inserir(Produto produto);

    void inserirTecnologiaAoProduto(Produto produto, Tecnologia tecnologia);

    List<Produto> findAll();

    Produto findById(Produto produto);

    Set<Produto> findBytecnologia(Tecnologia... tecnologias);

    List<Produto> findByMercadoAlvo(String mercadoAlvo);

}
