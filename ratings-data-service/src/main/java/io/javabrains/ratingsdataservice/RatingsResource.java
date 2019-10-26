package io.javabrains.ratingsdataservice;

import io.javabrains.ratingsdataservice.models.Rating;
import io.javabrains.ratingsdataservice.models.userRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/ratingsData")
public class RatingsResource {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        Random random = new Random();
        int rating = random.nextInt(101);
        return new Rating(movieId,rating);
    }
    @RequestMapping("/users/{userId}")
    public userRatings getRatingByUserId(@PathVariable("userId") String userId){
        Random random = new Random();
        List<Rating> ratings = Arrays.asList(
                new Rating("1234",random.nextInt(101)),
                new Rating("2342",random.nextInt(101)),
                new Rating("234234",random.nextInt(101))
        );
        return new userRatings(ratings);
    }
}
