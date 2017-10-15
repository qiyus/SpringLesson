package com.vigor.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by Vigor on 2017/10/15.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = IndexController.class)
@WebAppConfiguration
public class IndexControllerTest {

    @Autowired
    private IndexController indexController;

    @Test
    public void index() throws Exception {
        ModelMap map = new ModelMap();
        String index = indexController.startBlog(map);
        assertThat(index, equalTo("index"));
        assertThat(map.get("subject"), equalTo("thymeleaf test ok"));
    }
}