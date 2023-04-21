package marchetti.raphael.movies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import marchetti.raphael.movies.models.Movie;
import marchetti.raphael.movies.models.Review;
import marchetti.raphael.movies.repositories.ReviewRepository;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate; // another way to talk with the database -> form a new dynamic query and do the job inside the database without using the repository

    // Complex business logic
    public Review createReview(String reviewBody, String imdbId){
        // When calling insert, it returns the actual object you inserted into the database
        Review review =  reviewRepository.insert(new Review(reviewBody)); // create new review

        // Performing template operation
        mongoTemplate.update(Movie.class).               // operation will be applied in the Movie class
            matching(Criteria.where("imdbId").
            is(imdbId)).                                            // which movie are we updating?
            apply(new Update().push("reviewIds").               // find the reviewIds camp
            value(review)).                                         // the value created will be directly pushed into the array
            first();                                                // making sure we are getting a single movie and this will be updated

        return review;        
    }
}
