package com.summ.controller.customer;

import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JCouponList;
import com.summ.model.request.CustomerCouponReq;
import com.summ.model.response.ModelRes;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jygj_7500
 * @date 17/11/28
 */
@Controller
@RequestMapping("/customer/coupon")
public class CustomerCouponController extends AutoMapperController{

    /**
     * CRUD for customer coupon
     * @param
     * @return
     */

//    @ResponseBody
//    @RequestMapping("/list")
//    public Object insert(@RequestBody Map<String,Integer> map){
//        try {
//            Map couponMap = new HashMap();
//
//            couponMap.put("list",jCouponMapper.getCouponList(map.get("couponOrigin"),map.get("couponName")));
//            return new ModelRes(ModelRes.Status.SUCCESS,"操作成功 !",couponMap);
//        }catch (Exception e){
//            e.printStackTrace();
//            return new ModelRes(ModelRes.Status.ERROR, "server err !");
//        }
//    }

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JCouponList jCouponList){
        try {
            System.out.println(">>>>>>>jCouponList>>>>>>>>>"+jCouponList.getCouponStatus());

            return new ModelRes(ModelRes.Status.SUCCESS,"操作成功 !",jCouponListMapper.insertSelective(jCouponList));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestBody Map<String,Integer> map){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"操作成功 !",jCouponListMapper.deleteCoupon(map.get("couponListId")));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody JCouponList jCouponList){
        try {
            JCouponList jCouponList1 = jCouponListMapper.selectById(Long.valueOf(jCouponList.getCouponListId()));
            System.out.println("<<<<<CouponStatus<<<<<<<"+jCouponList1.getCouponStatus());
            jCouponList.setCouponStatus(jCouponList1.getCouponStatus());
            return new ModelRes(ModelRes.Status.SUCCESS,"操作成功 !",jCouponListMapper.updateSelectiveById(jCouponList));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody CustomerCouponReq customerCouponReq){
        try {
            customerCouponReq.setPage((customerCouponReq.getPage()-1)*customerCouponReq.getSize());
            Map<String,Object> mapList = new HashedMap();
            mapList.put("list",jCouponListMapper.getListById(customerCouponReq));
            mapList.put("count",jCouponListMapper.getCount(customerCouponReq));
            return new ModelRes(ModelRes.Status.SUCCESS,"操作成功 !",mapList);
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

}
