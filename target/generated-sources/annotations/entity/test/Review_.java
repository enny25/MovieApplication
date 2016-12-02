package entity.test;

import entity.Movie;
import entity.Review;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-02T09:38:04")
@StaticMetamodel(Review.class)
public class Review_ { 

    public static volatile SingularAttribute<Review, Integer> Score;
    public static volatile SingularAttribute<Review, Movie> movie;
    public static volatile SingularAttribute<Review, Long> id;
    public static volatile SingularAttribute<Review, User> user;
    public static volatile SingularAttribute<Review, String> reviewText;

}