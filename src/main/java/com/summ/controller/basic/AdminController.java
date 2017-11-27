package com.summ.controller.basic;

import com.summ.mapper.JAdminMapper;
import com.summ.model.JAdmin;
import com.summ.model.request.PaginateReq;
import com.summ.model.response.AccessRes;
import com.summ.model.response.ModelRes;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jygj_7500 on 17/11/20.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private JAdminMapper jAdminMapper;

    @ResponseBody
    @RequestMapping("/login")
    public Object login(@RequestBody JAdmin admin){
        try {
            Map map1 = new HashMap();
            map1.put("adminName",admin.getAdminName());
            JAdmin jAdmin = (JAdmin) jAdminMapper.selectByMap(map1).get(0);
            Map map = new HashMap();
            map.put("accessList",jAdminMapper.getAccess(jAdmin.getAdminId()));
            map.put("admin",jAdmin);
            if(jAdmin.getAdminPassword().equals(admin.getAdminPassword()) ){
                return new ModelRes(ModelRes.Status.SUCCESS,"login success !",map);
            }else {
                return new ModelRes(ModelRes.Status.FAILED,"login failed !");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err ! ");
        }
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JAdmin jAdmin){
        try {
            Map map = new HashMap();
            map.put("adminName",jAdmin.getAdminName());
            if(jAdminMapper.selectByMap(map).size()>0){
                return new ModelRes(ModelRes.Status.FAILED, "admin name is used !");
            }else {
                return new ModelRes(ModelRes.Status.SUCCESS,"add administrator success !",jAdminMapper.insert(jAdmin));
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody JAdmin jAdmin){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"update administrator success !",jAdminMapper.updateById(jAdmin));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody PaginateReq paginateReq){
        try {
            paginateReq.setPage(paginateReq.getSize() * (paginateReq.getPage()-1));
            Map<String,Object> map = new HashedMap();
            map.put("count",jAdminMapper.getCount());
            map.put("list",jAdminMapper.getAdminList(paginateReq));
            return new ModelRes(ModelRes.Status.SUCCESS,"search administrator success !",map);
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestBody JAdmin jAdmin){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"delete administrator success !",jAdminMapper.deleteAdmin(jAdmin.getAdminId()));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
}
