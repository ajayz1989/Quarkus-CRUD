package org.cloud37;

import org.cloud37.model.Greeting;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "greeting.message")
    private String message;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy " + message;
    }

    @Transactional
    @Path("/greeting/{author}/{message}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting createGreeting(@PathParam("author") String author, @PathParam("message") String message){
        Greeting greeting = new Greeting();
        greeting.author=author;
        greeting.message=message;
        greeting.persist();
        return greeting;
    }

    @Path("/getByAuthor/{author}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Greeting> getByAuthor(@PathParam("author") String author){
        return Greeting.find("author", author).list();
    }
}
