package RestAssured;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.Movie;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import rest.Movies;

/**
 *
 * @author Emil
 */
public class MoviesTest {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public MoviesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getMovieName method, of class Movies.
     */
    @Ignore
    @Test
    public void testGetMovieName() throws Exception {
        // To make this work then change title in getMovieName in Movies.java to Title, with a capital T.
        Movie movie = new Movie("tt0096895", "batman");
        Movies instance = new Movies();
        String expResult = "batman";
        String result = instance.getMovieName(gson.toJson(movie));
        JsonObject json = new JsonParser().parse(result).getAsJsonObject();
        String movieTitle = json.get("Title").getAsString();
        assertEquals(expResult, movieTitle);

    }
//    @Ignore
    @Test
    public void testGetMovieId() throws Exception {
        Movie movie = new Movie("tt0096895", "batman");        
        Movies instance = new Movies();
        String expResult = "tt0096895";        
        String result = instance.getMovieId(gson.toJson(movie));
        // fails here
        JsonObject json = new JsonParser().parse(result).getAsJsonObject();
        String movieId = json.get("imdbid").getAsString();        
        assertEquals(expResult, movieId);
    }

    /**
     * Test of addMovieById method, of class Movies.
     */
    @Ignore
    @Test
    public void testAddMovieById() throws Exception {
        System.out.println("addMovieById");
        String jsonString = "";
        Movies instance = new Movies();
        instance.addMovieById(jsonString);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMoviebyName method, of class Movies.
     */
    @Ignore
    @Test
    public void testAddMoviebyName() throws Exception {
        System.out.println("addMoviebyName");
        String jsonString = "";
        Movies instance = new Movies();
        instance.addMoviebyName(jsonString);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}