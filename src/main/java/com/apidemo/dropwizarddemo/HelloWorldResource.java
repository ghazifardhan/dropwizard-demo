package com.apidemo.dropwizarddemo;

import org.eclipse.jetty.server.Response;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by markibid on 10/03/17.
 */


@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @POST
    @Path("/users")
    public ResultModel doCreateUser(@FormParam("name") String name, @FormParam("email") String email){


        /*
        Boolean isSuccess = null;

        try {
            Connection connection = MySqlConnector.getConnect();
            Statement st = connection.createStatement();
            double i = Math.random();
            String query = "INSERT INTO users (user_id, name, email) VALUES ('"+ i * 50 +"', '" + name + "', '" + email + "')";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
        ResultModel rm = new ResultModel();
        rm.setResult("Success add user");
        rm.setSuccess(true);

        return rm;

    }

    @GET
    @Path("/test")
    public HelloWorldModel test1(@QueryParam("first") String firstName, @QueryParam("last") String lastName){
        HelloWorldModel test = new HelloWorldModel();
        test.setFirstName(firstName);
        test.setLastName(lastName);
        return test;
    }

    @GET
    @Path("/test/{id}")
    public HelloWorldModel test2(@PathParam("id") Integer id){
        HelloWorldModel test = new HelloWorldModel();
        if(id == 1) {
            test.setFirstName("Annazmy");
            test.setLastName("Pratiwie");
        } else {
            test.setFirstName("Ghazi");
            test.setLastName("Fadil");
        }
        return test;
    }

    @GET
    @Path("/test/db")
    public void testAuction(){
        try {
            Auction a  = new Auction();
            Connection test = MySqlConnector.getConnect();
            Statement st = test.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM auction");
            while(rs.next()){
                a.setAuctionId(rs.getInt("id"));
                a.setAuctionTitle(rs.getString("title"));
                System.out.println(a.getAuctionId());
                System.out.println(a.getAuctionTitle());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @GET
    @Path("/test/sql")
    public ResultModel testSql(){

        Boolean status = null;

        try {
            Connection test = MySqlConnector.getConnect();
            if(test==null){
                System.out.println("Failed to connnect to database!");
                status = false;
            } else {
                System.out.println("Success connect to database!");
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultModel result = new ResultModel();

        if(status){
            result.setSuccess(true);
            result.setResult("Success connect to database!");
        } else {
            result.setSuccess(false);
            result.setResult("Failed to connnect to database!");
        }

        return result;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/test")
    public ResultModel testPost(@FormParam("firstName") String first, @FormParam("lastName") String last){

        HelloWorldModel model = new HelloWorldModel();
        model.setFirstName(first);
        model.setLastName(last);

        System.out.println(model.getFirstName());
        System.out.println(model.getLastName());

        ResultModel test = new ResultModel();
        test.setSuccess(true);
        test.setResult("Success POST Data to REST API!");

        return test;
    }
}
