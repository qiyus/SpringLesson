package com.vigor.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Vigor on 2017/10/15.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebController.class)
@WebAppConfiguration
public class WebControllerTest {

    @Autowired
    private WebController webController;

    @Test
    public void subject() throws Exception {
        ModelMap map = new ModelMap();
        String index = webController.hello(map);
        assertThat(index, equalTo("home"));
        assertThat(map.get("start"), equalTo("/hello"));
    }
}