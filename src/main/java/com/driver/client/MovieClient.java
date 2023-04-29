package com.driver.client;

import com.driver.model.MovieDetails;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class MovieClient {
    RestTemplate restTemplate = new RestTemplate();

    public static final String baseUrl  ="https://api.themoviedb.org/3";
    private static final String key = "cd46fe13f1442cfa663d94a7d3ed7e5e";
    public static final String GET_MOVIE_PATH = "/movie/%s";
    public static final String POST_MOVIE_PATH = "/add-movie";
    public MovieDetails getMovie(int id) {
        String url2 = baseUrl + String.format(GET_MOVIE_PATH, id);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url2)
                .queryParam("api_key", key) // you can use this directly instead of using map
                .encode()
                .toUriString();

        ResponseEntity<MovieDetails> movieDetailsResponse = restTemplate.exchange(urlTemplate, HttpMethod.GET, HttpEntity.EMPTY, MovieDetails.class);
        return movieDetailsResponse.getBody();

    }

    //another way using map for request params
    public MovieDetails getMovie2(int id) {
        String url2 = baseUrl + String.format(GET_MOVIE_PATH, id);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url2)
                .queryParam("api_key", "{api_key}") // you can use this directly instead of using map
                .encode()
                .toUriString();

        Map<String, Object> map = new HashMap<>();
        map.put("api_key", key );
        ResponseEntity<MovieDetails> movieDetailsResponse = restTemplate.exchange(urlTemplate, HttpMethod.GET, HttpEntity.EMPTY, MovieDetails.class);
        return movieDetailsResponse.getBody();
    }

    public MovieDetails getMovie3( int id) {
        String url = String.format("https://api.themoviedb.org/3/movie/%s?api_key=cd46fe13f1442cfa663d94a7d3ed7e5e", id);

        MovieDetails movieDetails = restTemplate.getForObject(url, MovieDetails.class);
        return movieDetails;
    }

    public void addMovie(MovieDetails movieDetails) {
        String url = baseUrl + POST_MOVIE_PATH + "?api_key={api_key}";
        Map<String, Object> requestParams = new HashMap<>();
        requestParams.put("api_key", key );
        MovieDetails movieDetails1 = new MovieDetails(1, "name_1", 2.23);
        HttpEntity httpEntity = new HttpEntity<>(movieDetails1);
        restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class, requestParams);
    }


}
