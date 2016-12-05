package entity;

import entity.Movie;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-05T12:50:24")
@StaticMetamodel(PersonalMovie.class)
public class PersonalMovie_ { 

    public static volatile SingularAttribute<PersonalMovie, Movie> movie;
    public static volatile SingularAttribute<PersonalMovie, Integer> rating;
    public static volatile SingularAttribute<PersonalMovie, String> status;

}