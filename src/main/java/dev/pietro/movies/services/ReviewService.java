package dev.pietro.movies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import dev.pietro.movies.POJO.Movie;
import dev.pietro.movies.POJO.Review;
import dev.pietro.movies.repos.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	public Review createReview(String reviewBody, String reviewImdbId) {
		Review review = reviewRepo.insert(new Review(reviewBody));
		
		mongoTemplate.update(Movie.class)
						.matching(Criteria.where("imdbId").is(reviewImdbId))
						.apply(new Update().push("reviewIds").value(review))
						.first();
		
		return review;
	}
}
