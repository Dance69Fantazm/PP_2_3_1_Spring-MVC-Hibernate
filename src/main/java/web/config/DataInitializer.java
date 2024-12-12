package web.config;

import org.springframework.beans.factory.InitializingBean;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.service.UserService;

@Component
public class DataInitializer implements InitializingBean {

    private final UserService userService;

    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        userService.addUser(new User("Harry", "Potter", "H_Potter@gmail.com", (byte) 20));
        userService.addUser(new User("Hermione", "Granger", "H_Granger@gmail.com", (byte) 25));
        userService.addUser(new User("Ron", "Weasley", "R_Weasley@gmail.com", (byte) 15));
        userService.addUser(new User("General", "Grievous", "Grievous@gmail.com", (byte) 0));
        userService.addUser(new User("Darth", "Vader", "DeathStar@vader.com", (byte) 124));
        userService.addUser(new User("Jar-Jar", "Binks", "JarJar@binks.com", (byte) 10));
        userService.addUser(new User("Anakin", "Skywalker", "Anakin@Skywalker.com", (byte) 15));
    }
}
