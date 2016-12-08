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
    private static User userOne;
    private static User userTwo;
    
    
    public MovieFacadeTest() throws PasswordStorage.CannotPerformOperationException {
        
    }
    @BeforeClass
    public static void setup () throws PasswordStorage.CannotPerformOperationException{
        
       Persistence.generateSchema("pu_test", null);
        
        Movie frozen = new Movie("tt2294629","Frozen","2013","102 min","Animation, Adventure, Comedy","Chris Buck, Jennifer Lee,",
        "Kristen Bell, Idina Menzel, Jonathan Groff, Josh Gad",
        "When the newly crowned Queen Elsa accidentally uses her power to turn things into ice to curse her home in infinite winter, her sister, Anna, teams up with a mountain man, his playful reindeer, and a snowman to change the weather condition."
         ,"English, Icelandic","7.6","https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ1MjQwMTE5OF5BMl5BanBnXkFtZTgwNjk3MTcyMDE@._V1_SX300.jpg");
        Movie BHD = new Movie("tt0265086","Black Hawk Down","2001","102 min","Adventure, Comedy","The Director, Jennifer Lee,",
        "The Actors","The Plot.","English, Somali","7.6","https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ1MjQwMTE5OF5BMl5BanBnXkFtZTgwNjk3MTcyMDE@._V1_SX300.jpg");
        Movie Grease = new Movie("tt0077631","Grease","2001","102 min","Adventure, Comedy","The Director, Jennifer Lee,",
        "The Actors","The Plot.","English, Somali","7.6","https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ1MjQwMTE5OF5BMl5BanBnXkFtZTgwNjk3MTcyMDE@._V1_SX300.jpg");
//        frozen.setReviews(null);
//        BHD.setReviews(null);
//        Grease.setReviews(null);
        instance.persistMovie(frozen);
        instance.persistMovie(BHD);
        instance.persistMovie(Grease);
        
      userOne = new User("Username","Password","Male","25-04-2890","Glorius Nation of Kazakhstan");
       uFacade.createUser(userOne);
      userTwo = new User ("Johhny","Password","Male","24-04-120","China");
        Role user = new Role("user");
       userOne.addRole(user);
       userOne.addFriendList(userTwo);
      uFacade.updateUser(userOne);
       
        instance.postReview(frozen.getImdbId(),userOne.getUserName(),"the Review",5);
    }

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
       
        
        
        List<Review> result = instance.getReviewsByUser(userOne.getUserName());
        assertEquals("the Review", result.get(0).getReviewText());
      
    }

   

    /**
     * Test of upvoteReview method, of class MovieFacade.
     */
    @Test
    public void testUpvoteReview() {
        Review review = instance.getReviewsByUser(userOne.getUserName()).get(0);
        int defaultScore = review.getScore();
        instance.upvoteReview(review);
        assertEquals(instance.getReviewsByUser(userOne.getUserName()).get(0).getScore(),defaultScore +1);
    }

    /**
     * Test of downVoteReview method, of class MovieFacade.
     */
    
    @Test
    public void testDownVoteReview() {
        Review review = instance.getReviewsByUser(userOne.getUserName()).get(0);
        int defaultScore = review.getScore();
        instance.downVoteReview(review);
        assertEquals(instance.getReviewsByUser(userOne.getUserName()).get(0).getScore(),defaultScore -1);
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
