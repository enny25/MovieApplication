package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import security.IUser;
import security.PasswordStorage;

@Entity(name = "SEED_USER")
public class User implements IUser, Serializable{
 
  private String passwordHash; 
  
  @Id
  private String userName;
  
  @ManyToMany
  List<Role> roles;
  
  @ManyToMany
  List<User> friendList;
  
  @ManyToMany
  List<Movie> movieList;
  
  
  
  
 
  public User() {
  }

  public User(String userName, String password) throws PasswordStorage.CannotPerformOperationException {
    this.userName = userName;
    this.passwordHash = PasswordStorage.createHash(password);
  }
  
//  public User(String userName, String passwordHash,List<String> roles) {
//    this.userName = userName;
//    this.passwordHash = passwordHash;
//    //this.roles = roles;
//  }
  
  public void addRole(Role role){
    if(roles == null){
      roles = new ArrayList();
    }
    roles.add(role);
    role.addUser(this);
  }
  
  public List<Role> getRoles(){
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

    public void setFriendList(List<User> friendList) {
        this.friendList = friendList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
     
}
