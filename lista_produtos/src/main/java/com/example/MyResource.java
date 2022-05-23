package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.domain.dao.AbstractFactory;
import com.example.domain.dao.daoAbstract.ProdutoDao;
import com.example.domain.dao.enums.TypeDao;
import com.example.domain.entities.Produto;
import com.example.domain.entities.Tecnologia;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty.Type;
import com.google.gson.Gson;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("produtos")
public class MyResource {

    @GET
    @Path("tecnologias/{tecnologia}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll(@PathParam("tecnologia") String nome) {
        Set<Produto> lista = new HashSet(); 

        AbstractFactory factory = AbstractFactory.getDaoFactory(TypeDao.DAOJDBC);
        ProdutoDao produtoDao = factory.getProdutoDao();

        Tecnologia  tecnologia = new Tecnologia(null, nome); 

        lista = produtoDao.findBytecnologia(tecnologia);
        
        return new Gson().toJson(lista);
    }

    @GET
    @Path("mercadoalvo/{mercadoAlvo}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByMercadoAlvo(@PathParam("mercadoAlvo") String mercadoAlvo) {

        List<Produto> lista = new ArrayList<>(); 

        AbstractFactory factory = AbstractFactory.getDaoFactory(TypeDao.DAOJDBC);
        ProdutoDao produtoDao = factory.getProdutoDao();

        lista = produtoDao.findByMercadoAlvo(mercadoAlvo);
        
        return new Gson().toJson(lista);
    }
}
