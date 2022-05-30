package com.example.db;

import com.example.domain.dao.AbstractDaoFactory;
import com.example.domain.dao.daoAbstract.ProdutoDao;
import com.example.domain.dao.daoAbstract.TecnologiaDao;
import com.example.domain.entities.Produto;
import com.example.domain.entities.Tecnologia;

import java.sql.SQLException;

public class IniciarBancoH2 {

    private ProdutoDao produtoDao = AbstractDaoFactory.getProdutoDao();
    private TecnologiaDao tecnologiaDao = AbstractDaoFactory.getTecnologiaDao();

    public void iniciarBanco() throws SQLException {
        H2.createTables();
        this.inserirTecnologias();
        this.inserirProdutos();
        this.inserirTecnologiasInProduct();
    }

    private void inserirProdutos(){
        produtoDao.inserir(new Produto(null, "Yahoo", "site de entreterimento", "Publico geral"));
        produtoDao.inserir(new Produto(null, "G1", "", "Publico geral"));
        produtoDao.inserir(new Produto(null, "R7", "Site de noticias", "Publico geral"));
        produtoDao.inserir(new Produto(null, "Google chrome", "Buscador", "Publico geral"));
        produtoDao.inserir(new Produto(null, "Visual Studio", "Programa para desenvolvimento", "Programadores"));
    }
    private void inserirTecnologias(){
        tecnologiaDao.inserir(new Tecnologia(null, "HTML"));
        tecnologiaDao.inserir(new Tecnologia(null, "SQL"));
        tecnologiaDao.inserir(new Tecnologia(null, "JavaScript"));
        tecnologiaDao.inserir(new Tecnologia(null, "Java"));
        tecnologiaDao.inserir(new Tecnologia(null, "CSS"));
        tecnologiaDao.inserir(new Tecnologia(null, "XML"));
    }
    private void inserirTecnologiasInProduct(){
        produtoDao.inserirTecnologiaAoProduto(new Produto(1L, null, null, null), new Tecnologia(1L, null));
        produtoDao.inserirTecnologiaAoProduto(new Produto(1L, null, null, null), new Tecnologia(2L, null));

        produtoDao.inserirTecnologiaAoProduto(new Produto(2L, null, null, null), new Tecnologia(3L, null));
        produtoDao.inserirTecnologiaAoProduto(new Produto(2L, null, null, null), new Tecnologia(5L, null));

        produtoDao.inserirTecnologiaAoProduto(new Produto(3L, null, null, null), new Tecnologia(4L, null));

        produtoDao.inserirTecnologiaAoProduto(new Produto(4L, null, null, null), new Tecnologia(1L, null));
        produtoDao.inserirTecnologiaAoProduto(new Produto(4L, null, null, null), new Tecnologia(2L, null));
        produtoDao.inserirTecnologiaAoProduto(new Produto(4L, null, null, null), new Tecnologia(3L, null));
        produtoDao.inserirTecnologiaAoProduto(new Produto(4L, null, null, null), new Tecnologia(5L, null));
    }
}
