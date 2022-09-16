package com.shchepinms.springbootwebapp.service;

import com.shchepinms.springbootwebapp.entity.User;
import java.util.List;

public interface UserService {
    void save(User user);
    User getById(long id);
    List<User> getAllUsers();
    void deleteById(long id);
    void delete(User user);
}
