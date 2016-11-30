/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RealRest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.parsing.Parser;
import org.junit.Before;
import org.junit.BeforeClass;
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
    public static void setUpBeforeAll(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/seedMaven/";
        RestAssured.defaultParser = Parser.JSON;
    }
    
    @Before
    public void setUp(){
        
    }
    
    @Test
    public void serverIsRunning(){
        given().
                when().get().
                then().
                statusCode(200);
    }
    
    @Test
    public void testAddMovie(){
        given().when().get("api/movies/movie/Frozen").then().statusCode(200);
    }
    
    
}
