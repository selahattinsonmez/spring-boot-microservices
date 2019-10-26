package io.javabrains.ratingsdataservice.models;

import java.util.List;

public class userRatings {
    private List<Rating> ratingList;

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
