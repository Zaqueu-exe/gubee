package com.example.domain.dao.daoAbstract;

import com.example.domain.entities.Produto;
import com.example.domain.entities.Tecnologia;

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
