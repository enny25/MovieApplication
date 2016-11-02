/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseMappers;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import entity.Movie;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class MovieMapper {
    public static Movie movieGetter (String imdbId){
        try {

        String selectedItem = imdbId ;

        InputStream input = new URL("http://www.omdbapi.com/?i=" + URLEncoder.encode(selectedItem, "UTF-8")).openStream();
        Map<String, String> map = new Gson().fromJson(new InputStreamReader(input, "UTF-8"), new TypeToken<Map<String, String>>(){}.getType());

        String title = map.get("Title");
        String year = map.get("Year");
//        String released = map.get("Released");
        String runtime = map.get("Runtime");
        String genre = map.get("Genre");
        String actors = map.get("Actors");
        String plot = map.get("Plot");
        String imdbRating = map.get("imdbRating");
        String directors = map.get("Director");
        String language = map.get("Language");
            System.out.println(title);
            System.out.println(year);
//            System.out.println(released);
            System.out.println(runtime);
            System.out.println(genre);
            System.out.println(actors);
            System.out.println(plot);
            System.out.println(imdbRating);
            System.out.println(directors);
            System.out.println(language);
        Movie movie = new Movie(imdbId,title, year, runtime, genre,directors, actors, plot,language,imdbRating);
        
        return movie;

        

    } catch (JsonIOException | JsonSyntaxException | IOException e){
        System.out.println(e);
        return null;
    }
        
    }
    
}
