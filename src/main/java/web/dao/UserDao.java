package web.dao;

public interface UserDao {

    void saveUser(String firstName, String lastName, String email, byte age);

    void removeUserById(long id);
}
