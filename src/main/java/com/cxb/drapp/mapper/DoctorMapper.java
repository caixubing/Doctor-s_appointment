package com.cxb.drapp.mapper;

import com.cxb.drapp.pojo.Doctor;
import com.cxb.drapp.pojo.DoctorExample;
import java.util.List;

public interface DoctorMapper {
    int deleteByPrimaryKey(String did);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    List<Doctor> selectByExample(DoctorExample example);

    Doctor selectByPrimaryKey(String did);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);

}