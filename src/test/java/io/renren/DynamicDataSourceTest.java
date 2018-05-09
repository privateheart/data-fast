package io.renren;

import io.renren.modules.api.entity.UserEntity;
import io.renren.modules.api.service.UserService;
import io.renren.modules1.test1.entity.User;
import io.renren.modules1.test1.service.UserService1;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDataSourceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserService1 userService1;

    @Test
    public void test(){

        UserEntity user = userService.queryObject(1L);
        System.out.println(ToStringBuilder.reflectionToString(user));

//        //切换数据源
//        DynamicDataSource.setDataSource(DataSourceContext.SECOND.getName());
//        User user2 = userService.queryObject(1L);
//        System.out.println(ToStringBuilder.reflectionToString(user2));

    }

    @Test
    public void testSecondDataSource(){
        User user = new User();
        user.setNickName("qq");
        user.setPassWord("123456");
        user.setUserName("hehe");
        user.setUserSex("女");
        userService1.insert(user);
    }

}
