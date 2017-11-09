package com.summ.controller;

import com.summ.mapper.AdminMapper;
import com.summ.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jygj_7500 on 17/11/8.
 */
@Controller
public class TestController {
    @Autowired
    private AdminMapper adminMapper;

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(){
        System.out.println("hello !");
        return "Hello World ! admin count :" + adminMapper.getCount();
    }
}
