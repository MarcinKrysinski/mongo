package pl.krysinski.mongo;

import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.krysinski.mongo.aspect.AfterAspect;
import pl.krysinski.mongo.aspect.BeforeAspect;
import pl.krysinski.mongo.aspect.LogExecutionTime;
import pl.krysinski.mongo.service.UserServiceImpl;

import java.io.IOException;

@Component
public class test {

    private UserServiceImpl userService;

    @Autowired
    public test(UserServiceImpl userService) {
        this.userService = userService;
    }

    @AfterAspect
    @BeforeAspect
    @EventListener(ApplicationReadyEvent.class)
    public void testSave() throws IOException {
        userService.addAll();
    }

    @LogExecutionTime
    @EventListener(ApplicationReadyEvent.class)
    public void testSave2() throws IOException {
        userService.addAll();
    }


//    @EventListener(ApplicationReadyEvent.class)
//    @AfterAspect
//    @BeforeAspect
//    public void testRead() {
//        userService.findAll();
//    }
}
