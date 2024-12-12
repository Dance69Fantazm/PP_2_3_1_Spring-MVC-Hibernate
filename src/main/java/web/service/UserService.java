package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void saveUser(String firstName, String lastName, String email, byte age);

    void removeUserById(long id);
}