package com.vigor.web.controller;

import com.vigor.Application;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Vigor on 2017/7/21.
 * User test
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WithMockUser(username = "user", roles = "USER")
public class UserControllerTest {
    private final static String JSON_GEORGE = "{\"name\":\"Caroline\",\"age\":56, \"address\":\"beijing\"}";
    private final static String JSON_JONES = "{\"id\":1,\"name\":\"Jones\",\"age\":53, \"address\":\"shanghai\"}";

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUpBeforeClass() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    @Transactional
    @Rollback
    public void a_addUser() throws Exception {
        mvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON_GEORGE)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value("0"));
    }

    @Test
    public void b_getUsers() throws Exception {
        mvc.perform(get("/users")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(startsWith("[")))
                .andExpect(content().string(endsWith("]")));
    }

    @Test
    public void c_getUserByName() throws Exception {
        mvc.perform(get("/user/Jones")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Jones"));
    }

    @Test
    public void c_getOlderUser() throws Exception {
        mvc.perform(get("/user?older=30")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(startsWith("[")))
                .andExpect(content().string(endsWith("]")));
    }

    @Test
    public void d_updateUser() throws Exception {
        mvc.perform(put("/user/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON_JONES)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value("0"));
    }

    @Test
    @Transactional
    @Rollback
    public void e_deleteUser() throws Exception {
        mvc.perform(delete("/user/2")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value("0"));
    }
}