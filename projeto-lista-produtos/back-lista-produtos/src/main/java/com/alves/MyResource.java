package com.alves;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alves.db.h2.StartDataBaseH2;
import com.alves.domain.MakeDao;
import com.alves.domain.dao.daoAbstract.ProductDao;
import com.alves.domain.entities.Product;


@Path("products")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class MyResource {

    private ProductDao productDao = MakeDao.createDaoJDBC().getProductDao();


    public MyResource() {
        StartDataBaseH2 h2 = new StartDataBaseH2();
    }

    @GET
    public Response getAll() {
        List<Product> list = productDao.findAll();
        return Response.status(200).entity(list).build();
    }

    @GET
    @Path("technologies/{technology}")
    public Response getByTechology(@PathParam("technology") String name) {

        List<Product> list = productDao.findByTechnology(name);
        return Response.status(200).entity(list).build();
    }

    @GET
    @Path("targetmarket/{targetmarket}")
    public Response getByTargetMarket(@PathParam("targetmarket") String targetmarket) {

        List<Product> list = productDao.findByTargetMarket(targetmarket);
        return Response.status(200).entity(list).build();
    }
}
