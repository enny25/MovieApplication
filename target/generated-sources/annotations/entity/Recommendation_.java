package entity;

import entity.Movie;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-05T12:50:24")
@StaticMetamodel(Recommendation.class)
public class Recommendation_ { 

    public static volatile SingularAttribute<Recommendation, Movie> movie2;
    public static volatile SingularAttribute<Recommendation, Movie> movie1;
    public static volatile SingularAttribute<Recommendation, String> description;
    public static volatile SingularAttribute<Recommendation, Long> id;
    public static volatile SingularAttribute<Recommendation, User> user;

}