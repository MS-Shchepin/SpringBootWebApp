package com.shchepinms.springbootwebapp.dao;

import com.shchepinms.springbootwebapp.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void deleteById(long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public void merge(User user) {
        entityManager.merge(user);
    }
}
