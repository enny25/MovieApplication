package entity;

import entity.Review;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-05T12:50:24")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile SingularAttribute<Movie, String> Runtime;
    public static volatile ListAttribute<Movie, Review> Reviews;
    public static volatile SingularAttribute<Movie, String> Year;
    public static volatile SingularAttribute<Movie, String> Language;
    public static volatile SingularAttribute<Movie, String> Directors;
    public static volatile SingularAttribute<Movie, String> plot;
    public static volatile SingularAttribute<Movie, String> imdbid;
    public static volatile SingularAttribute<Movie, String> Poster;
    public static volatile SingularAttribute<Movie, String> ImdbRating;
    public static volatile SingularAttribute<Movie, String> Actors;
    public static volatile SingularAttribute<Movie, String> Genre;
    public static volatile SingularAttribute<Movie, String> title;

}