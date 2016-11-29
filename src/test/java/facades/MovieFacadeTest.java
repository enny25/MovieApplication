///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package facades;
//
//import entity.Movie;
//import entity.Review;
//import entity.User;
//import java.util.List;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import security.PasswordStorage;
//
///**
// *
// * @author Lenovo
// */
//public class MovieFacadeTest {
//    MovieFacade instance = new MovieFacade(Persistence.createEntityManagerFactory("pu_test"));
//    UserFacade uFacade = new UserFacade(Persistence.createEntityManagerFactory("pu_test"));
//    
//    public MovieFacadeTest() {
//    }
//    
//    @Before
//    public void setUp() throws PasswordStorage.CannotPerformOperationException {
//         instance.createMoviebyTitle("Grease");
//        instance.createMoviebyTitle("Black Hawk Down");
//        instance.getMoviebyTitle("Frozen");
//        User user = new User("Username","Password","Male","25-04-2890","Glorius Nation of Kazakhstan");
//        
//        
//        
//    }
//    
//
//    /**
//     * Test of getMoviebyID method, of class MovieFacade.
//     */
//    @Test
//    public void testGetMoviebyID() {
//        System.out.println("getMoviebyID");
//        String imdbid = "tt0077631";
//        String expResult = "Grease";
//        Movie result = instance.getMoviebyID(imdbid);
//        assertEquals(expResult, result.getTitle());
//        
//    }
//
//    /**
//     * Test of getMoviebyTitle method, of class MovieFacade.
//     */
//    @Test
//    public void testGetMoviebyTitle() {
//        System.out.println("getMoviebyTitle");
//        String title = "Grease";
//        String expResult = "tt0077631";
//        Movie result = instance.getMoviebyTitle(title);
//        assertEquals(expResult, result.getImdbId());
//        
//    }
//
// 
//
//    /**
//     * Test of getAllMovies method, of class MovieFacade.
//     */
//    @Test
//    public void testGetAllMovies() {
//        System.out.println("getAllMovies");
//        List<Movie> result = instance.getAllMovies();
//        assertNotNull(result);
//        
//    }
//
//    /**
//     * Test of postReview method, of class MovieFacade.
//     */
//    @Test
//    public void testPostReview() {
//        System.out.println("postReview");
//        Review review = null;
//        MovieFacade instance = null;
//        instance.postReview(review);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getReviewsByUser method, of class MovieFacade.
//     */
//    @Test
//    public void testGetReviewsByUser() {
//        System.out.println("getReviewsByUser");
//        User user = null;
//        MovieFacade instance = null;
//        List<Review> expResult = null;
//        List<Review> result = instance.getReviewsByUser(user);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getReviewsByMovie method, of class MovieFacade.
//     */
//    @Test
//    public void testGetReviewsByMovie() {
//        System.out.println("getReviewsByMovie");
//        Movie movie = null;
//        MovieFacade instance = null;
//        List<Review> expResult = null;
//        List<Review> result = instance.getReviewsByMovie(movie);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of upvoteReview method, of class MovieFacade.
//     */
//    @Test
//    public void testUpvoteReview() {
//        System.out.println("upvoteReview");
//        Review review = null;
//        MovieFacade instance = null;
//        instance.upvoteReview(review);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of downVoteReview method, of class MovieFacade.
//     */
//    @Test
//    public void testDownVoteReview() {
//        System.out.println("downVoteReview");
//        Review review = null;
//        MovieFacade instance = null;
//        instance.downVoteReview(review);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateMovie method, of class MovieFacade.
//     */
//    @Test
//    public void testUpdateMovie() {
//        System.out.println("updateMovie");
//        Movie movie = null;
//        MovieFacade instance = null;
//        Movie expResult = null;
//        Movie result = instance.updateMovie(movie);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//}
