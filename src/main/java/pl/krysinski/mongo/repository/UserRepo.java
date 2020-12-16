package pl.krysinski.mongo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.krysinski.mongo.model.User;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
}
