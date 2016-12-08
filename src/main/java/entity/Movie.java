package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.OneToMany;


/**
 *
 * @author Lenovo
 */
@Entity
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String imdbid;
    private String title;
    private String Year;
    private String Runtime;
    private String Genre;
    private String Directors;
    private String Actors;
    private String Poster;
    private String plot;
    private String Language;
    private String ImdbRating;

    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Review> Reviews;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Recommendation> Recommendations;

    public Movie(String imdbId) {
        this.imdbid = imdbId;
    }

    public Movie(String imdbId, String Title) {
        this.imdbid = imdbId;
        this.title = Title;
    }

    public Movie(String imdbId, String Title, String Year, String Runtime, String Genre, String Directors, String Actors, String plot, String Language, String ImdbRating) {
        this.imdbid = imdbId;
        this.title = Title;
        this.Year = Year;
        this.Runtime = Runtime;
        this.Genre = Genre;
        this.Directors = Directors;
        this.Actors = Actors;
        this.plot = plot;
        this.Language = Language;
        this.ImdbRating = ImdbRating;

    }

    public Movie(String imdbId, String Title, String Year, String Runtime, String Genre, String Directors, String Actors, String plot, String Language, String ImdbRating, String Poster) {
        this.imdbid = imdbId;
        this.title = Title;
        this.Year = Year;
        this.Runtime = Runtime;
        this.Genre = Genre;
        this.Directors = Directors;
        this.Actors = Actors;
        this.plot = plot;
        this.Language = Language;
        this.ImdbRating = ImdbRating;
        this.Poster = Poster;
    }

    public Movie() {
    }

    // ADD METHODS
    //------------------------------------------------------------------
    

    public void addReview(Review review) {
        if (Reviews == null) {
            Reviews = new ArrayList();
        }
        Reviews.add(review);
    }

    public void addRecommendation(Recommendation recommendation) {
        if (Recommendations == null) {
            Recommendations = new ArrayList();
        }
        Recommendations.add(recommendation);
    }
    //------------------------------------------------------------------


    public void setReviews(List<Review> Reviews) {
        this.Reviews = Reviews;
    }

    public void setRecommendations(List<Recommendation> Recommendations) {
        this.Recommendations = Recommendations;
    }

    public List<Recommendation> getRecommendations() {
        return Recommendations;
    }

    public List<Review> getReviews() {
        return Reviews;
    }

    public String getImdbId() {
        return imdbid;
    }

    public void setImdbId(String imdbId) {
        this.imdbid = imdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String Runtime) {
        this.Runtime = Runtime;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public String getDirectors() {
        return Directors;
    }

    public void setDirectors(String Directors) {
        this.Directors = Directors;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String Actors) {
        this.Actors = Actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public String getImdbRating() {
        return ImdbRating;
    }

    public void setImdbRating(String ImdbRating) {
        this.ImdbRating = ImdbRating;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String Poster) {
        this.Poster = Poster;
    }


}
