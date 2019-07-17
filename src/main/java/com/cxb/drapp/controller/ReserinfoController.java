package com.cxb.drapp.controller;

import com.cxb.drapp.mapper.UserMapper;
import com.cxb.drapp.pojo.Doctor;
import com.cxb.drapp.pojo.Reserinfo;
import com.cxb.drapp.pojo.User;
import com.cxb.drapp.service.DoctorService;
import com.cxb.drapp.service.ReserinfoService;
import com.cxb.drapp.service.UserService;
import com.cxb.drapp.service.impl.DoctorServiceImpl;
import com.sun.deploy.net.HttpResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class ReserinfoController {
    @Autowired
    ReserinfoService reserinfoService;
    @Autowired
    UserService userService;
    @Autowired
    DoctorService doctorService;

    @RequestMapping("reserinfo_recv")
    public void reserinfo_rev(HttpServletRequest request, HttpServletResponse response) throws IOException {
        InputStreamReader reader=new InputStreamReader(request.getInputStream(),"UTF-8");
        char [] buff=new char[1024];
        int length=0;
        Reserinfo reserinfo=new Reserinfo();
        while((length=reader.read(buff))!=-1){
            String x=new String(buff,0,length);
            JSONObject jsonObject = JSONObject.fromObject(x);
            //JSONArray json = (JSONArray) JSONArray.fromObject(jsonObject);
            System.out.println(jsonObject.get("x"));
            reserinfo.setPid(jsonObject.get("pid").toString());
            reserinfo.setDid(jsonObject.get("did").toString());
            reserinfo.setName(jsonObject.get("name").toString());
            reserinfo.setPhone(jsonObject.get("phone").toString());
            reserinfo.setDate(jsonObject.get("date").toString());
            reserinfo.setTime(jsonObject.get("time").toString());
            reserinfo.setRemarks(jsonObject.get("remarks").toString());
            reserinfo.setIsok(jsonObject.get("isok").toString());
            reserinfoService.add(reserinfo);
        }
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().append("200");//jsonstr返回给请求的值
}
    @RequestMapping("queryByid")
    public String getopenid(String openid,HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user=new User();
        User user1=new User();
        user.setOpenid(openid);
        user1=userService.getbyid(user);
        System.out.println(user1);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        if(user1!=null){
            Map<String, String> map = new HashMap<String, String>();
            map.put("openid", user1.getOpenid());
            map.put("nickname", user1.getNickname());
            map.put("avatar_url", user1.getAvatar_url());
            map.put("userkind", user1.getUserkind());
            map.put("flag", "200");
            JSONArray array_test = new JSONArray();
            array_test.add(map);
            JSONObject jsonObject = JSONObject.fromObject(map);
            response.getWriter().print(jsonObject);
        }else{
            Map<String, String> map = new HashMap<String, String>();
            map.put("flag", "400");
            JSONArray array_test = new JSONArray();
            array_test.add(map);
            JSONObject jsonObject = JSONObject.fromObject(map);
            response.getWriter().print(jsonObject);
        }
        //response.getWriter().append("200");//jsonstr返回给请求的值
      return null;
    }
    @RequestMapping("insertUser")
    public String insert_user(HttpServletRequest request, HttpServletResponse response) throws IOException {
        InputStreamReader reader=new InputStreamReader(request.getInputStream(),"UTF-8");
        char [] buff=new char[1024];
        int length=0;
        User user=new User();
        while((length=reader.read(buff))!=-1){
            String x=new String(buff,0,length);
            JSONObject jsonObject = JSONObject.fromObject(x);
            //JSONArray json = (JSONArray) JSONArray.fromObject(jsonObject);
            System.out.println(jsonObject.get("x"));
            user.setOpenid(jsonObject.get("openid").toString());
            user.setNickname(jsonObject.get("nickname").toString());
            user.setAvatar_url(jsonObject.get("avatar_url").toString());
            user.setUserkind(jsonObject.get("userkind").toString());
            System.out.println(user+"1111111111111111111111111111111111111");
            userService.insert(user);
        }
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().append("200");//jsonstr返回给请求的值
        return null;
    }
    @RequestMapping("getreserinfo")
    public String getReserinfo(Reserinfo reserinfo,HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(reserinfo);
        List<Reserinfo> listres=reserinfoService.patientlist(reserinfo);
        System.out.println(listres);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().append(JSONArray.fromObject(listres).toString());//jsonstr返回给请求的值
        return null;
    }
    @RequestMapping("getreserinfo_d")
    public String getPatientReserinfo(Reserinfo reserinfo,HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(reserinfo);
        List<Reserinfo> listres=reserinfoService.doctorlist(reserinfo);
        System.out.println(listres);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().append(JSONArray.fromObject(listres).toString());//jsonstr返回给请求的值
        return null;
    }
    @RequestMapping("getreserinfo_ok")
    public String getPatientReserinfo_ok(Reserinfo reserinfo,HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(reserinfo);
        List<Reserinfo> listres=reserinfoService.doctorlist_ok(reserinfo);
        System.out.println(listres);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().append(JSONArray.fromObject(listres).toString());//jsonstr返回给请求的值
        return null;
    }
    @RequestMapping("editdoctorinfo")
    public String editdoctorinfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        InputStreamReader reader=new InputStreamReader(request.getInputStream(),"UTF-8");
        char [] buff=new char[1024];
        int length=0;
        Doctor doctor=new Doctor();
        while((length=reader.read(buff))!=-1){
            String x=new String(buff,0,length);
            JSONObject jsonObject = JSONObject.fromObject(x);
            //JSONArray json = (JSONArray) JSONArray.fromObject(jsonObject);
            System.out.println(jsonObject.get("x"));
            doctor.setDid(jsonObject.get("did").toString());
            doctor.setHospital(jsonObject.get("hospital").toString());
            doctor.setName(jsonObject.get("name").toString());
            doctor.setDepartments(jsonObject.get("departments").toString());
            doctor.setTitle(jsonObject.get("title").toString());
            doctor.setD_info(jsonObject.get("d_info").toString());
            doctorService.update(doctor);
        }

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().append("200");//jsonstr返回给请求的值
        return null;
    }
    @RequestMapping("insert_ok")
    public String insert_ok(Reserinfo reserinfo, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //request.setCharacterEncoding("utf-8");
        System.out.println(reserinfo);
        reserinfoService.update(reserinfo);
        List<Reserinfo> listres=reserinfoService.doctorlist_ok(reserinfo);
        System.out.println(listres);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().append(JSONArray.fromObject(listres).toString());//jsonstr返回给请求的值
        return null;
    }
}
