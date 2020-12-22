package pl.krysinski.mongo.service;

import pl.krysinski.mongo.model.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    List<User> addAll() throws IOException;
    List<User> findAll();
}
