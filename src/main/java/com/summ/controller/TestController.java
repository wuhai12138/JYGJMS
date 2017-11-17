package com.summ.controller;

import com.summ.mapper.JAdminMapper;
import com.summ.model.JAdmin;
import com.summ.model.request.TestReq;
import com.summ.model.response.ModelRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.util.Map;

/**
 * Created by jygj_7500 on 17/11/8.
 */
@Controller
public class TestController {

    @Autowired
    private JAdminMapper jAdminMapper;

    /**
     * @param
     * @return
     */
    @RequestMapping(value = "/test")
    @ResponseBody
    public Object getAdminById(@RequestBody TestReq req){
        try {
            int id = req.getId();
            JAdmin jAdmin = jAdminMapper.getAdminById(id);
            return new ModelRes(ModelRes.Status.SUCCESS,"查找管理员信息成功",jAdmin);
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR,"查找管理员信息失败");
        }

    }
}
