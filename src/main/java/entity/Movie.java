/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Lenovo
 */
@Entity
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String imdbId;
    
    private String Title;
    @Column(name="MovieYear")
    private String Year;
    
    private String Runtime;
    
    private String Genre;
    
    private String Directors;
    
    private String Actors;
    
    private String plot;
    @Column(name="MovieLanguage")
    private String Language;
    private String ImdbRating;
    private List Reviews;
    private List Reccommendations;

    public Movie(String imdbId) {
        this.imdbId = imdbId;
    }

    public Movie(String imdbId, String Title, String Year, String Runtime, String Genre, String Directors, String Actors, String plot, String Language, String ImdbRating) {
        this.imdbId = imdbId;
        this.Title = Title;
        this.Year = Year;
        this.Runtime = Runtime;
        this.Genre = Genre;
        this.Directors = Directors;
        this.Actors = Actors;
        this.plot = plot;
        this.Language = Language;
        this.ImdbRating = ImdbRating;
    }

    public Movie() {
    }
    
    
    
    
   
    
    
    
    
    

    
    
}
