package io.renren.modules1.test1.dao;

import io.renren.modules1.test1.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 测试
 *
 * @author huyi
 * @create 2018/5/7 9:24
 */
@Mapper
public interface UserDao1 {

    List<User> getAll();

    User getOne(long id);

    void insert(User user);

    void update(User user);

    void delete(long id);
}
