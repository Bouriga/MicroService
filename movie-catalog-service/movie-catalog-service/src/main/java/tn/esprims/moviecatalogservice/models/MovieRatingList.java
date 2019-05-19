package tn.esprims.moviecatalogservice.models;

public class MovieRatingList {

    private String userName;
    private String movieName;
    private Integer rating;
    private String description;
    private String picture;

    public MovieRatingList(String userName, String movieName, Integer rating, String description, String picture) {
        this.userName = userName;
        this.movieName = movieName;
        this.rating = rating;
        this.description = description;
        this.picture = picture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
