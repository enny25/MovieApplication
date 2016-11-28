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
    @Path("userPage/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@PathParam("id")String id) {        
         User user = uFacade.getUserByUserId(id);
        return gson.toJson(user);
    }

    @GET
    @Path("userBuddies/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String userBuddy(@PathParam("id")String id) {

        List buddies = uFacade.getFriendListById(id);
        return gson.toJson(buddies);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addMovie(String jsonString){
       JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();
         String imdbid = json.get("imdbid").getAsString();
        String title = json.get("title").getAsString();
        String year = json.get("Year").getAsString();
        String runtime = json.get("Runtime").getAsString();
        String genre = json.get("Genre").getAsString();
        String directors = json.get("Directors").getAsString();
        String actors = json.get("Actors").getAsString();
        String plot = json.get("plot").getAsString();
        String language = json.get("Language").getAsString();
        String imdbrating = json.get("ImdbRating").getAsString();
        String poster = json.get("Poster").getAsString();
        Movie movie = new Movie(imdbid,title,year,runtime,genre,directors,actors,plot,language,imdbrating,poster);
        String rating = json.get("Rating").getAsString();
        String status = json.get("Status").getAsString();
        String username = json.get("Username").getAsString();
        PersonalMovie pm = new PersonalMovie(movie,Integer.parseInt(status),rating);
        boolean result = uFacade.addToPersonalMovieList(username, pm);
        String jsonResult = gson.toJson(result);
        return jsonResult;
    }
}
