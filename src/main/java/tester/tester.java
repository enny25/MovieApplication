/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import DatabaseMappers.MovieMapper;
import entity.Movie;
import facades.MovieFacade;
import facades.UserFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lenovow
 */
public class tester {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_development");
       MovieFacade mf = new MovieFacade(emf);
       UserFacade uf = new UserFacade(emf);
//       mf.createMoviebyTitle("Grease");
       uf.addToPersonalMovieList("user", "tt0072505", "Completed", 1);
       uf.addToPersonalMovieList("user", "tt0076759", "Completed", 2);
       uf.addToPersonalMovieList("user", "tt0077631", "Completed", 3);
       uf.addToPersonalMovieList("user", "tt0078346", "Completed", 4);
       

        }
        
        
        
        
    
    
}
