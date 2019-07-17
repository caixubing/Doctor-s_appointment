package com.cxb.drapp.service.impl;

import com.cxb.drapp.mapper.ReserinfoMapper;
import com.cxb.drapp.mapper.UserMapper;
import com.cxb.drapp.pojo.User;
import com.cxb.drapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getbyid(User user) {
        return userMapper.getbyid(user);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }
}
