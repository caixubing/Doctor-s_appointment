package com.cxb.drapp.mapper;

import com.cxb.drapp.pojo.Patient;
import com.cxb.drapp.pojo.PatientExample;
import java.util.List;

public interface PatientMapper {
    int deleteByPrimaryKey(String pid);

    int insert(Patient record);

    int insertSelective(Patient record);

    List<Patient> selectByExample(PatientExample example);

    Patient selectByPrimaryKey(String pid);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);
}