package com.alves;

import com.alves.domain.dao.AbstractFactory;
import com.alves.domain.dao.FactoryDaoJDBC;
import com.alves.domain.dao.enums.TypeDao;
import com.alves.domain.entities.Produto;
import com.alves.domain.entities.Tecnologia;


public class Main {
    public static void main(String[] args) {

        var objdao = AbstractFactory.getDaoFactory(TypeDao.DAOJDBC);
        var produtodao = objdao.getProdutoDao();

        var tecnologiaDao = objdao.getTecnologiaDao();

       /* Produto p = new Produto();
        p.setId(3L);
        Tecnologia t = new Tecnologia();
        t.setId(4l);*/

       // produtodao.inserirTecnologiaAoProduto(p, t);
        //produtodao.findBytecnologia(new Tecnologia(null, "SQL")).forEach(System.out::println);
        //Tecnologia[] tecnologias = {new Tecnologia(null, "SQL"), new Tecnologia(null, "Lua")};
       // produtodao.findBytecnologia(tecnologias).forEach(System.out::println);
       // produtodao.findByMercadoAlvo("Publico geral").forEach(System.out::println);
        var tecnologiadao = objdao.getTecnologiaDao();
        produtodao.findAll().forEach(System.out::println);
        System.out.println("-----------");
        tecnologiaDao.findAll().forEach(System.out::println);
    }
}