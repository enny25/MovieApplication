/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Plamen
 */
@Entity
public class PersonalMovie implements Serializable {
    
    
    private static final long serialVersionUID = 1L;
    @Id
    Movie movie;
    int rating;
    String status;

    public PersonalMovie(Movie movie, int rating, String status) {
        this.movie = movie;
        this.rating = rating;
        this.status = status;
    }
    public PersonalMovie() {
        
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
        

    
}
