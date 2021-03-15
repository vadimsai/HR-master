package jaxrest;


import interfaseanduser.DBOperations;
import interfaseanduser.Users;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

/**
 *@autor VADIM NOVIKOV
 *
 * To access the services you can use the extension for chrome "Talend API Tester - Free Edition"
 * Service URI: http://ec2-18-188-100-175.us-east-2.compute.amazonaws.com:8080/HrProject-1.0-SNAPSHOT/restDB
 */
@Path("/restDB")
public class RestService  {

    DBOperations dbOperations;
    /**
     *
     * for all methods with a return value String
     *
     * @return String
     *
     * i am building a URI from the location of the jsp page, and adding a
     * query parameter to the end of the URI.
     * So the redirect will go to http://ec2-18-188-100-175.us-east-2.compute.amazonaws.com:8080/HrProject-1.0-SNAPSHOT/site2.jsp?message=<the message>
     *
     *
     * Response persist(String name, String surname, String email, String address)
     *
     * @POST http://ec2-18-188-100-175.us-east-2.compute.amazonaws.com:8080/HrProject-1.0-SNAPSHOT/restDB/persist
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
        String message= dbOperations.insert(users);
        URI uri = UriBuilder.fromPath("site2.jsp").
                queryParam("perr",message).build();

        return  Response.seeOther(uri).build();
    }


    /**
    *
    *
    * @POST http://ec2-18-188-100-175.us-east-2.compute.amazonaws.com:8080/HrProject-1.0-SNAPSHOT/restDB/update
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
        Users users=new Users();
        users.setName(name);
        users.setSurname(surname);
        users.setEmail(email);
        users.setAddress(address);
        String message= dbOperations.update(id,users);
        URI uri = UriBuilder.fromPath("site2.jsp").
                queryParam("merr",message).build();


        return  Response.seeOther(uri).build();
    }

    /**
    *
    *
    * @POST  http://ec2-18-188-100-175.us-east-2.compute.amazonaws.com:8080/HrProject-1.0-SNAPSHOT/restDB/delete
    *
    *  Response delete(int id)
    */
    @POST
    @Path("/delete")
    @Produces("text/plain")
    public Response delete(@FormParam("id") int id)
    {
      String message= dbOperations.remove(id);
        URI uri = UriBuilder.fromPath("site2.jsp").
                queryParam("remr",message).build();
       return  Response.seeOther(uri).build();
    }

    /**
    * @return List<Users>
    *
    *  @GET http://ec2-18-188-100-175.us-east-2.compute.amazonaws.com:8080/HrProject-1.0-SNAPSHOT/restDB/Allxml
    *
    */
    @GET
    @Path("/Allxml")
    @Produces(MediaType.APPLICATION_XML)
  public List<Users> getALLx()
  {
      List<Users> list=dbOperations.selectAll();

      return list;
    }

    /**
     * @return List<Users>
     *
     *  @GET http://ec2-18-188-100-175.us-east-2.compute.amazonaws.com:8080/HrProject-1.0-SNAPSHOT/restDB/Alljson
     * */
    @GET
    @Path("/Alljson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> getALLj()
    {
        List<Users> list=dbOperations.selectAll();

        return list;
    }


}
