package com.vigor.web.mapper;

import com.vigor.Application;
import com.vigor.web.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Created by Vigor on 2017/10/22.
 * Mybatis 的 mapper测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class UserMapperTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void findAllUser() throws Exception {
        List<User> users = mapper.findAllUser();
        assertThat(users, hasSize(greaterThan(0)));
    }

    @Test
    public void findByName() throws Exception {
        List<User> users = mapper.findUserByName("Jones");
        for (User user : users) {
            assertThat(user.getName(), equalTo("Jones"));
        }
    }

    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setName("Vigor");
        user.setAge(33);
        user.setAddress("shenyang");
        mapper.insertUser(user);
    }

    @Test
    public void updateUser() throws Exception {
        User user = new User();
        user.setId(4);
        user.setName("Caroline");
        user.setAge(33);
        user.setAddress("shenyang");
        mapper.updateUser(user);
    }

    @Test
    public void deleteUser() throws Exception {
        mapper.deleteUser(4);
    }
}