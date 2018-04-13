package com.summ.controller.goods;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JGoodsContract;
import com.summ.model.JGoodsCost;
import com.summ.model.JLeaguer;
import com.summ.model.request.GoodsReq;
import com.summ.model.response.ModelRes;
import com.summ.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 产品管理
 * @author jygj_7500
 */
@Controller
@RequestMapping("/goods")
public class GoodsController extends AutoMapperController{

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JGoodsContract jGoodsContract) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "insert customer house info success !", jGoodsContractMapper.insertSelective(jGoodsContract));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody GoodsReq map) {
        try {
            map.setPage(map.getSize() * (map.getPage() - 1));
            return new ModelRes(ModelRes.Status.SUCCESS, "insert customer house info success !", ResponseUtil.List2Map(jGoodsContractMapper.getGoodsList(map),jGoodsContractMapper.getGoodsListCount(map)));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 更新产品信息，上下架产品
     * @param jGoodsContract
     * @return
     */
    @ResponseBody
    @RequestMapping("/putaway")
    public Object putaway(@RequestBody JGoodsContract jGoodsContract) {
        try {
            JGoodsContract jGoodsContract1 = jGoodsContractMapper.selectById(Long.valueOf(jGoodsContract.getGoodsId()));
            if (jGoodsContract1.getIsDel()==17){
                jGoodsContract.setIsDel(16);
                return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !", jGoodsContractMapper.updateSelectiveById(jGoodsContract));
            }else {
                jGoodsContract.setIsDel(17);
                return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !", jGoodsContractMapper.updateSelectiveById(jGoodsContract));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 更新产品信息
     * @param jGoodsContract
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody JGoodsContract jGoodsContract) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "insert customer house info success !", jGoodsContractMapper.updateSelectiveById(jGoodsContract));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 获取产品成本列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/cost/find")
    public Object findCost(@RequestBody Map map) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "insert customer house info success !", ResponseUtil.List2Map(jGoodsContractMapper.getGoodsCostList((Integer) map.get("goodsId"))));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 查询某个供应商的产品列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/supplier/find")
    public Object findByShop(@RequestBody Map map) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "insert customer house info success !", ResponseUtil.List2Map(jGoodsContractMapper.getGoodsListBySupplier((Integer) map.get("supplierId"))));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 给某个供应商添加产品
     * @param jGoodsCost
     * @return
     */
    @ResponseBody
    @RequestMapping("/supplier/insert")
    public Object insertByShop(@RequestBody JGoodsCost jGoodsCost) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "insert customer house info success !", jGoodsCostMapper.insertSelective(jGoodsCost));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/supplier/update")
    public Object updateByShop(@RequestBody JGoodsCost jGoodsCost) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "insert customer house info success !", jGoodsCostMapper.updateSelectiveById(jGoodsCost));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/supplier/delete")
    public Object deleteByShop(@RequestBody JGoodsCost jGoodsCost) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "insert customer house info success !", jGoodsCostMapper.deleteSelective(jGoodsCost));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }


}
