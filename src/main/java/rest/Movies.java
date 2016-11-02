/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Movie;
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
    
    public Movies(){
        
    }
    
    
    
    @GET
    @Path("movie")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMovieName() throws Exception{
        return null;
    }
    
    @GET
    @Path("movie/{imdbid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMovieId(@PathParam("imdbid") int imdbid) throws Exception{
        return null;
    }
    
    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addMovie(String movieJsonStr) throws Exception{
        Movie m = gson.fromJson(movieJsonStr, Movie.class);
        return null;
    }
}
