package com.alves.domain.dao.impl;

import com.alves.db.DB;
import com.alves.domain.dao.daoAbstract.ProdutoDao;
import com.alves.domain.entities.Produto;
import com.alves.domain.entities.Tecnologia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoDaoJDBCTest {
    private ProdutoDao produtoDao;

    @BeforeEach
    private void setUp(){
        produtoDao = new ProdutoDaoJDBC(DB.getConnection());
    }

    @Test
    void inserir() {
        Produto produto = new Produto(null, "Notebook", "Produto para uso pessoaç", "Todas as pessoas");
        produtoDao.inserir(produto);
        Produto produtoFound = produtoDao.findById(produto);
        Assertions.assertEquals(produtoFound.getNome(), produto.getNome());
    }

    @Test
    void findAll() {
    }

    @Test
    void findBytecnologia() {
    }

    @Test
    void findByMercadoAlvo() {
    }
}