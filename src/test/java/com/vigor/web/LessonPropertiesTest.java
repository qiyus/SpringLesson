package com.vigor.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Vigor on 2017/7/22.
 * 测试属性的自动注入
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LessonProperties.class)
public class LessonPropertiesTest {

    @Autowired
    private LessonProperties properties;

    @Test
    public void getName() throws Exception {
        assertThat(properties.getName(), equalTo("Vigor"));
    }

    @Test
    public void getTitle() throws Exception {
        assertThat(properties.getTitle(), equalTo("Spring boot课程"));
    }

    @Test
    public void getContent() throws Exception {
        assertThat(properties.getContent(), equalTo("Vigor正在学习Spring boot课程。"));
    }

    @Test
    public void getValue() throws Exception {
        assertThat(properties.getValue(), startsWith("vigor-"));
    }
}