package pl.krysinski.mongo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.krysinski.mongo.service.UserServiceImpl;
import pl.krysinski.mongo.utils.aspect.LogExecutionTime;

import java.io.IOException;

@Component
public class App {
    private UserServiceImpl userService;

    @Autowired
    public App(UserServiceImpl userService) {
        this.userService = userService;
    }

    @LogExecutionTime
    @EventListener(ApplicationReadyEvent.class)
    public void addAllToDb() throws IOException {
        userService.addAll();
    }


    @EventListener(ApplicationReadyEvent.class)
    @LogExecutionTime
    public void readAllFromDb() {
//        userService.findAll();
        userService.findAll().forEach(System.out::println);
    }
}
