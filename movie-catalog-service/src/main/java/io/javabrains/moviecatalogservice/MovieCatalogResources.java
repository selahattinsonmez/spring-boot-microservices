package io.javabrains.moviecatalogservice;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.models.userRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/getString")
    public String getString(){
        return "girdi";
    }
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        userRatings ratings =
                webClientBuilder.build()
                        .get()
                        .uri("http://ratings-data-service/ratingsData/users/4")
                        .retrieve()
                .bodyToMono(userRatings.class)
                .block();




        return ratings.getRatingList().stream().map(rating -> {
            Movie movie=webClientBuilder.build()
                    .get()
                    .uri("http://movie-info-service/movies/"+rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();
                return new CatalogItem(movie.getName(),"decs",rating.getRating());
            }).collect(Collectors.toList());
    }
}
