package web.config;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Component
public class DataInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);
    private final UserService userService;

    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        List<User> users = List.of(
                new User("Harry", "Potter", "H_Potter@gmail.com", (byte) 20),
                new User("Hermione", "Granger", "H_Granger@gmail.com", (byte) 25),
                new User("Ron", "Weasley", "R_Weasley@gmail.com", (byte) 15),
                new User("General", "Grievous", "Grievous@gmail.com", (byte) 0),
                new User("Darth", "Vader", "DeathStar@vader.com", (byte) 124),
                new User("Jar-Jar", "Binks", "JarJar@binks.com", (byte) 10),
                new User("Anakin", "Skywalker", "Anakin@Skywalker.com", (byte) 15)
        );

        users.forEach(user -> {
            userService.addUser(user);
            logger.info("Добавление пользователей: {}", user);
        });
    }
}