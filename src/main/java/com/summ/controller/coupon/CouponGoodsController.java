package com.summ.controller.coupon;

import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JAdminType;
import com.summ.model.JCoupon;
import com.summ.model.JCouponGoods;
import com.summ.model.request.CouponReq;
import com.summ.model.response.ModelRes;
import com.summ.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/coupon/goods")
public class CouponGoodsController extends AutoMapperController{

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody Map map) {
        try {
            Integer couponId = (Integer) map.get("couponId");
            List<Integer> goodsIdList = (List<Integer>) map.get("goodsIdList");
            List<JCouponGoods> jCouponGoodsList = new ArrayList<JCouponGoods>();
            for (Integer id : goodsIdList){
                JCouponGoods jCouponGoods = new JCouponGoods();
                jCouponGoods.setCouponId(couponId);
                jCouponGoods.setGoodsId(id);
                jCouponGoodsList.add(jCouponGoods);
            }

            Map map1 = new HashMap();
            map1.put("couponId",couponId);
            jCouponGoodsMapper.deleteByMap(map1);
            jCouponGoodsMapper.insertBatch(jCouponGoodsList);
            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody JCouponGoods jCouponGoods) {
        try {
            Map map = new HashMap();
            map.put("couponId",jCouponGoods.getCouponId());
            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !", ResponseUtil.List2Map(jCouponGoodsMapper.selectByMap(map)));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody JCouponGoods jCouponGoods) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !", jCouponGoodsMapper.updateSelectiveById(jCouponGoods));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestBody JCouponGoods jCouponGoods) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !", jCouponGoodsMapper.deleteSelective(jCouponGoods));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }


}
