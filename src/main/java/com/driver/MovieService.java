package com.driver;


import com.driver.client.MovieClient;
import com.driver.model.MovieDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieClient movieClient;


    public MovieDetails getMovie() {
        return movieClient.getMovie(500);
    }

}
