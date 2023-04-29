package com.driver;

import com.driver.model.MovieDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;


    @GetMapping("/get-movie")
    public ResponseEntity getMovie() {
        MovieDetails movie = movieService.getMovie();
        return new ResponseEntity(movie, HttpStatus.OK);
    }

}
