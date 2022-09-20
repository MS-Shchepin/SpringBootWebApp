package com.shchepinms.springbootwebapp.service;

import com.shchepinms.springbootwebapp.dao.UserDao;
import com.shchepinms.springbootwebapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void save(User user) {
        if (user.getId() == 0) {
            userDao.save(user);
        } else {
            userDao.merge(user);
        }
    }

    @Transactional
    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }
}
