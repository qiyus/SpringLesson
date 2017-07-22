package com.vigor.web;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

/**
 * Created by Vigor on 2017/7/21.
 * User test
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest {
    private final static String JSON_GEORGE = "{\"id\":1,\"userName\":\"George\",\"age\":56}";
    private final static String JSON_JONES = "{\"id\":1,\"userName\":\"Jones\",\"age\":58}";
    private final static String JSON_USER_LIST = "[]";
    private final static String JSON_SUCCESS = "{\"code\":\"0\",\"message\":\"success\"}";

    @Autowired
    private MockMvc mvc;

    @Test
    public void a_addUser() throws Exception {
        mvc.perform(post("/user/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON_GEORGE)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(JSON_SUCCESS)));
    }

    @Test
    public void e_getUsers() throws Exception {
        mvc.perform(get("/user/list")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(JSON_USER_LIST)));
    }

    @Test
    public void c_getUser() throws Exception {
        mvc.perform(get("/user/1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(JSON_JONES)));
    }

    @Test
    public void b_updateUser() throws Exception {
        mvc.perform(put("/user/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON_JONES)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(JSON_SUCCESS));
    }

    @Test
    public void d_deleteUser() throws Exception {
        mvc.perform(delete("/user/1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(JSON_SUCCESS));
    }
}