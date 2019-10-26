package io.javabrains.moviecatalogservice.models;

public class Rating {
    private String movieId;
    private int rating;
    public Rating(){

    }
    public Rating(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }
    public Rating(Rating rating){
        this.movieId = rating.getMovieId();
        this.rating = rating.getRating();
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
