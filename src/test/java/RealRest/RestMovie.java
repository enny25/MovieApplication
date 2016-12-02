
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RealRest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.MovieFacade;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Emil
 */
public class RestMovie {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public RestMovie() {
    }

    @BeforeClass
    public static void setUpBeforeAll() {
        RestAssured.baseURI = "http://localhost/seedMaven/";
        RestAssured.port = 8080;
        RestAssured.defaultParser = Parser.JSON;

        Persistence.generateSchema("pu_test", null);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_test");

//        MovieFacade mf = new MovieFacade(emf);
//        mf.createMoviebyTitle("Frozen");
    }

    @Before
    public void setUp() {

    }

    // This will check if the server is running.
    @Test
    public void serverIsRunning() {
        given().
                when().get().
                then().
                statusCode(200);

    }

    // This will test if the MovieList actually exists on the website, 
    // by making sure it will return with a 200 statuscode.
    @Test
    public void testGetMovieList() {
        given().when().get("api/movies/getMovieList").then().statusCode(200);
    }

    // This will test for movies in the movieList on the website, 
    // to check if there's a movie with the existing name.
    @Test
    public void testGetMovieName() {
        given().when().get("api/movies/getMovieList").then().body(containsString("Frozen"));
        given().when().get("api/movies/getMovieList").then().body(containsString("The Flash"));
    }

    @Test
    public void testGetMovieId() {
        given().when().get("api/movies/getMovieList").then().body(containsString("tt2294629"));
    }

    @Test
    public void testGetProfile() {
        given().when().get("api/profile/user").then().statusCode(200);

    }

//    @Test
//    public void createMovie() {
//        given().when().get("api/movies/createByName").then().statusCode(200);
//        
//        
//        
//        
//        Response r = given()
//                .contentType("application/json").
//                body("").
//                when().
//                post("api/movies/createByName");
//
//        String body = r.getBody().asString();
//        System.out.println(body);
//    }

}
