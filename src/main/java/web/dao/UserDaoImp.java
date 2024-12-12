package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDaoImp implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserDaoImp (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void saveUser(String firstName, String lastName, String email, byte age) {
        User user = new User(firstName, lastName, email, age);
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void removeUserById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}