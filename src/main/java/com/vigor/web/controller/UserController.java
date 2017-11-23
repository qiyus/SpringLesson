package com.vigor.web.controller;

import com.vigor.web.domain.Success;
import com.vigor.web.domain.User;
import com.vigor.web.exception.UserEmptyException;
import com.vigor.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vigor on 2017/7/19.
 * 用户管理
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper mapper;

    /**
     * 用户列表
     * @return 用户列表
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() throws Exception {
        List<User> users = mapper.findAllUser();
        if (users.size() == 0) {
            throw new UserEmptyException("user is empty");
        }
        return users;
    }

    /**
     * 追加用户
     * @param user 用户
     * @return 操作结果
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Success addUser(@RequestBody User user) {
        mapper.insertUser(user);
        return new Success();
    }

    /**
     * 取得指定用户
     * @param name 用户名
     * @return 指定的用户。
     */
    @RequestMapping(value = "user/{name}", method = RequestMethod.GET)
    public List<User> getUser(@PathVariable String name) {
        return mapper.findUserByName(name);
    }

    /**
     * 取得超出指定年龄的用户。
     * @param age 年龄
     * @return 指定的用户
     */
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public List<User> getOlderUser(@RequestParam(value = "older") int age) {
        return mapper.findUserOlder(age);
    }

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 操作结果
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public Success updateUser(@RequestBody User user) {
        mapper.updateUser(user);
        return new Success();
    }

    /**
     * 删除用户
     * @param id 用户ID
     * @return 操作结果
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public Success deleteUser(@PathVariable int id) {
        mapper.deleteUser(id);
        return new Success();
    }
}
