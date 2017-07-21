package com.vigor.web;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Vigor on 2017/7/21.
 * User test
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserController.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest {
    private final static String JSON_GEORGE = "{\"id\":1,\"userName\":\"George\",\"age\":56}";
    private final static String JSON_JONES = "{\"id\":1,\"userName\":\"Jones\",\"age\":58}";
    private final static String JSON_USER_LIST = "[]";
    private final static String JSON_SUCCESS = "{\"code\":\"0\",\"message\":\"success\"}";
    private final static String JSON_FAIL = "{\"code\":\"0001\",\"message\":\"fail\"}";

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void a_addUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/user/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON_GEORGE)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(JSON_SUCCESS)));
    }

    @Test
    public void e_getUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/list")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(JSON_USER_LIST)));
    }

    @Test
    public void c_getUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(JSON_JONES)));
    }

    @Test
    public void b_updateUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/user/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON_JONES)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(JSON_SUCCESS));
    }

    @Test
    public void d_deleteUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/user/1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(JSON_SUCCESS));
    }
}