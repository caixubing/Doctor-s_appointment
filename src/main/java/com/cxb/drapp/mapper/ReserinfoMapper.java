package com.cxb.drapp.mapper;

import com.cxb.drapp.pojo.Reserinfo;
import com.cxb.drapp.pojo.ReserinfoExample;
import java.util.List;

public interface ReserinfoMapper {
    List<Reserinfo> doctorlist(Reserinfo reserinfo);

    List<Reserinfo> patientlist(Reserinfo reserinfo);

    int deleteByPrimaryKey(Integer id);

    int insert(Reserinfo record);

    int insertSelective(Reserinfo record);

    List<Reserinfo> selectByExample(ReserinfoExample example);

    Reserinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Reserinfo record);

    int updateByPrimaryKey(Reserinfo record);

    List<Reserinfo> doctorlist_ok(Reserinfo reserinfo);
}