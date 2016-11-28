/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import DatabaseMappers.MovieMapper;
import entity.Movie;
import entity.PersonalMovie;
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
        Persistence.generateSchema("pu_local", null);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_local");
        

       MovieFacade mf = new MovieFacade(emf);
       mf.createMoviebyTitle("Grease");
       UserFacade uf = new UserFacade(emf);
       User user = new User("EmilsUser","SuperSecretPassword","male","25-04-1984","Denmark");
       ArrayList<PersonalMovie> pmList = new ArrayList<PersonalMovie>();
       user.setMovieList(pmList);
       uf.createUser(user);
       

        }
        
        
        
        
    
    
}
