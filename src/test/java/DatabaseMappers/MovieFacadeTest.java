/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseMappers;

import entity.Movie;
import facades.MovieFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Plamen
 */
public class MovieFacadeTest {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_test");
    private static MovieFacade facade = new MovieFacade(emf);
    
    public MovieFacadeTest(){
    
}
    @Before
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Movie m1 = new Movie("tt0172495", "Gladiator");
            Movie m2 = new Movie("tt0803096", "Warcraft");
            em.persist(m1);
            em.persist(m2);
            em.getTransaction().commit();
        }
        finally{
            em.close();
        }
    }
    @Test
    public void testGetMoviebyTitle() throws Exception {
        Movie m = facade.getMoviebyTitle("Gladiator");
        assertEquals("Gladiator", m.getTitle());       
    }
    
    @Test
    public void testcreateMoviebyTitle() throws Exception {
                    

        
        facade.createMoviebyTitle("Frozen");
        assertNotNull(facade.getMoviebyTitle("Frozen"));
//        EntityManager em = emf.createEntityManager();
//        try{
//            em.getTransaction().begin();
//            
//            em.persist(m1);
//            em.persist(m2);
//            em.getTransaction().commit();
//            
//        }
//        finally{
//            em.close();
//        }
        
    }
    
}
