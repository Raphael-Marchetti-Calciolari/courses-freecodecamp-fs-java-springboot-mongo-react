package marchetti.raphael.movies.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import marchetti.raphael.movies.models.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    Optional<Movie> findMovieByImdbId(String imdbId); // there's no automatic method for finding by ImdbId, so we have to implement this one by ourselves
}
