package com.summ.controller;

import com.summ.mapper.JAdminMapper;
import com.summ.mapper.JStreetMapper;
import com.summ.model.JAdmin;
import com.summ.model.JStreet;
import com.summ.model.request.TestReq;
import com.summ.model.response.ModelRes;
import com.summ.utils.JsonUtil;
import com.summ.utils.RequestUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.util.List;
import java.util.*;

/**
 * Created by jygj_7500 on 17/11/8.
 */
@Controller
public class TestController {

    @Autowired
    private JAdminMapper jAdminMapper;
    @Autowired
    private JStreetMapper jStreetMapper;

    /**
     * @param
     * @return
     */
    @RequestMapping(value = "/test")
    @ResponseBody
    public Object getAdminById(@RequestBody TestReq req) {
        try {
            int id = req.getId();
            JAdmin jAdmin = jAdminMapper.getAdminById(id);
            return new ModelRes(ModelRes.Status.SUCCESS, "查找管理员信息成功", jAdmin);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "查找管理员信息失败");
        }

    }


    @RequestMapping(value = "/road")
    @ResponseBody
    public Object getRoad(@RequestBody Map<String, Integer> map) {
        try {
    String[] list = {"310101.json", "310104.json", "310105.json", "310106.json", "310107.json",
                    "310109.json", "310110.json", "310111.json", "310112.json", "310113.json",
                    "310114.json", "310115.json", "310116.json", "310117.json", "310118.json",
                    "310119.json", "310120.json", "310151.json"};
            Collection collection = new ArrayList();
            Map hashMap = new HashMap();
            hashMap = JsonUtil.json2Map(RequestUtil.doGet("http://passer-by.com/data_location/town/" + list[map.get("json")]));
            collection = hashMap.values();
            int i = 1;
            for (Object object : collection) {
                JStreet jStreet = new JStreet();
                jStreet.setStreetName(object.toString());
//                jStreet.setAreaCode(map.get("areaCode"));
//                jStreet.setStreetCode(map.get("areaCode")+i);
                i++;
//                jStreetMapper.insert(jStreet);

            }
            System.out.println("》》》》》》》》》》》》》》》》》》" + hashMap);


            return new ModelRes(ModelRes.Status.SUCCESS, "查找管理员信息成功", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "查找管理员信息失败");
        }

    }

}
