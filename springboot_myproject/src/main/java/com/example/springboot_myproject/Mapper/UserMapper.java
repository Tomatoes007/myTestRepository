package com.example.springboot_myproject.Mapper;

import com.example.springboot_myproject.Model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    //新增用户
    @Insert("INSERT INTO user(email,password,salt,confirmcode,activationtime,isvalid) VALUES(#{email},#{password},#{salt},#{confirmCode},#{activationTime},#{isValid})")
    int insertUser(User user);

    //根据状态码查询用户
    @Select("SELECT email,activationtime FROM user WHERE confirmcode = #{confirmCode}")
    User selectByConfirmCode(@Param("confirmCode")String confirmCode);

    //根据状态码查询用户，设置状态码为1
    @Update("UPDATE user SET isValid = 1 WHERE confirmcode = #{confirmCode}")
    int updateUserByConfirmCode(@Param("confirmCode")String confirmCode);

    //登录
    @Select("SELECT email,password,salt FROM user WHERE email=#{email} AND isvalid=1")
    List<User> selectUserByEmail(@Param("email") String email);
}
