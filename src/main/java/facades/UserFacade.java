package facades;

import entity.Movie;
import entity.PersonalMovie;
import security.IUserFacade;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import security.IUser;
import security.PasswordStorage;

public class UserFacade implements IUserFacade {

    EntityManagerFactory emf;

    public UserFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public User getUserByUserId(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    public ArrayList<User> getFriendListById(String id) {
        User user = getUserByUserId(id);
        ArrayList<User> friendList = (ArrayList) user.getFriendList();
        return friendList;

    }

    public ArrayList<PersonalMovie> getPersonalMovieListById(String id) {
        User user = getUserByUserId(id);
        ArrayList<PersonalMovie> movieList = (ArrayList) user.getMovieList();
        return movieList;
    }

    public User updateUser(User user) {

        User updatedUser = getUserByUserId(user.getUserName());
        EntityManager em = getEntityManager();
        updatedUser.setBirthday(user.getBirthday());
        updatedUser.setCountry(user.getCountry());
        updatedUser.setGender(user.getGender());
        updatedUser.setFriendList(user.getFriendList());
        updatedUser.setMovieList(user.getMovieList());
        try {
            em.getTransaction().begin();
            em.merge(updatedUser);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        return updatedUser;
    }

    public void addToPersonalMovieList(String username, PersonalMovie pm) {

        EntityManager em = getEntityManager();        
        ArrayList<PersonalMovie> pmList = getPersonalMovieListById(username);
        pmList.add(pm);
        try {
            em.getTransaction().begin();
            em.merge(pmList);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
      
      
  }
  public boolean createUser (User user){
       EntityManager em = getEntityManager();
      
         try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
            
        } finally {
            em.close();
            
        }
         return (getUserByUserId(user.getUserName())!= null);
      
  }

    

    /*
  Return the Roles if users could be authenticated, otherwise null
     */
    @Override
    public List<String> authenticateUser(String userName, String password) {
        IUser user = getUserByUserId(userName);
        try {
            return user != null && PasswordStorage.verifyPassword(password, user.getPassword()) ? user.getRolesAsStrings() : null;
        } catch (PasswordStorage.CannotPerformOperationException | PasswordStorage.InvalidHashException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
}
