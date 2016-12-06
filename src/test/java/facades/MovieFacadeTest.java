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
//import javax.persistence.Persistence;
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
//    User user = new User("Username","Password","Male","25-04-2890","Glorius Nation of Kazakhstan");
//    
//    public MovieFacadeTest() throws PasswordStorage.CannotPerformOperationException {
//         instance.createMoviebyTitle("Grease");
//        instance.createMoviebyTitle("Black Hawk Down");
//        instance.createMoviebyTitle("Frozen");
//        Movie frozen = instance.getMoviebyTitle("Frozen");
//        Review review = new Review(user,frozen,"the Review",5);
//        instance.postReview(review);
//    }
//    
//  
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
//     * Test of getReviewsByUser method, of class MovieFacade.
//     */
//    @Test
//    public void testGetReviewsByUser() {
//        
//        List<Review> result = instance.getReviewsByUser(user);
//        assertEquals(instance.getMoviebyTitle("Frozen"), result.get(0).getMovie());
//      
//    }
//
//    /**
//     * Test of getReviewsByMovie method, of class MovieFacade.
//     */
//    @Test
//    public void testGetReviewsByMovie() {
//        
//        Movie frozen = instance.getMoviebyTitle("Frozen");
//        List<Review> result = instance.getReviewsByMovie(frozen);
//        assertEquals(user, result.get(0).getUser());
//    }
//
//    /**
//     * Test of upvoteReview method, of class MovieFacade.
//     */
//    @Test
//    public void testUpvoteReview() {
//        Review review = instance.getReviewsByUser(user).get(0);
//        int defaultScore = review.getScore();
//        instance.upvoteReview(review);
//        assertEquals(instance.getReviewsByUser(user).get(0).getScore(),defaultScore +1);
//    }
//
//    /**
//     * Test of downVoteReview method, of class MovieFacade.
//     */
//    @Test
//    public void testDownVoteReview() {
//        Review review = instance.getReviewsByUser(user).get(0);
//        int defaultScore = review.getScore();
//        instance.upvoteReview(review);
//        assertEquals(instance.getReviewsByUser(user).get(0).getScore(),defaultScore -1);
//    }
//
//    /**
//     * Test of updateMovie method, of class MovieFacade.
//     */
//    @Test
//    public void testUpdateMovie() {
//        
//        Movie movie = instance.getMoviebyTitle("Frozen");
//        movie.setTitle("NotFrozen");
//        Movie result = instance.updateMovie(movie);
//        assertEquals("NotFrozen", instance.getMoviebyID("tt2294629").getTitle());
//    }
//    
//}
