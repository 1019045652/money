package com.an.an_be.service.impl;

import com.an.an_be.entity.User;
import com.an.an_be.mapper.UserMapper;
import com.an.an_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUser(User user) {
        return userMapper.findUser(user);
    }
}
