///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package facades;
//
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
//        userOne = new User("Username", "Password", "Male", "25-04-2890", "Glorius Nation of Kazakhstan");
//        Role user = new Role("user");
//        userOne.addRole(user);
//        user.addUser(userOne);
//        uFacade.createUser(userOne);
//        userTwo = new User ("Johhny","Password","Male","24-04-120","China");
//        userTwo.addRole(user);
//        user.addUser(userTwo);
//         userOne.addFriendList(userTwo);
//         uFacade.createUser(userTwo);
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
//        String id = "";
//        UserFacade instance = null;
//        List<PersonalMovie> expResult = null;
//        List<PersonalMovie> result = instance.getPersonalMovieListById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
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
//    /**
//     * Test of beforeAddToPersonalMovieList method, of class UserFacade.
//     */
//    @Test
//    public void testBeforeAddToPersonalMovieList() {
//        System.out.println("beforeAddToPersonalMovieList");
//        String username = "";
//        String status = "";
//        String imdbid = "";
//        int rating = 0;
//        UserFacade instance = null;
//        instance.beforeAddToPersonalMovieList(username, status, imdbid, rating);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
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
