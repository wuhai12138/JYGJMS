package com.summ.controller.customer;

import com.summ.mapper.JCouponListMapper;
import com.summ.mapper.JCouponMapper;
import com.summ.model.JCoupon;
import com.summ.model.JCouponList;
import com.summ.model.response.ModelRes;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jygj_7500 on 17/11/28.
 */
@Controller
@RequestMapping("/customer/coupon")
public class CustomerCouponController {

    @Autowired
    private JCouponMapper jCouponMapper;
    @Autowired
    private JCouponListMapper jCouponListMapper;

    /**
     * CRUD for customer coupon
     * @param
     * @return
     */

    @ResponseBody
    @RequestMapping("/list")
    public Object insert(@RequestBody Map<String,Integer> map){
        try {
            Map couponMap = new HashMap();
            couponMap.put("list",jCouponMapper.getCouponList(map.get("couponOrigin")));
            return new ModelRes(ModelRes.Status.SUCCESS,"get coupon list success !",couponMap);
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JCouponList jCouponList){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"add coupon to customer success !",jCouponListMapper.insert(jCouponList));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestBody Map<String,Integer> map){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"delete coupon success !",jCouponListMapper.deleteCoupon(map.get("couponListId")));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody JCouponList jCouponList){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"update coupon success !",jCouponListMapper.updateById(jCouponList));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody Map<String, Integer> map){
        try {
            Map<String,Object> mapList = new HashedMap();
            mapList.put("list",jCouponListMapper.getListById(map.get("customerId")));
            return new ModelRes(ModelRes.Status.SUCCESS,"search customer success !",mapList);
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

}
