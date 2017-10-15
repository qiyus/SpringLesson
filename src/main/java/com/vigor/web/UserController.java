package com.vigor.web;

import com.vigor.web.domain.Success;
import com.vigor.web.domain.User;
import com.vigor.web.exception.UserEmptyException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Vigor on 2017/7/19.
 * 用户管理
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 用户集合
     */
    private static final Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    /**
     * 用户列表
     * @return 用户列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getUsers() throws Exception {
        if (users.size() == 0) {
            throw new UserEmptyException("user is empty");
        }
        return new ArrayList<>(users.values());
    }

    /**
     * 追加用户
     * @param user 用户
     * @return 操作结果
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Success addUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return new Success();
    }

    /**
     * 取得指定用户
     * @param id 用户ID
     * @return ID对应的用户。
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable long id) {
        return users.get(id);
    }

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 操作结果
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Success updateUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return new Success();
    }

    /**
     * 删除用户
     * @param id 用户ID
     * @return 操作结果
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Success deleteUser(@PathVariable long id) {
        users.remove(id);
        return new Success();
    }
}
