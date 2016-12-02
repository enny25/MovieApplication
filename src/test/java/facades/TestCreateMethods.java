///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package facades;
//
//import entity.Movie;
//import entity.Review;
//import entity.Role;
//import entity.User;
//import java.util.ArrayList;
//import javax.persistence.Persistence;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import security.PasswordStorage;
//
///**
// *
// * @author Lenovo
// */
//public class TestCreateMethods {
//     MovieFacade instance = new MovieFacade(Persistence.createEntityManagerFactory("pu_test"));
//    UserFacade uFacade = new UserFacade(Persistence.createEntityManagerFactory("pu_test"));
//    
//    public TestCreateMethods() {
//    }
//    /**
//     * Test of postReview method, of class MovieFacade.
//     */
//    @Test
//    public void testPostReview() throws PasswordStorage.CannotPerformOperationException {
//        System.out.println("postReview");
//        instance.createMoviebyTitle("Frozen");
//        Movie frozen =instance.getMoviebyTitle("Frozen");
//        User Tonny = new User("tonny","bonde","male","24-06-2890","Kazakstan");
//        Role user = new Role();
//        Tonny.addRole(user);  
//        Review review = new Review(Tonny,frozen,"The Review",5);
//        instance.postReview(review);
//        
//        assertEquals(instance.getReviewsByMovie(frozen),review);
//      
//    }
//    
//    @Test
//    public void testCreateMovieById (){
//        instance.createMoviebyID("tt0265086");
//        assertEquals("Black Hawk Down",instance.getMoviebyID("tt0265086").getTitle());
//    }
//    
//    @Test
//    public void testCreateMovieByTitle (){
//        instance.createMoviebyTitle("Grease");
//        assertEquals("tt0077631",instance.getMoviebyTitle("Grease").getImdbId());
//    }
//    
//    
//
//}
