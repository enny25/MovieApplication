/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Plamen
 */
@Entity
public class Recommendation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    
    public String username;
    private String description;
    private String suggestedMovie;

    public Recommendation(String suggestedMovie, String username, String description) {
        this.suggestedMovie = suggestedMovie;
        this.username = username;
        this.description = description;
    }
    
    public Recommendation() {
        
    }

    public String getSuggestedMovie() {
        return suggestedMovie;
    }

    public void setSuggestedMovie(String suggestedMovie) {
        this.suggestedMovie = suggestedMovie;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   

 

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    public int getId() {
        return id;
    }
    
}
