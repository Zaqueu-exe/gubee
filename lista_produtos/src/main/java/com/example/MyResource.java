package com.example;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.example.domain.MakeDao;
import com.example.domain.dao.daoAbstract.ProductDao;
import com.example.domain.entities.Product;
import com.example.domain.entities.Technology;
import com.google.gson.Gson;
import org.glassfish.grizzly.http.util.HttpStatus;

@Path("products")
public class MyResource{

    private ProductDao productDao = MakeDao.createDaoJDBC().getProductDao();

    @GET
    @Path("technologies/{technology}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@PathParam("technology") String name) {

        Technology technology = new Technology(null, name);

        List<Product> list = productDao.findByTechnology(technology);

        try {
            return Response.ok(new Gson().toJson(list)).build();
        }catch (Exception e){
            return Response.serverError().status(HttpStatus.BAD_REQUEST_400.getStatusCode(), e.getMessage()).build();
        }
    }

    @GET
    @Path("targetmarket/{targetmarket}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByTargetMarket(@PathParam("targetmarket") String targetmarket) {

        List<Product> list = productDao.findByTargetMarket(targetmarket);

        try {
            return Response.ok(new Gson().toJson(list)).build();
        }catch (Exception e){
            return Response.serverError().status(HttpStatus.BAD_REQUEST_400.getStatusCode(), e.getMessage()).build();
        }
    }
}
