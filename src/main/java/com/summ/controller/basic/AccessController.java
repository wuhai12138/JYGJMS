package com.summ.controller.basic;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.summ.mapper.JAccessMapper;
import com.summ.model.JAccess;
import com.summ.model.JAdmin;
import com.summ.model.response.ModelRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jygj_7500 on 17/11/22.
 */
@Controller
@RequestMapping("/access")
public class AccessController {

    @Autowired
    private JAccessMapper jAccessMapper;

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JAccess jAccess){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"add access success !",jAccessMapper.insert(jAccess));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestBody JAccess jAccess){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"delete access success !",jAccessMapper.deleteSelective(jAccessMapper.selectOne(jAccess)));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody JAccess jAccess){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"update access success !",jAccessMapper.updateById(jAccess));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody JAccess jAccess){
        try {
            EntityWrapper<JAccess> entityWrapper = null;
            return new ModelRes(ModelRes.Status.SUCCESS,"search administrator success !",jAccessMapper.selectList(entityWrapper));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }



}