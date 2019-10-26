package io.javabrains.moviecatalogservice.models;

import java.util.List;

public class userRatings {
    private List<Rating> ratingList;
    public userRatings(){

    }
    public userRatings(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }
}
