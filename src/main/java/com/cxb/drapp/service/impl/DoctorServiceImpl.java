package com.cxb.drapp.service.impl;

import com.cxb.drapp.mapper.DoctorMapper;
import com.cxb.drapp.pojo.Doctor;
import com.cxb.drapp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorMapper doctorMapper;
    @Override
    public void update(Doctor doctor) {
        doctorMapper.updateByPrimaryKey(doctor);
    }
}
