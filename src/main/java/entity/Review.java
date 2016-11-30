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

/**
 *
 * @author Lenovo
 */
@Entity
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private User user;
    private Movie movie;
    private String reviewText;
    private int Score;

    public Long getId() {
        return id;
    }

    public Review() {
    }

    public Review(User user, Movie movie, String reviewText, int Score) {
        this.user = user;
        this.movie = movie;
        this.reviewText = reviewText;
        this.Score = Score;
    }
    

    public Review(Long id, User user, Movie movie, String reviewText, int Score) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.reviewText = reviewText;
        this.Score = Score;
    }
    

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

  
    
}
