/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import facades.MovieFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lenovow
 */
public class tester {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_local");
        Persistence.generateSchema("pu_local", null);
       MovieFacade mf = new MovieFacade(emf);
       mf.createMoviebyTitle("Grease");

        }
        
        
        
        
    
    
}
