package com.example.mybatisdemo.Service.impl;

import com.example.mybatisdemo.Entity.User;
import com.example.mybatisdemo.Mapper.UserMapper;
import com.example.mybatisdemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceimpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
