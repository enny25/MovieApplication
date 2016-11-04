/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DatabaseMappers.MovieMapper;
import entity.Movie;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Plamen
 */
public class MovieFacade {
    
    EntityManagerFactory emf;
    MovieMapper moviemapper = new MovieMapper();
    Movie mov1 = new Movie();
    
    public MovieFacade(EntityManagerFactory emf){
        this.emf = emf;
    }
    
    
    private EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    // return a movie by an ID
    public Movie getMoviebyID(String imdbid){
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT m FROM Movie m WHERE m.imdbid = :imdbid");
        query.setParameter("imdbid", imdbid);
        Movie result = (Movie)query.getSingleResult();
        try{
            return result;
        }finally{
                em.close();
                }
    }
    
    // return a movie by a title
    public Movie getMoviebyTitle(String title){
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT m FROM Movie m where m.Title = :title");
        query.setParameter("title", title);
        Movie result = (Movie)query.getSingleResult();
        try{
             return result;
        }finally{
                em.close();
                }
    }
    
    // create a new movie entry in the database by ID
    public void createMoviebyID(String imdbid){
        EntityManager em = getEntityManager();
        Movie newmovie = moviemapper.movieGetterById(imdbid);
        try{
            em.getTransaction().begin();
            em.persist(newmovie);
            em.getTransaction().commit();
            
        }finally{
            em.close();
        }
    }
    
    // create a new movie entry in the database by title
    public void createMoviebyTitle(String title){
        EntityManager em = getEntityManager();
        Movie newmovie = moviemapper.movieGetterByTitle(title);
        try{
            em.getTransaction().begin();
            em.persist(newmovie);
            em.getTransaction().commit();
            
        }finally{
            em.close();
        }
    }
    
    
    public void updateMovie(String imdbid, String title, String year, String runtime, String genre, String directors, String actors, String plot, String language, String imdbrating){
        EntityManager em = getEntityManager();
        Movie movie = em.find(Movie.class, imdbid);
         try{
            em.getTransaction().begin();
            movie.setTitle(title);
            movie.setYear(year);
            movie.setRuntime(runtime);
            movie.setGenre(genre);
            movie.setDirectors(directors);
            movie.setActors(actors);
            movie.setPlot(plot);
            movie.setLanguage(language);
            movie.setImdbRating(imdbrating);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
        
    
    
    
    
    
}
