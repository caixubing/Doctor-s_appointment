package com.cxb.drapp.mapper;

import com.cxb.drapp.pojo.Doctor;
import com.cxb.drapp.pojo.User;

public interface UserMapper {
    public void insert(User record);
    public User getbyid(User record);
}
