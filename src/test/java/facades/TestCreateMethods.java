/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Movie;
import entity.Review;
import entity.Role;
import entity.User;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import security.PasswordStorage;

/**
 *
 * @author Lenovo
 */
public class TestCreateMethods {
    private static  EntityManagerFactory emf =Persistence.createEntityManagerFactory("pu_test");
    private EntityManager em = emf.createEntityManager();
    
    private static MovieFacade instance = new MovieFacade(emf);
   private static UserFacade uFacade = new UserFacade(emf);
    private static User userOne;
    private static User userTwo;
    
    public TestCreateMethods() {
    }
    @BeforeClass
    public static void setup(){
        Persistence.generateSchema("pu_test", null);
        
    }
    /**
     * Test of postReview method, of class MovieFacade.
     */
    @Test
    public void testPostReview() throws PasswordStorage.CannotPerformOperationException {
        System.out.println("postReview");
        Movie frozen = new Movie("tt2294629","Frozen","2013","102 min","Animation, Adventure, Comedy","Chris Buck, Jennifer Lee,",
        "Kristen Bell, Idina Menzel, Jonathan Groff, Josh Gad",
        "When the newly crowned Queen Elsa accidentally uses her power to turn things into ice to curse her home in infinite winter, her sister, Anna, teams up with a mountain man, his playful reindeer, and a snowman to change the weather condition."
         ,"English, Icelandic","7.6","https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ1MjQwMTE5OF5BMl5BanBnXkFtZTgwNjk3MTcyMDE@._V1_SX300.jpg");
        
        userOne = new User("tonny","bonde","male","24-06-2890","Kazakstan");
        uFacade.createUser(userOne);
        Role user = new Role();
        userOne.addRole(user);  
        
        Review review = new Review(userOne.getUserName(),"the Review",5);
        instance.postReview(review,frozen.getImdbId());
        
        assertEquals(instance.getReviewsByUser(userOne.getUserName()).get(0),review);
      
    }
    
    @Test
    public void testCreateMovieById (){
        instance.createMoviebyID("tt0265086");
        assertEquals("Black Hawk Down",instance.getMoviebyID("tt0265086").getTitle());
    }
    
    @Test
    public void testCreateMovieByTitle (){
        instance.createMoviebyTitle("Grease");
        assertEquals("tt0077631",instance.getMoviebyTitle("Grease").getImdbId());
    }
    
    

}
