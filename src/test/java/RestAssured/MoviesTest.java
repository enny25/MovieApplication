//package RestAssured;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import entity.Movie;
//import facades.MovieFacade;
//import javax.persistence.EntityManagerFactory;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.Ignore;
//import rest.Movies;
//
///**
// *
// * @author Emil
// */
//public class MoviesTest {
//    EntityManagerFactory emf;
//    MovieFacade facade = new MovieFacade(emf);
//    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    public MoviesTest() {
//    }
//  
////    @Ignore
//    @Test
//    public void testGetMovieName() throws Exception {
//        System.out.println("testGetMovieName");
//        Movie movie = new Movie("tt0077631", "Grease");
//        Movies instance = new Movies();
//        String expResult = "Grease";
//        String result = instance.getMovieName(gson.toJson(movie));
//        JsonObject json = new JsonParser().parse(result).getAsJsonObject();
//        String movieTitle = json.get("title").getAsString();
//        assertEquals(expResult, movieTitle);
//        System.out.println("MovieId: " + movieTitle);
//        System.out.println("MovieInfo: " + json);
//
//    }
//    
////    @Ignore
//    @Test
//    public void testGetMovieId() throws Exception {
//        System.out.println("///////////");
//        System.out.println("testGetMovieId");
//        Movie movie = new Movie("tt0077631", "Grease");        
//        Movies instance = new Movies();
//        String expResult = "tt0077631";        
//        String result = instance.getMovieId(gson.toJson(movie));
//        JsonObject json = new JsonParser().parse(result).getAsJsonObject();
//        String movieId = json.get("imdbid").getAsString(); 
//        assertEquals(expResult, movieId);
//        System.out.println("MovieId: " + movieId);
//        System.out.println("MovieInfo: " + json);
//    }
//
//    
//    // Does not work yet.
//    @Ignore
//    @Test
//    public void testUpdateMovie(){        
//        Movies instance = new Movies();
//        Movie movies = facade.getMoviebyTitle("Grease");
//        movies.setTitle("Travolta");
//        String result = instance.updateMovie(gson.toJson(movies));
//        String jsonResult = gson.toJson("update succesfull");
//        assertEquals(result, jsonResult);
//    }   
//}