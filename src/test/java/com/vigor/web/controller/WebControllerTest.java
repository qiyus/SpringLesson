package com.vigor.web.controller;

import com.vigor.web.properties.VigorProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by Vigor on 2017/10/15.
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(WebController.class)
@WithMockUser(username="user",roles="USER")
@WebAppConfiguration
public class WebControllerTest {

    @Autowired
    private WebController webController;

    @Value("Vigor")
    private String name;

    @MockBean
    private VigorProperties vigorProperties;

    @Test
    public void home() throws Exception {
        ModelMap map = new ModelMap();
        String index = webController.home(map);
        assertThat(index, equalTo("home"));
    }

    @Test
    public void homeAttribute() throws Exception {
        ModelMap map = new ModelMap();
        webController.home(map);
        assertThat(map.get("start"), equalTo("/hello"));
    }

    @Test
    public void hello() throws Exception {
        ModelMap map = new ModelMap();
        String index = webController.hello(map);
        assertThat(index, equalTo("hello"));
    }

    @Test
    public void helloAttribute() throws Exception {
        given(this.vigorProperties.getName()).willReturn(name);
        ModelMap map = new ModelMap();
        webController.hello(map);
        assertThat(map.get("name"), equalTo("Vigor"));
    }
}