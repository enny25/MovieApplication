///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package DatabaseMappers;
//
//import entity.Movie;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Lenovo
// */
//public class MovieMapperTest {
//    
//    public MovieMapperTest() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//
//    /**
//     * Test of movieGetterById method, of class MovieMapper.
//     */
//    @Test
//    public void testMovieGetterById() {
//        System.out.println("movieGetterById");
//        String imdbId = "tt2294629";
//        String expResult = "Frozen";
//        Movie result = MovieMapper.movieGetterById(imdbId);
//        
//        assertEquals(expResult, result.getTitle());
//    }
//     @Test
//    public void testMovieGetterByIdFalseValue() {
//        System.out.println("movieGetterByIdFalseValue");
//        String imdbId = "bgagasbjab";
//        
//        Movie result = MovieMapper.movieGetterById(imdbId);
//        
//        assertNull(result);
//    }
//
//    /**
//     * Test of movieGetterByTitle method, of class MovieMapper.
//     */
//    @Test
//    public void testMovieGetterByTitle() {
//        System.out.println("movieGetterByTitle");
//        String MovieTitle = "Frozen";
//        String expResult = "tt2294629";
//        Movie result = MovieMapper.movieGetterByTitle(MovieTitle);
//        assertEquals(expResult, result.getImdbId());
//       
//    }
//    
//    @Test
//    public void testMovieGetterByTitleFalseValue() {
//        System.out.println("movieGetterByTitleFalseValue");
//        String MovieTitle = "anjsajkbgjsanb jgkbsa";
//        Movie result = MovieMapper.movieGetterByTitle(MovieTitle);
//        assertNull(result);
//       
//    }
//    
//}
