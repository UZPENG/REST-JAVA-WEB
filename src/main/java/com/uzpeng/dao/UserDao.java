package com.uzpeng.dao;

import com.uzpeng.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author serverliu on 2018/3/2.
 */
@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public boolean checkEmailStatus(String email){
        return userMapper.checkEmail(email);
    }

    public void registerUser(String userName,String password, String email){
        userMapper.registerUser(userName, password, email);
    }

}
