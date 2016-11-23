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
import facades.MovieFacade;
import facades.UserFacade;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("movies")
public class Movies {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    MovieFacade facade = new MovieFacade(Persistence.createEntityManagerFactory("pu_development"));
    UserFacade uFacade = new UserFacade(Persistence.createEntityManagerFactory("pu_development"));

    public Movies() {
    }

    @POST
    @Path("movie")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getMovieName(String jsonString) throws Exception {
        JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();
        String movieTitle = json.get("title").getAsString();
        Movie movie = facade.getMoviebyTitle(movieTitle);

        return gson.toJson(movie);
    }

    @POST
    @Path("movieById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getMovieId(String jsonString) throws Exception {
        JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();
        String imdbid = json.get("imdbid").getAsString();
        Movie movie = facade.getMoviebyID(imdbid);

        return gson.toJson(movie);
    }

    @POST
    @RolesAllowed("Admin")
    @Path("createById")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMovieById(String jsonString) throws Exception {
        JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();
        String imdbID = json.get("imdbid").getAsString();
        facade.createMoviebyID(imdbID);

    }

    @POST
    @RolesAllowed("Admin")
    @Path("createByName")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMoviebyName(String jsonString) throws Exception {
        JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();
        String title = json.get("title").getAsString();
        
        facade.createMoviebyTitle(title);
    }
    @GET
    @Path("getMovieList")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCompanies() {
        List movies = facade.getAllMovies();
        return gson.toJson(movies);
    }
        
    @PUT
    @Path("updateMovie")
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)    
    public Movie updateMovie(String jsonString){   
        JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();
        return facade.updateMovie(json);
      
    }
    
    @GET
    @Path("userpage/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String userPage(@PathParam("id")String id){
       
        List buddies = uFacade.getFriendListById(id);
        return gson.toJson(buddies);
    }
}
