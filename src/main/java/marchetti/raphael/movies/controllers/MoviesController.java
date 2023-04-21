package marchetti.raphael.movies.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import marchetti.raphael.movies.models.Movie;
import marchetti.raphael.movies.services.MovieService;

@RestController
@RequestMapping("/api/v1/movies") // this controller will handle requests in this endpoint - doesn't work when hitting /api/v1/movies/
public class MoviesController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}") // receives a param that is the id of the movie
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){ // whatever is get through the path variable, it is converted to ObjectId id
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
}
