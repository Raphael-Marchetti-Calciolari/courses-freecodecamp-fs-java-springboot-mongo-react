package marchetti.raphael.movies.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies") // this controller will handle requests in this endpoint
public class MoviesController {
    @GetMapping
    public ResponseEntity<String> allMovies() {
        return new ResponseEntity<String>("All Movies", HttpStatus.OK);
    }
}
