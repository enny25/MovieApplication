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
 * @author Lenovow
 */
public class tester {

    public static void main(String[] args) throws PasswordStorage.CannotPerformOperationException {
        Persistence.generateSchema("pu_development", null);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_development");
        UserFacade uf = new UserFacade(emf);
        MovieFacade mf = new MovieFacade(emf);
        User zygi = new User("zygi", "test", "male", "1996-08-10", "Lithuania");
        User emil = new User("emil", "test", "male", "OLD AF", "Denmark");
        User daniel = new User("daniel", "test", "male", "OLD AF", "Denmark");
        User plamen = new User("plamen", "password", "male", "3RD STRONGES IMMORTAL", "Bulgaria");
        Role admin = new Role("Admin");
        Role user = new Role("User");
        Role slave = new Role("Slave");
        zygi.addRole(admin);
        emil.addRole(user);
        emil.addRole(slave);
        daniel.addRole(user);
        daniel.addRole(slave);
        plamen.addRole(user);
        plamen.addRole(slave);
        zygi.addFriendList(emil);
        zygi.addFriendList(plamen);
        zygi.addFriendList(daniel);
        emil.addFriendList(plamen);
        emil.addFriendList(daniel);
        emil.addFriendList(zygi);
        plamen.addFriendList(zygi);
        daniel.addFriendList(zygi);
        uf.createUser(zygi);
        uf.createUser(emil);
        uf.createUser(daniel);
        uf.createUser(plamen);
        
        
        mf.createMoviebyTitle("Frozen");
        mf.createMoviebyTitle("Grease");
        mf.createMoviebyTitle("Black Hawk Down");
        mf.createMoviebyTitle("The Grudge");
        Movie movieTest1 = mf.getMoviebyTitle("Frozen");
        Movie movieTest2 = mf.getMoviebyTitle("Grease");
        Movie movieTest3 = mf.getMoviebyTitle("Black Hawk Down");
        Movie movieTest4 = mf.getMoviebyTitle("The Grudge");
        
        PersonalMovie pm1 = new PersonalMovie(movieTest1, 5, "Completed",zygi);
        PersonalMovie pm2 = new PersonalMovie(movieTest2, 3, "Watching",zygi);
        PersonalMovie pm3 = new PersonalMovie(movieTest3, 4, "Watching", emil);
        PersonalMovie pm4 = new PersonalMovie(movieTest4, 2, "Completed", emil);
        PersonalMovie pm5 = new PersonalMovie(movieTest1, 5, "Completed",emil);
        PersonalMovie pm6 = new PersonalMovie(movieTest2, 3, "Watching",emil);
        PersonalMovie pm7 = new PersonalMovie(movieTest3, 4, "Watching", zygi);
        PersonalMovie pm8 = new PersonalMovie(movieTest4, 2, "Completed", zygi);
        zygi.addMovie(pm1);
        zygi.addMovie(pm2);
        zygi.addMovie(pm7);
        zygi.addMovie(pm8);
        emil.addMovie(pm3);
        emil.addMovie(pm4);
        emil.addMovie(pm5);
        emil.addMovie(pm6);
        uf.updateUser(zygi);
        uf.updateUser(emil);
        uf.updateUser(daniel);
        uf.updateUser(plamen);
        
        
        Recommendation recTest1 = new Recommendation(movieTest1, movieTest2, zygi, "Hot AF");
        Review revTest1 = new Review(zygi, movieTest1, "Hella Good", 5);
        Review revTest2 = new Review(zygi, movieTest2, "Quite cool I'd say", 3);
        Review revTest3 = new Review(zygi, movieTest3, "Impressive", 4);
        Review revTest4 = new Review(zygi, movieTest4, "Dumb idea", 1);
        Review revTest5 = new Review(emil, movieTest4, "Boring", 2);
        Review revTest6= new Review(emil, movieTest3, "Average", 3);
        Review revTest7 = new Review(emil, movieTest2, "Entertaining", 4);
        movieTest1.addRecommendation(recTest1);
        movieTest1.addReview(revTest1);
        movieTest2.addReview(revTest2);
        movieTest3.addReview(revTest3);
        movieTest4.addReview(revTest4);
        movieTest4.addReview(revTest5);
        movieTest3.addReview(revTest6);
        movieTest2.addReview(revTest7);
        mf.updateMovie(movieTest1);
        mf.updateMovie(movieTest2);
        mf.updateMovie(movieTest3);
        mf.updateMovie(movieTest4);
//        
//        uf.addToPersonalMovieList(pm3);
//        uf.addToPersonalMovieList(pm4);
        

    }

}
