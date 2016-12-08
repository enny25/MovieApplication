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
    private Long id;
    
    @OneToOne
    public Movie movie1;
    
    @OneToOne
    public Movie movie2;
    
    @OneToOne
    public User user;
    private String description;

    public Recommendation(Movie movie1, Movie movie2, User user, String description) {
        this.movie1 = movie1;
        this.movie2 = movie2;
        this.user = user;
        this.description = description;
    }
    
    public Recommendation() {
        
    }

    public Movie getMovie1() {
        return movie1;
    }

    public void setMovie1(Movie movie1) {
        this.movie1 = movie1;
    }

    public Movie getMovie2() {
        return movie2;
    }

    public void setMovie2(Movie movie2) {
        this.movie2 = movie2;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recommendation)) {
            return false;
        }
        Recommendation other = (Recommendation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Recommendation[ id=" + id + " ]";
    }
    
}

