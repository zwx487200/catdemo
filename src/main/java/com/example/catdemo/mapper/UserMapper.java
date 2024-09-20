package com.example.catdemo.mapper;

import com.example.catdemo.entity.User;
import org.apache.ibatis.annotations.*;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhanhuibin
 * @since 2024-09-23
 */
@Mapper
public interface UserMapper {
    @Insert(value = "insert into user(userId, username, status, password,createTime) values (#{user.userId},#{user.username},#{user.status},#{user.password},#{user.createTime})")
    void addUser(@Param("user") User user);

    @Update("Update user set password = (#{password})  where username = (#{username})")
    void updatePassword(String username, String password);

    @Delete("DELETE FROM user WHERE username = #{username}")
    void deleteUserByUsername(String username);

    void updateUserInfo(User user);

    //void deleteUser(String username);

    @Select("Select count(*) from User where username = #{username}" )
    int getCountbyUser(String username);

    @Select("Select * from User where username = #{username}" )
    User getUserDetailsByUsername(String username);

    User getUserDetails(String userId);
}
