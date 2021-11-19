package com.example.mybatisdemo.Service;

import com.example.mybatisdemo.Entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
