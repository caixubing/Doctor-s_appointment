package com.cxb.drapp.test;

import com.cxb.drapp.pojo.Reserinfo;
import com.cxb.drapp.pojo.User;
import com.cxb.drapp.service.ReserinfoService;
import com.cxb.drapp.service.UserService;
import com.cxb.drapp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;


import java.awt.print.Book;
import java.util.List;

import org.junit.Test;

import javax.annotation.Resource;

public class BookDaoTest extends BaseTest {

        //注入
        @Resource
        ReserinfoService reserinfoServiceImpl;
        @Resource
        UserService userService;
        //查询数据测试
        @Test
        public void list( ){
                Reserinfo reserinfo=new Reserinfo();
                reserinfo.setPid("oOUeB4u-b37IcO33I0LKyOq64Bp8");
                List<Reserinfo> reserinfos=reserinfoServiceImpl.patientlist(reserinfo);
                for(Reserinfo res:reserinfos){
                        System.out.println(res.toString());
                }
        }
        @Test
        public void get( ){
                User user=new User();
                user.setOpenid("10086");
                User user1= userService.getbyid(user);
                System.out.println(user1);
        }
        @Test
        public void add( ){
                /*List<Reserinfo> reserinfos=reserinfoServiceImpl.list();
                for(Reserinfo res:reserinfos){
                        reserinfoServiceImpl.add(res);
                }*/
        }
}
