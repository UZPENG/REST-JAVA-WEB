package com.uzpeng.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author serverliu on 2018/3/2.
 */
public interface UserMapper {
    @Select("SELECT count(*) FROM user WHERE email=#{email}")
    boolean checkEmail(@Param("email")String  email);

    @Insert("INSERT INTO user(name,password,email) VALUES(#{userName},#{password},{email})")
    void registerUser(@Param("userName")String name, @Param("password")String password, @Param("email") String email);
}
