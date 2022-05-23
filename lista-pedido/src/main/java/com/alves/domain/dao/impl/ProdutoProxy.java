package com.alves.domain.dao.impl;

import com.alves.domain.dao.daoAbstract.ProdutoDao;
import com.alves.domain.entities.Produto;
import com.alves.domain.entities.Tecnologia;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProdutoProxy implements ProdutoDao {

    private ProdutoDao service;

    public ProdutoProxy(ProdutoDao service) {
        this.service = service;
    }

    @Override
    public void inserir(Produto produto) {
        service.inserir(produto);
    }

    @Override
    public void inserirTecnologiaAoProduto(Produto produto, Tecnologia tecnologia) {
        service.inserirTecnologiaAoProduto(produto, tecnologia);
    }

    @Override
    public List<Produto> findAll() {
        return service.findAll();
    }

    @Override
    public Produto findById(Produto produto) {
        return service.findById(produto);
    }

    @Override
    public Set<Produto> findBytecnologia(Tecnologia... tecnologias) {
        Set<Produto> produtos = new HashSet<>();
        for(Tecnologia t : tecnologias){
            produtos.addAll(service.findBytecnologia(t));
        }
        return produtos;
    }

    @Override
    public List<Produto> findByMercadoAlvo(String mercadoAlvo) {
        return service.findByMercadoAlvo(mercadoAlvo);
    }
}
