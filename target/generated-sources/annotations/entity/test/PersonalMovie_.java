package entity.test;

import entity.Movie;
import entity.PersonalMovie;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-02T09:38:04")
@StaticMetamodel(PersonalMovie.class)
public class PersonalMovie_ { 

    public static volatile SingularAttribute<PersonalMovie, Movie> movie;
    public static volatile SingularAttribute<PersonalMovie, Integer> rating;
    public static volatile SingularAttribute<PersonalMovie, String> status;

}