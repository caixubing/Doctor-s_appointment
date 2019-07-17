package com.cxb.drapp.service;

import com.cxb.drapp.pojo.User;

public interface UserService {
    public User getbyid(User user);
    public void insert(User user);
}
