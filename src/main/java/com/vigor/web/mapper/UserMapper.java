package com.vigor.web.mapper;


import com.vigor.web.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Vigor on 2017/10/20.
 * User 表映射
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> findAllUser();

    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO user(name, age, address) VALUES(#{user.name}, #{user.age}, #{user.address})")
    void insertUser(@Param("user") User user);

    @Update("UPDATE user SET name = #{user.name}, age = #{user.age}, address=#{user.address} WHERE id = #{user.id}")
    void updateUser(@Param("user") User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUser(@Param("id") int deletedId);
}
