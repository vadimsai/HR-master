package jaxrsDB;


import jtaproject.Users;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

/**
 *@autor VADIM NOVIKOV
 *
 * @Path restful service implementation
 *
 * the user class in the jta module
 *
 *To access the services you can use the extension for chrome "Talend API Tester - Free Edition"
 * Service URI: http://localhost:8080/HrProject_war/restDB
 */
@Path("/restDB")
public class RestService  {

    @EJB
    DBRestOperation dbRestOperation;


    /**
     *
     * for all methods with a return value String
     *
     * @return String
     *
     * i am building a URI from the location of the jsp page, and adding a
     * query parameter to the end of the URI.
     * So the redirect will go to http://localhost:8080/HrProject_war/site2.jsp?message=<the message>
     *
     *
     * Response persist(String name, String surname, String email, String address)
     *
     * @POST http://localhost:8080/HrProject_war/restDB/persist
     */
    @POST
    @Path("/persist")
    @Produces({"text/plain"})
    public Response persist(@FormParam("name") String name,
                         @FormParam("surname") String surname,
                         @FormParam("email") String email,
                         @FormParam("address") String address)
    {
        Users users=new Users(name,surname,email,address);
        String message= dbRestOperation.persist(users);
        URI uri = UriBuilder.fromPath("http://localhost:8080/HrProject_war/site2.jsp").
                queryParam("perr",message).build();

        return  Response.seeOther(uri).build();
    }


    /**
    *
    *
    * @POST http://localhost:8080/HrProject_war/restDB/update
    *  Response update(int id, String name, String surname, String email, String address)
    */
    @POST
    @Path("/update")
    @Produces({"text/plain"})
    public Response update(@FormParam("name") String name,
                         @FormParam("id") int id,
                         @FormParam("surname") String surname,
                         @FormParam("email") String email,
                         @FormParam("address") String address)
    {
        String message= dbRestOperation.merge(id,name,surname,email,address);
        URI uri = UriBuilder.fromPath("http://localhost:8080/HrProject_war/site2.jsp").
                queryParam("merr",message).build();


        return  Response.seeOther(uri).build();
    }

    /**
    *
    *
    * @POST  http://localhost:8080/HrProject_war/restDB/delete
    *
    *  Response delete(int id)
    */
    @POST
    @Path("/delete")
    @Produces("text/plain")
    public Response delete(@FormParam("id") int id)
    {
      String message= dbRestOperation.remove(id);
        URI uri = UriBuilder.fromPath("http://localhost:8080/HrProject_war/site2.jsp").
                queryParam("remr",message).build();
       return  Response.seeOther(uri).build();
    }

    /**
    * @return List<Users>
    *
    *  @GET http://localhost:8080/HrProject_war/restDB/Allxml
    *
    */
    @GET
    @Path("/Allxml")
    @Produces(MediaType.APPLICATION_XML)
  public List<Users> getALLx()
  {
      List<Users> list=dbRestOperation.selectAll();

      return list;
    }

    /**
     * @return List<Users>
     *
     *  @GET http://localhost:8080/HrProject_war/restDB/Alljson
     * */
    @GET
    @Path("/Alljson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> getALLj()
    {
        List<Users> list=dbRestOperation.selectAll();

        return list;
    }


}
