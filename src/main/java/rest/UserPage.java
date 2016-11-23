/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.MovieFacade;
import facades.UserFacade;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Emil
 */
@Path("profile")
public class UserPage {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    UserFacade uFacade = new UserFacade(Persistence.createEntityManagerFactory("pu_development"));

    @GET
    @Path("userMovies/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String userMovie(@PathParam("id")String id) {

        List personalMovies = uFacade.getPersonalMovieListById(id);
        return gson.toJson(personalMovies);
    }

    @GET
    @Path("userBuddies/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String userBuddy(@PathParam("id")String id) {

        List buddies = uFacade.getFriendListById(id);
        return gson.toJson(buddies);
    }
    
}
