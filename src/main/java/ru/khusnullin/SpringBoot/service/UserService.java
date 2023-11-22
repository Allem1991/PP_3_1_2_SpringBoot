package ru.khusnullin.SpringBoot.service;

import ru.khusnullin.SpringBoot.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void deleteUser(long id);
    User getUserById(long id);
    void updateUser(User user);
    List<User> listUsers();
}
