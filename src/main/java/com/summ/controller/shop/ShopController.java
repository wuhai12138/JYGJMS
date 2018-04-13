package com.summ.controller.shop;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JAdmin;
import com.summ.model.JAdminShop;
import com.summ.model.JAdminType;
import com.summ.model.JShop;
import com.summ.model.request.CustomerReq;
import com.summ.model.request.ShopReq;
import com.summ.model.response.ModelRes;
import com.summ.model.response.ShopRes;
import com.summ.utils.BaiduAPIUtil;
import com.summ.utils.ResponseUtil;
import org.apache.commons.collections.map.HashedMap;
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
            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !", null);
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
            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !", ResponseUtil.List2Map(jShopMapper.getShopList(shopReq)));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody JShop jShop) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !", jShopMapper.updateSelectiveById(jShop));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/all")
    public Object findAll(@RequestBody JShop jShop) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !", jShopMapper.selectList(new EntityWrapper<JShop>()));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 根据地址的经纬度查看该地址与各门店的距离
     * @param customerReq
     * @return
     */
    @ResponseBody
    @RequestMapping("/distance")
    public Object distance(@RequestBody CustomerReq customerReq) {
        try {
            Map<String, Double> baiduMap = BaiduAPIUtil.getLngAndLat("上海市" + customerReq.getHouseAddress());
            if (baiduMap == null) {
                return new ModelRes(ModelRes.Status.FAILED, "获取不到该地址，请重新输入 !");
            }
            List<JShop> shopList = jShopMapper.getAllShop();
            List<JShop> shopListRes = new ArrayList<JShop>();
            for (JShop jShop : shopList) {
                double distance = BaiduAPIUtil.getDistance(baiduMap.get("lng"), baiduMap.get("lat"), jShop.getLongitude(), jShop.getLatitude());
                jShop.setDistance((int) distance);
                shopListRes.add(jShop);
            }
            Map responseMap = new HashedMap();
            responseMap.put("list", shopListRes);

            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !", responseMap);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
}
