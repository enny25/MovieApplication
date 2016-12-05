package entity;

import entity.PersonalMovie;
import entity.Role;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-05T12:50:24")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> birthday;
    public static volatile SingularAttribute<User, String> country;
    public static volatile SingularAttribute<User, String> gender;
    public static volatile ListAttribute<User, Role> roles;
    public static volatile ListAttribute<User, User> friendList;
    public static volatile ListAttribute<User, PersonalMovie> movieList;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile SingularAttribute<User, String> passwordHash;

}