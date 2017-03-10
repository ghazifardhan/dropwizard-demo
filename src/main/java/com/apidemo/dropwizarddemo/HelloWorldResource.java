package com.apidemo.dropwizarddemo;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
