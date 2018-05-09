package io.renren.modules1.test1.service.impl;

import io.renren.modules1.test1.dao.UserDao1;
import io.renren.modules1.test1.entity.User;
import io.renren.modules1.test1.service.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User业务类
 *
 * @author huyi
 * @create 2018/5/7 13:58
 */
@Service("userService1")
public class UserService1Impl implements UserService1 {

    @Autowired
    private UserDao1 userDao1;

    @Override
    public List<User> getAll() {
        return userDao1.getAll();
    }

    @Override
    public User getOne(long id) {
        return userDao1.getOne(id);
    }

    @Transactional(value = "secondTransactionManager",rollbackFor = Exception.class)
    @Override
    public void insert(User user) {
         userDao1.insert(user);
//         int i = 1/0;
    }

    @Override
    public void update(User user) {
        userDao1.update(user);
    }

    @Override
    public void delete(long id) {
        userDao1.delete(id);
    }
}
