package com.vigor.redis;

import com.vigor.Application;
import com.vigor.redis.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Vigor on 2017/11/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {

    @Autowired
    private StringRedisTemplate redisStringTemplate;

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Test
    public void setString() throws Exception {
        redisStringTemplate.opsForValue().set("string", "Vigor");
        assertThat(redisStringTemplate.opsForValue().get("name"), equalTo("Vigor"));
    }

    @Test
    public void setJsonString() throws Exception {
        User user = new User(1, "Vigor", 23, "London");
        redisTemplate.opsForValue().set("json", user);
        assertThat(redisTemplate.opsForValue().get("json").getName(), equalTo("Vigor"));
    }
}
