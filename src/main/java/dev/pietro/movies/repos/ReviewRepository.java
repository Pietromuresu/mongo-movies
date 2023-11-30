package dev.pietro.movies.repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.pietro.movies.POJO.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
