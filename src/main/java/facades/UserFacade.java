package facades;

import entity.PersonalMovie;
import entity.Review;
import entity.Movie;
import security.IUserFacade;
import entity.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

    public List<User> getFriendListById(String id) {
        User user = getUserByUserId(id);
        List<User> friendList = user.getFriendList();
        return friendList;

    }

    public List<PersonalMovie> getPersonalMovieListById(String id) {
        User user = getUserByUserId(id);
        List<PersonalMovie> movieList = user.getMovieList();
        return movieList;
    }

    public User updateUser(User user) {

        List movies = user.getMovieList();
        System.out.println(movies);
        User updatedUser = getUserByUserId(user.getUserName());
        EntityManager em = getEntityManager();
        updatedUser.setBirthday(user.getBirthday());
        updatedUser.setCountry(user.getCountry());
        updatedUser.setGender(user.getGender());
        updatedUser.setFriendList(user.getFriendList());
        updatedUser.setMovieList(user.getMovieList());
        updatedUser.setRoles(user.getRoles());
        try {
            em.getTransaction().begin();
            em.merge(updatedUser);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        return updatedUser;
    }

    public void beforeAddToPersonalMovieList(String username, String status, String imdbid, int rating) {
        EntityManager em = getEntityManager();
        Movie foundMovie = em.find(Movie.class, imdbid);
        User foundUser = em.find(User.class, username);
        PersonalMovie pm = new PersonalMovie(foundMovie, rating, status, foundUser);
        addToPersonalMovieList(pm);
    }

    public void addToPersonalMovieList(PersonalMovie pm) {

        EntityManager em = getEntityManager();
        List<PersonalMovie> pmList = getPersonalMovieListById(pm.getUser().getUserName());
        pmList.add(pm);

        try {
            em.getTransaction().begin();
            em.merge(pmList);
            em.getTransaction().commit();

        } finally {
            em.close();
        }

    }

    public boolean createUser(User user) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();

        } finally {
            em.close();

        }
        return (getUserByUserId(user.getUserName()) != null);

    }
    
    
    public void addBuddy(User user){
        EntityManager em = getEntityManager();
        List<User> buddyList = getFriendListById(user.getUserName());
        buddyList.add(user);

        try {
            em.getTransaction().begin();
            em.merge(buddyList);
            em.getTransaction().commit();

        } finally {
            em.close();
        }

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
