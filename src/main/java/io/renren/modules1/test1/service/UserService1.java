package io.renren.modules1.test1.service;

import io.renren.modules1.test1.entity.User;

import java.util.List;

public interface UserService1 {

    List<User> getAll();

    User getOne(long id);

    void insert(User user);

    void update(User user);

    void delete(long id);
}
