package marchetti.raphael.movies.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marchetti.raphael.movies.models.Movie;
import marchetti.raphael.movies.repositories.MovieRepository;

@Service
public class MovieService {
    // database access methods

    @Autowired // we want the framework to instantiate this class for us
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        return movieRepository.findAll(); // described inside MongoRepository class (extended by our movie repository)
    }

    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
