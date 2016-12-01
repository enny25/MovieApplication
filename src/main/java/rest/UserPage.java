/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.Movie;
import entity.PersonalMovie;
import facades.UserFacade;
import entity.PersonalMovie;
import entity.User;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import static rest.Movies.gson;

/**
 *
 * @author Emil
 */
@Path("profile")
public class UserPage {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    UserFacade uFacade = new UserFacade(Persistence.createEntityManagerFactory("pu_development"));

    @GET
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public String userMovie(@PathParam("username") String username) {
        List personalMovies = uFacade.getPersonalMovieListById(username);
        return gson.toJson(personalMovies);
    }
    
    @GET
    @Path("userPage/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@PathParam("id")String id) {        
         User user = uFacade.getUserByUserId(id);
        return gson.toJson(user);
    }

    @GET
    @Path("userBuddies/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String userBuddy(@PathParam("id") String id) {

        List buddies = uFacade.getFriendListById(id);
        return gson.toJson(buddies);
    }
    
    @POST
    @Path("personalMovieAdd")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addMovie(String jsonString){
        JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();
        String imdbid = json.get("movie").getAsString();
        String username = json.get("username").getAsString();
        String status = json.get("status").getAsString();
        int rating = json.get("rating").getAsInt();
        uFacade.addToPersonalMovieList(username, status, imdbid, rating);
    }
}
