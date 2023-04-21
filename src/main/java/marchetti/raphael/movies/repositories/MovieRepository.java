package marchetti.raphael.movies.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import marchetti.raphael.movies.models.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    
}
