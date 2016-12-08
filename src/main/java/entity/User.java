package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import security.IUser;
import security.PasswordStorage;

@Entity
public class User implements IUser, Serializable {

    private String passwordHash;

    @Id
    private String userName;

    private String gender;

    private String birthday;

    private String country;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "users")
    List<Role> roles;

    @OneToMany(cascade = CascadeType.PERSIST)
    List<User> friendList;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    List<PersonalMovie> movieList;

    public User() {
    }

    public User(String userName, String password) throws PasswordStorage.CannotPerformOperationException {
        this.userName = userName;
        this.passwordHash = PasswordStorage.createHash(password);
    }

    public User(String userName, String password, String gender, String birthday, String country) throws PasswordStorage.CannotPerformOperationException {
        this.userName = userName;
        this.passwordHash = PasswordStorage.createHash(password);
        this.gender = gender;
        this.birthday = birthday;
        this.country = country;
    }

//  public User(String userName, String passwordHash,List<String> roles) {
//    this.userName = userName;
//    this.passwordHash = passwordHash;
//    //this.roles = roles;
//  }
    
    // ADD METHODS
    //----------------------------------------------------------
    public void addMovie(PersonalMovie movie) {
        if (movieList == null) {
            movieList = new ArrayList();
        }
        
        movieList.add(movie);
    }

    public void addFriendList(User user) {
        if (friendList == null) {
            friendList = new ArrayList();
        }
        friendList.add(user);
    }

    public void addRole(Role role) {
        if (roles == null) {
            roles = new ArrayList();
        }
        roles.add(role);
        role.addUser(this);
    }
    //-----------------------------------------------------------

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setFriendList(List<User> friendList) {
        this.friendList = friendList;
    }

    public void setMovieList(List<PersonalMovie> movieList) {
        this.movieList = movieList;
    }
    
    
    
    
    public List<Role> getRoles() {
        return roles;
    }

    @Override
    public List<String> getRolesAsStrings() {
        if (roles.isEmpty()) {
            return null;
        }
        List<String> rolesAsStrings = new ArrayList();
        for (Role role : roles) {
            rolesAsStrings.add(role.getRoleName());
        }
        return rolesAsStrings;
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    public void setPassword(String password) throws PasswordStorage.CannotPerformOperationException {
        this.passwordHash = PasswordStorage.createHash(password);
    }

    @Override
    public String getUserName() {
        return userName;
    }

    public List<User> getFriendList() {
        return friendList;
    }

    public List<PersonalMovie> getMovieList() {
        return movieList;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}

