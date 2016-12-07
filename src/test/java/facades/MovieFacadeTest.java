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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import security.PasswordStorage;

public class MovieFacadeTest {
    private static  EntityManagerFactory emf =Persistence.createEntityManagerFactory("pu_test");
    private EntityManager em = emf.createEntityManager();
    
    private static MovieFacade instance = new MovieFacade(emf);
   private static UserFacade uFacade = new UserFacade(emf);
    private static User userone;
    
    
    public MovieFacadeTest() throws PasswordStorage.CannotPerformOperationException {
        
    }
    @BeforeClass
    public static void setup () throws PasswordStorage.CannotPerformOperationException{
       
        
        Movie frozen = new Movie("tt2294629","Frozen","2013","102 min","Animation, Adventure, Comedy","Chris Buck, Jennifer Lee,",
        "Kristen Bell, Idina Menzel, Jonathan Groff, Josh Gad",
        "When the newly crowned Queen Elsa accidentally uses her power to turn things into ice to curse her home in infinite winter, her sister, Anna, teams up with a mountain man, his playful reindeer, and a snowman to change the weather condition."
         ,"English, Icelandic","7.6","https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ1MjQwMTE5OF5BMl5BanBnXkFtZTgwNjk3MTcyMDE@._V1_SX300.jpg");
//        Movie BHD = new Movie("tt0265086","Black Hawk Down","2001","102 min","Adventure, Comedy","The Director, Jennifer Lee,",
//        "The Actors","The Plot.","English, Somali","7.6","https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ1MjQwMTE5OF5BMl5BanBnXkFtZTgwNjk3MTcyMDE@._V1_SX300.jpg");
        Movie Grease = new Movie("tt0077631","Grease","2001","102 min","Adventure, Comedy","The Director, Jennifer Lee,",
        "The Actors","The Plot.","English, Somali","7.6","https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ1MjQwMTE5OF5BMl5BanBnXkFtZTgwNjk3MTcyMDE@._V1_SX300.jpg");
//        frozen.setReviews(null);
//        BHD.setReviews(null);
//        Grease.setReviews(null);
        instance.persistMovie(frozen);
//        instance.persistMovie(BHD);
        instance.persistMovie(Grease);
//        
      userone = new User("Username","Password","Male","25-04-2890","Glorius Nation of Kazakhstan");
        Role user = new Role("user");
       userone.addRole(user);
       user.addUser(userone);
       uFacade.createUser(userone);
        Review review = new Review(userone,frozen,"the Review",5);
        instance.postReview(review);
    }
//    @After
//    public void TearDown(){
//               Query q1 = em.createQuery("DELETE FROM Movie");
//    Query q3 = em.createQuery("DELETE FROM Review");
//    Query q2 = em.createQuery("DELETE FROM SEED_USER");
//    Query q4 = em.createQuery("DELETE FROM USER_ROLE");
//    
//        try{
//        em.getTransaction().begin();
//       q3.executeUpdate();
//       q4.executeUpdate();
//       q1.executeUpdate();
//       q2.executeUpdate();
//
//        em.getTransaction().commit();
//        }
//        finally{
//            em.close();
//        }
//        
//    }
        
    
    
    
  
    

    /**
     * Test of getMoviebyID method, of class MovieFacade.
     */
    
    @Test
    public void testGetMoviebyID() {
        System.out.println("getMoviebyID");
        String imdbid = "tt0077631";
        String expResult = "Grease";
        Movie result = instance.getMoviebyID(imdbid);
        assertEquals(expResult, result.getTitle());
        
    }

    /**
     * Test of getMoviebyTitle method, of class MovieFacade.
     */
    
    @Test
    public void testGetMoviebyTitle() {
        System.out.println("getMoviebyTitle");
        String title = "Frozen";
        String expResult = "tt2294629";
        Movie result = instance.getMoviebyTitle(title);
        assertEquals(expResult, result.getImdbId());
        
    }
//
// 
//
    /**
     * Test of getAllMovies method, of class MovieFacade.
     */
    
    @Test
    public void testGetAllMovies() {
        System.out.println("getAllMovies");
        List<Movie> result = instance.getAllMovies();
       
        System.out.println(result.get(0).getTitle());
        assertNotNull(result);
        
    }  

    /**
     * Test of getReviewsByUser method, of class MovieFacade.
     */
    
    @Test
    public void testGetReviewsByUser() throws PasswordStorage.CannotPerformOperationException {
       
        
        
        List<Review> result = instance.getReviewsByUser(userone);
        assertEquals(instance.getMoviebyTitle("Frozen").getImdbId(), result.get(0).getMovie().getImdbId());
      
    }

    /**
     * Test of getReviewsByMovie method, of class MovieFacade.
     */
   
    @Test
    public void testGetReviewsByMovie() throws PasswordStorage.CannotPerformOperationException {
        Movie frozen = instance.getMoviebyTitle("Frozen");
        List<Review> result = instance.getReviewsByMovie(frozen);
        assertEquals(userone.getUserName(), result.get(0).getUser().getUserName());
    }

    /**
     * Test of upvoteReview method, of class MovieFacade.
     */
    @Test
    public void testUpvoteReview() {
        Review review = instance.getReviewsByUser(userone).get(0);
        int defaultScore = review.getScore();
        instance.upvoteReview(review);
        assertEquals(instance.getReviewsByUser(userone).get(0).getScore(),defaultScore +1);
    }

    /**
     * Test of downVoteReview method, of class MovieFacade.
     */
    
    @Test
    public void testDownVoteReview() {
        Review review = instance.getReviewsByUser(userone).get(0);
        int defaultScore = review.getScore();
        instance.downVoteReview(review);
        assertEquals(instance.getReviewsByUser(userone).get(0).getScore(),defaultScore -1);
    }

    /**
     * Test of updateMovie method, of class MovieFacade.
     */
    
    @Test
    public void testUpdateMovie() {
        
        Movie movie = instance.getMoviebyTitle("Frozen");
        System.out.println(movie.getLanguage());
        movie.setLanguage("NotFrozen");
        Movie result = instance.updateMovie(movie);
        assertEquals("NotFrozen", instance.getMoviebyID("tt2294629").getLanguage());
    }
    
}