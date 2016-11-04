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
        Movie movie = new Movie("tt0077631", "Grease");
        Movies instance = new Movies();
        String expResult = "Grease";
        String result = instance.getMovieName(gson.toJson(movie));
        JsonObject json = new JsonParser().parse(result).getAsJsonObject();
        String movieTitle = json.get("title").getAsString();
        assertEquals(expResult, movieTitle);

    }
//    @Ignore
    @Test
    public void testGetMovieId() throws Exception {
        Movie movie = new Movie("tt0077631", "Grease");        
        Movies instance = new Movies();
        String expResult = "tt0077631";        
        String result = instance.getMovieId(gson.toJson(movie));
        // fails here
        JsonObject json = new JsonParser().parse(result).getAsJsonObject();
        System.out.println("Json: " + json);
        String movieId = json.get("imdbid").getAsString();        
        assertEquals(expResult, movieId);
    }

}