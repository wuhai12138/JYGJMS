package com.summ.controller.shop;

import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JAdmin;
import com.summ.model.JAdminShop;
import com.summ.model.JAdminType;
import com.summ.model.JShop;
import com.summ.model.request.ShopReq;
import com.summ.model.response.ModelRes;
import com.summ.model.response.ShopRes;
import com.summ.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 门店增删改查
 * @author jygj_7500
 */
@Controller
@RequestMapping("/shop")
public class ShopController extends AutoMapperController{

    @ResponseBody
    @RequestMapping("/insert")
    public Object insertShop(@RequestBody JShop jShop,ServletRequest request) {
        try {
            jShopMapper.insertSelective(jShop);
            /**给所有超级管理员添加这个门店权限*/
            Map map = new HashMap();
            map.put("adminTypeId",1);
            List<JAdminType> jAdminTypeList = jAdminTypeMapper.selectByMap(map);
            List<JAdminShop> jAdminShopList = new ArrayList<JAdminShop>();
            for (JAdminType jAdminType : jAdminTypeList){
                JAdminShop jAdminShop = new JAdminShop(jAdminType.getAdminId(),jShop.getShopId());
                jAdminShopList.add(jAdminShop);
            }
            jAdminShopMapper.insertBatch(jAdminShopList);
            return new ModelRes(ModelRes.Status.SUCCESS, "delete administrator success !", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/list")
    public Object findShopList(@RequestBody ShopReq shopReq, ServletRequest request) {
        try {
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            shopReq.setAdminId(jAdmin.getAdminId());
            return new ModelRes(ModelRes.Status.SUCCESS, "delete administrator success !", ResponseUtil.List2Map(jShopMapper.getShopList(shopReq)));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody JShop jShop) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "delete administrator success !", jShopMapper.updateSelectiveById(jShop));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
}
