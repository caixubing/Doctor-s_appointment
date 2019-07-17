package com.cxb.drapp.service;

import com.cxb.drapp.pojo.Reserinfo;

import java.util.List;

public interface ReserinfoService {
    int update(Reserinfo reserinfo);

    void add(Reserinfo reserinfo);
    List<Reserinfo> patientlist(Reserinfo reserinfo);   //patient获取预约信息
    List<Reserinfo> doctorlist(Reserinfo reserinfo);   //doctor获取预约信息

    List<Reserinfo> doctorlist_ok(Reserinfo reserinfo);
}
