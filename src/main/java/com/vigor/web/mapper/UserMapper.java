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
    List<User> findUserByName(@Param("name") String name);

    // 返回对象的属性和查询结果字段的对应关系映射。
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "address", column = "address")}
    )
    @Select("SELECT * FROM user WHERE age > #{age}")
    List<User> findUserOlder(@Param("age") int age);

    @Insert("INSERT INTO user(name, age, address) VALUES(#{user.name}, #{user.age}, #{user.address})")
    void insertUser(@Param("user") User user);

    @Update("UPDATE user SET name = #{name}, age = #{age}, address=#{address} WHERE id = #{id}")
    void updateUser(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUser(@Param("id") int deletedId);
}
