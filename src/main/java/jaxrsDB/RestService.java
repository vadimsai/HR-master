package jaxrsDB;


import jtaproject.Users;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;


@Path("/restDB")
public class RestService  {

    @EJB
    DBRestOperation dbRestOperation;

    @POST
    @Path("/persist")
    @Produces({"text/plain"})
    public Response persist(@FormParam("name") String name,
                         @FormParam("surname") String surname,
                         @FormParam("birthDate") String birthDate,
                         @FormParam("address") String address)
    {
        Users users=new Users(name,surname,birthDate,address);
        String message= dbRestOperation.persist(users);
        URI uri = UriBuilder.fromPath("http://localhost:8080/HrProject_war/GetAll.jsp").
                queryParam("message",message).build();

        return  Response.seeOther(uri).build();
    }


    @POST
    @Path("/update")
    @Produces({"text/plain"})
    public Response update(@FormParam("name") String name,
                         @FormParam("id") int id,
                         @FormParam("surname") String surname,
                         @FormParam("birthDate") String birthDate,
                         @FormParam("address") String address)
    {
        String message= dbRestOperation.merge(id,name,surname,birthDate,address);
        URI uri = UriBuilder.fromPath("http://localhost:8080/HrProject_war/GetAll.jsp").
                queryParam("messagee",message).build();


        return  Response.seeOther(uri).build();
    }


    @POST
    @Path("/delete")
    @Produces("text/plain")
    public Response delete(@FormParam("id") int id)
    {
      String message= dbRestOperation.remove(id);
        URI uri = UriBuilder.fromPath("http://localhost:8080/HrProject_war/GetAll.jsp").
                queryParam("messag",message).build();
       return  Response.seeOther(uri).build();
    }

    @GET
    @Path("/Allxml")
    @Produces(MediaType.APPLICATION_XML)
  public List<Users> getALLx()
  {
      List<Users> list=dbRestOperation.selectAll();

      return list;
    }
    @GET
    @Path("/Alljson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> getALLj()
    {
        List<Users> list=dbRestOperation.selectAll();

        return list;
    }


}
