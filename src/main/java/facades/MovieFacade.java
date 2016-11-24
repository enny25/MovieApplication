/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DatabaseMappers.MovieMapper;
import com.google.gson.JsonObject;
import entity.Movie;
import java.util.ArrayList;
import java.util.List;
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
    List<Movie> addedMovies = new ArrayList();

    public MovieFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // return a movie by an ID
    public Movie getMoviebyID(String imdbid) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT m FROM Movie m WHERE m.imdbid = :imdbid");
        query.setParameter("imdbid", imdbid);
        Movie result = (Movie) query.getSingleResult();
        try {
            return result;
        } finally {
            em.close();
        }
    }

    // return a movie by a title
    public Movie getMoviebyTitle(String title) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT m FROM Movie m where m.title = :title");
        query.setParameter("title", title);
        Movie result = (Movie) query.getSingleResult();
        try {
            return result;
        } finally {
            em.close();
        }
    }

    // create a new movie entry in the database by ID
    public void createMoviebyID(String imdbid) {
        EntityManager em = getEntityManager();
        Movie newmovie = moviemapper.movieGetterById(imdbid);
        try {
            em.getTransaction().begin();
            em.persist(newmovie);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    // create a new movie entry in the database by title
    public void createMoviebyTitle(String title) {
        EntityManager em = getEntityManager();
        Movie newmovie = moviemapper.movieGetterByTitle(title);
        try {
            em.getTransaction().begin();
            em.persist(newmovie);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    public List<Movie> getAllMovies() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT m FROM Movie m");

        List<Movie> addressList = query.getResultList();
        try {
            return addressList;
        } finally {
            em.close();
        }

    }

    public Movie updateMovie(Movie movie) {

        EntityManager em = getEntityManager();

        Movie updatedMovie = (Movie) em.find(Movie.class, movie.getImdbId());

        try {
            em.getTransaction().begin();

            updatedMovie.setImdbId(movie.getImdbId());
            updatedMovie.setTitle(movie.getTitle());
            updatedMovie.setYear(movie.getYear());
            updatedMovie.setRuntime(movie.getRuntime());
            updatedMovie.setGenre(movie.getGenre());
            updatedMovie.setDirectors(movie.getDirectors());
            updatedMovie.setActors(movie.getActors());
            updatedMovie.setPlot(movie.getPlot());
            updatedMovie.setLanguage(movie.getPlot());
            updatedMovie.setImdbRating(movie.getImdbRating());
            updatedMovie.setPoster(movie.getPoster());
            em.getTransaction().commit();

        } finally {
            em.close();
        }

        return updatedMovie;
    }

}
