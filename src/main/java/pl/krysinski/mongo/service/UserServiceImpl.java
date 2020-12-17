package pl.krysinski.mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.krysinski.mongo.model.User;
import pl.krysinski.mongo.repository.UserRepo;
import pl.krysinski.mongo.utils.Reader;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;
    private Reader csvReader;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, Reader csvReader) {
        this.userRepo = userRepo;
        this.csvReader = csvReader;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public List<User> addAll() throws IOException {
        List<User> usersList = csvReader.readData();
        return userRepo.saveAll(usersList);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
}
