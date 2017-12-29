package com.summ.controller;

import com.alibaba.fastjson.JSON;
import com.summ.mapper.JAdminMapper;
import com.summ.mapper.JStreetMapper;
import com.summ.model.JAdmin;
import com.summ.model.JStreet;
import com.summ.model.request.TestReq;
import com.summ.model.response.ModelRes;
import com.summ.utils.JsonUtil;
import com.summ.utils.RequestUtil;
import com.summ.utils.StringUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.List;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jygj_7500 on 17/11/8.
 */
@Controller
public class TestController {

    @Autowired
    private JAdminMapper jAdminMapper;
    @Autowired
    private JStreetMapper jStreetMapper;

    @RequestMapping(value = "/test")
    @ResponseBody
    public Object getAdminById(@RequestBody TestReq req) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "查找订单信息成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "查找订单信息失败");
        }

    }

    /**
     * @param
     * @return
     */
//    @RequestMapping(value = "/test")
//    @ResponseBody
//    public Object getAdminById(@RequestBody TestReq req) {
//        try {
//            int id = req.getId();
//            JAdmin jAdmin = jAdminMapper.getAdminById(id);
//            return new ModelRes(ModelRes.Status.SUCCESS, "查找订单信息成功", jAdmin);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ModelRes(ModelRes.Status.ERROR, "查找订单信息失败");
//        }
//
//    }

//    @RequestMapping(value = "/testOrder")
//    @ResponseBody
//    public Object getTestOrder(@RequestBody TestReq req) {
//        try {
//            Map map = new HashMap();
//            map.put("待生成计划书",4);
//            map.put("预约试工",3);
//            map.put("待生成日程",5);
//            map.put("待签合同",2);
//            Map map1 = new HashMap();
//            map1.put("list",map);
//            return new ModelRes(ModelRes.Status.SUCCESS, "查找订单信息成功", map1);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ModelRes(ModelRes.Status.ERROR, "查找订单信息失败");
//        }
//
//    }

    @RequestMapping(value = "/testPublic")
    @ResponseBody
    public Object getPublicList(@RequestBody TestReq req) {
        try {
            String[] list = {"2017年7月29日 下午13:00 召开管家会议", "2017年7月29日 下午13:00 召开管家会议",
                    "2017年7月29日 下午13:00 召开管家会议", "2017年7月29日 下午13:00 召开管家会议",
                    "2017年7月29日 下午13:00 召开管家会议", "2017年7月29日 下午13:00 召开管家会议"};
            Map map = new HashMap();
            map.put("list", list);
            map.put("count", 6);
            return new ModelRes(ModelRes.Status.SUCCESS, "查找公告信息成功", map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "查找公告信息失败");
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

//    @RequestMapping("/upload")
//    @ResponseBody
//    public void fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request,
//                           HttpServletResponse response) throws IOException {
//
//        System.out.println("file upload");
//        String filePath = null;
//        // 判断文件是否为空
//        if (!file.isEmpty()) {
//            try {
//                Pattern pattern = Pattern.compile("\\.[a-z|A-Z]+$");
//                Matcher matcher = pattern.matcher(file.getOriginalFilename());
//                if (matcher.find()) {
//                    // 文件保存路径
//                    filePath = "C:/Users/jygj_7500/Desktop/upload/" + System.currentTimeMillis() +
//                            matcher.group(0);
////                    filePath = "/opt/data/source/uploaded/" + System.currentTimeMillis() + matcher.group(0);
//                } else {
//                    response.getOutputStream().print("{\"code\":\"2\"}");
//                    return;
//                }
//
//                // 转存文件
//                file.transferTo(new File(filePath));
//            } catch (Exception e) {
//                e.printStackTrace();
//                response.getOutputStream().print("{\"code\":\"1\"}");
//                return;
//            }
//        } else {
//            response.getOutputStream().print("{\"code\":\"2\"}");
//            return;
//        }
//        response.getOutputStream().print("{\"code\":\"0\",\"data\":\"" + filePath + "\"}");
//    }

}
