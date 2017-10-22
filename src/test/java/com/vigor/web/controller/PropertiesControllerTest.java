package com.vigor.web.controller;

import com.vigor.web.VigorProperties;
import com.vigor.web.controller.PropertiesController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Created by Vigor on 2017/7/21.
 * Hello test
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PropertiesController.class)
@WithMockUser(username="user",roles="USER")
public class PropertiesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("com.vigor.example.content")
    private String content;

    @MockBean
    private VigorProperties vigorProperties;

    @Test
    public void helloVigor() throws Exception {
        given(this.vigorProperties.getContent()).willReturn(content);
        mockMvc.perform(get("/vigor")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(startsWith("Vigor")));
    }
}