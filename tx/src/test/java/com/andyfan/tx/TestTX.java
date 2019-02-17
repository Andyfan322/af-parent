package com.andyfan.tx;

import com.andyfan.tx.mapper.UserMapper;
import com.andyfan.tx.models.User;
import com.andyfan.tx.models.UserFactoryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Date;

/**
 * @author andyFan
 * @date 2018年11月11日  11:20:39
 */
@SpringBootTest(classes = TXApplication.class)
@RunWith(SpringRunner.class)
public class TestTX {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private User user;
    @Autowired
    private UserFactoryBean factoryBean;

    @Test
    @Transactional
    @Rollback(value = false)
    public void defaultIsolation() throws IOException {
        Date now = new Date();
        User user = new User(1L, now, now, "andyfan2", 29, true);
        userMapper.insert(user);
        User user2 = new User(2L, now, now, "andyfan2", 29, true);
        User user1 = userMapper.selectByPrimaryKey(1L);
        System.out.println(user1);
        userMapper.insert(user2);
    }

    @Test
    public void tx() {
        user.setAge(111);
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.properties");


    }

    @Test
    public void testFactoryBean() throws Exception {
        user.setAge(44);
        User user = (User) factoryBean.getObject();
        System.out.println(user.equals(user));


    }
}
