package com.alves.resources;

import com.alves.domain.MakeDao;
import com.alves.domain.dao.daoAbstract.TechnologyDao;
import com.alves.domain.entities.Technology;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/technologies")
public class TechnologyResource {

    private TechnologyDao technologyDao = MakeDao.createDaoJDBC().getTechnologyDao();

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll(){
        List<Technology> list = technologyDao.findAll();
        return Response.status(200).entity(list).build();
    }
}
