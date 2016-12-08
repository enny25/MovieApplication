/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import DatabaseMappers.MovieMapper;
import entity.Movie;
import entity.PersonalMovie;
import entity.Recommendation;
import entity.Review;
import entity.Role;
import entity.User;
import facades.MovieFacade;
import facades.UserFacade;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import security.PasswordStorage;
/**
 *
 * @author Zygi
 */
public class getTester {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_development");
        UserFacade uf = new UserFacade(emf);
        MovieFacade mf = new MovieFacade(emf);
        mf.createMoviebyID("tt4508902");
        mf.postReview("tt4508902", "zygi", "Shit Post", 5);
    }
}
