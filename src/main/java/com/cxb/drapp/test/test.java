package com.cxb.drapp.test;

import com.cxb.drapp.pojo.Reserinfo;
import com.cxb.drapp.service.ReserinfoService;
import org.apache.taglibs.standard.tag.el.core.ForEachTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

public class test {

    @Autowired
    ReserinfoService reserinfoService;

    @Test
    public void list( ){
       /* List<Reserinfo>  reserinfos=reserinfoService.list();
        for(Reserinfo res:reserinfos){
            System.out.println(res.toString());
        }*/
    }
}
