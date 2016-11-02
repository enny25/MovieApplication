/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Movie;
import facades.MovieFacade;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("movies")
public class Movies {
    
    
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    MovieFacade facade = new MovieFacade(Persistence.createEntityManagerFactory("pu_development"));
    
    public Movies(){
        
    }
    
    
    
    @GET
    @Path("movie")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMovieName(String title) throws Exception{
        Movie p = facade.getMoviebyTitle(title);
        return gson.toJson(p);
    }
    
    @GET
    @Path("movie/{imdbid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMovieId(@PathParam("imdbid") String imdbid) throws Exception{
        Movie p = facade.getMoviebyID(imdbid);
        return gson.toJson(p);
    }
    
    @POST
    @Path("createById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addMovieById(String movieJsonStr) throws Exception{
        String imdbID  = gson.fromJson(movieJsonStr, String.class);
        facade.createMoviebyID(imdbID);
        
    }
    
    @POST
    @Path("createByName")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addMoviebyName(String movieJsonStr) throws Exception{
        String title  = gson.fromJson(movieJsonStr, String.class);
        facade.createMoviebyTitle(title);
        
    }
}
