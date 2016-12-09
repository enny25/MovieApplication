///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package facades;
//
//import entity.Movie;
//import entity.PersonalMovie;
//import entity.Role;
//import entity.User;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.BeforeClass;
//import security.PasswordStorage;
//
///**
// *
// * @author Lenovo
// */
//public class UserFacadeTest {
//
//    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_test");
//    private EntityManager em = emf.createEntityManager();
//
//    private static MovieFacade instance = new MovieFacade(emf);
//    private static UserFacade uFacade = new UserFacade(emf);
//    private static User userOne;
//    private static User userTwo;
//
//    public UserFacadeTest() {
//    }
//
//    @BeforeClass
//    public static void setUp() throws PasswordStorage.CannotPerformOperationException {
//        Persistence.generateSchema("pu_test", null);
//        Movie frozen = new Movie("tt2294629","Frozen","2013","102 min","Animation, Adventure, Comedy","Chris Buck, Jennifer Lee,",
//        "Kristen Bell, Idina Menzel, Jonathan Groff, Josh Gad",
//        "When the newly crowned Queen Elsa accidentally uses her power to turn things into ice to curse her home in infinite winter, her sister, Anna, teams up with a mountain man, his playful reindeer, and a snowman to change the weather condition."
//         ,"English, Icelandic","7.6","https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ1MjQwMTE5OF5BMl5BanBnXkFtZTgwNjk3MTcyMDE@._V1_SX300.jpg");
//        PersonalMovie pm = new PersonalMovie(frozen,5,"nice");
//        
//        
//        userOne = new User("Username", "Password", "Male", "25-04-2890", "Glorius Nation of Kazakhstan");
//        userTwo = new User ("Johhny","Password","Male","24-04-120","China");
//        uFacade.createUser(userOne);
//         uFacade.createUser(userTwo);
//        Role user = new Role("user");
//        userOne.addRole(user);
//        userTwo.addRole(user);
//        userOne.addFriendList(userTwo);
//        userTwo.addMovie(pm);
//        uFacade.updateUser(userOne);
//        uFacade.updateUser(userTwo);
//
//    }
//
//    /**
//     * Test of getUserByUserId method, of class UserFacade.
//     */
//    @Test
//    public void testGetUserByUserId() {
//        String id = "Username";
//
//        String Birthday ="25-04-2890";
//        User result = uFacade.getUserByUserId(id);
//        assertEquals(Birthday, result.getBirthday());
//    }
//
//    /**
//     * Test of getFriendListById method, of class UserFacade.
//     */
//    @Test
//    public void testGetFriendListById() {
//        String id = "Username";
//        String expResult = "Johhny";
//        List<User> result = uFacade.getFriendListById(id);
//        assertEquals(expResult, result.get(0).getUserName());
//    }
//
//    /**
//     * Test of getPersonalMovieListById method, of class UserFacade.
//     */
//    @Test
//    public void testGetPersonalMovieListById() {
//        System.out.println("getPersonalMovieListById");
//        String id = userTwo.getUserName();
//        Movie frozen = new Movie("tt2294629","Frozen","2013","102 min","Animation, Adventure, Comedy","Chris Buck, Jennifer Lee,",
//        "Kristen Bell, Idina Menzel, Jonathan Groff, Josh Gad",
//        "When the newly crowned Queen Elsa accidentally uses her power to turn things into ice to curse her home in infinite winter, her sister, Anna, teams up with a mountain man, his playful reindeer, and a snowman to change the weather condition."
//         ,"English, Icelandic","7.6","https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ1MjQwMTE5OF5BMl5BanBnXkFtZTgwNjk3MTcyMDE@._V1_SX300.jpg");
//        PersonalMovie pm = new PersonalMovie(frozen,5,"nice");
//        PersonalMovie expResult = pm;
//        List<PersonalMovie> result = uFacade.getPersonalMovieListById(id);
//        assertEquals(expResult.getMovie().getImdbId(), result.get(0).getMovie().getImdbId());
//       
//    }
//
//    /**
//     * Test of updateUser method, of class UserFacade.
//     */
//    @Test
//    public void testUpdateUser() {
//        String expResult = "NotChina";
//        
//        userTwo.setCountry(expResult);
//        User result = uFacade.updateUser(userTwo);
//        assertEquals(expResult, result.getCountry());
//    }
//
//
//
//    /**
//     * Test of authenticateUser method, of class UserFacade.
//     */
//    @Test
//    public void testAuthenticateUser() {
//        String userName = "Username";
//        String password = "Password";
//        List<String> result = uFacade.authenticateUser(userName, password);
//        assertNotNull( result);
//    }
//
//}
