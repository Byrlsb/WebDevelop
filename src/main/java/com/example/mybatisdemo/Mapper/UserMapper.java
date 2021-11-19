package com.example.mybatisdemo.Mapper;

import com.example.mybatisdemo.Entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper//指定这是一个操作数据库的mapper
public interface UserMapper {
    List<User> findAll();
}
