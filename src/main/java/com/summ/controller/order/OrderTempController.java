package com.summ.controller.order;

import com.summ.controller.basic.AutoMapperController;
import com.summ.mapper.JOrderTempMapper;
import com.summ.model.*;
import com.summ.model.request.OrderContractReq;
import com.summ.model.request.OrderTempChargeReq;
import com.summ.model.request.OrderTempReq;
import com.summ.model.response.ModelRes;
import com.summ.model.response.OrderTempRes;
import com.summ.model.response.PayDataRes;
import com.summ.utils.OrderUtil;
import com.summ.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.math.BigDecimal;
import java.text.Bidi;
import java.util.*;


@Controller
@RequestMapping("/order/temp")
public class OrderTempController extends AutoMapperController{

    /**
     * 新增临时订单
     * @param jOrderTemp
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JOrderTemp jOrderTemp) {
        try {
            JGoodsContract jGoodsContract = jGoodsContractMapper.selectById(Long.valueOf(jOrderTemp.getGoodsId()));
            jOrderTemp.setUnitPrice(jGoodsContract.getPrice());
            jOrderTemp.setTotalPrice(jGoodsContract.getPrice().multiply(new BigDecimal(jOrderTemp.getServiceAmount())));
            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !", jOrderTempMapper.insert(jOrderTemp));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody JOrderTemp jOrderTemp) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !", jOrderTempMapper.updateSelectiveById(jOrderTemp));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 根据订单返回支付信息（客户信息，订单金额，优惠券列表，支付方式）
     * @param orderTempChargeReq
     * @return
     */
    @ResponseBody
    @RequestMapping("/payData")
    public Object payData(@RequestBody OrderTempChargeReq orderTempChargeReq) {
        try {
            /**订单列表*/
            List<JOrderTemp> jOrderTempList = jOrderTempMapper.selectBatchIds(orderTempChargeReq.getOrderList());

            BigDecimal cost = new BigDecimal(0);
            for (JOrderTemp jOrderTemp : jOrderTempList){
                if (!jOrderTemp.getCustomerId().equals(orderTempChargeReq.getCustomerId())){
                    return new ModelRes(ModelRes.Status.FAILED, "有多个客户的订单，请重选 !");
                }else if (jOrderTemp.getPayStatus()==158){
                    return new ModelRes(ModelRes.Status.FAILED, "有订单已支付，请重选 !");
                }
                else {
                    cost = cost.add(jOrderTemp.getTotalPrice());
                }
            }

            JCustomer jCustomer = jCustomerMapper.selectById(Long.valueOf(orderTempChargeReq.getCustomerId()));
            PayDataRes payDataRes = new PayDataRes(jCustomer.getCustomerId(),jCustomer.getCustomerName(),jCustomer.getCustomerPhone(),
                    jCustomer.getCustomerBalance(),cost);

            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !", payDataRes);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/pay")
    public Object pay(@RequestBody OrderTempChargeReq orderTempChargeReq,ServletRequest request) {
        try {
            //获取管理员id
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            Integer adminId = jAdmin.getAdminId();

            /**客户对账单列表*/
            List<JCustomerStatment> jCustomerStatmentList = new ArrayList<JCustomerStatment>();

            /**订单列表*/
            List<JOrderTemp> jOrderTempList = jOrderTempMapper.selectBatchIds(orderTempChargeReq.getOrderList());
            JCoupon jCoupon = jCouponMapper.getCouponByCouponListId(orderTempChargeReq.getCouponListId());
            JCustomer jCustomer = jCustomerMapper.selectById(Long.valueOf(jOrderTempList.get(0).getCustomerId()));
            if (orderTempChargeReq.getCost().compareTo(jCoupon.getCouponPrice()) <0){
                return new ModelRes(ModelRes.Status.FAILED, "订单总额不符合优惠券规范，请重选 !");
            }

            /**判断支付方式是余额还是手机支付*/
            if(orderTempChargeReq.getChargeType()==48){
                /**针对每个订单，更新折扣金额，支付金额，支付状态，优惠券id，新增对账单*/
                for (JOrderTemp jOrderTemp : jOrderTempList){
                    /**更新订单信息*/
                    jOrderTemp.setDiscount(jCoupon.getCouponPrice().multiply(jOrderTemp.getTotalPrice()).divide(orderTempChargeReq.getCost(),2,BigDecimal.ROUND_HALF_UP));
                    jOrderTemp.setPayMoney(jOrderTemp.getTotalPrice().subtract(jOrderTemp.getDiscount()));
                    jOrderTemp.setPayStatus(158);
                    jOrderTemp.setCouponListId(orderTempChargeReq.getCouponListId());

                    String serviceTime = jOrderTemp.getStartTimeValue()+"-"+jOrderTemp.getEndTimeValue();
                    Double serviceTimeLength = Double.valueOf((jOrderTemp.getEndTime() - jOrderTemp.getStartTime()) / 2f);
                    JCustomerStatment jCustomerStatment = new JCustomerStatment(OrderUtil.generateStamentNumber(48,177),
                            jOrderTemp.getCustomerId(),jOrderTemp.getGoodsId(), jOrderTemp.getHouseId(),
                            jOrderTemp.getOrderId(),164,0,
                            jOrderTemp.getShopId(), serviceTime, serviceTimeLength,
                            jOrderTemp.getOrderDate(), new Date(), 177, jOrderTemp.getPayMoney(),
                            48, adminId, 49, 53, jCustomer.getCustomerBalance().subtract(jOrderTemp.getPayMoney()),
                            "", "");
                    /**添加客户对账单*/
                    jCustomerStatmentList.add(jCustomerStatment);
                    /**更新客户余额*/
                    jCustomer.setCustomerBalance(jCustomer.getCustomerBalance().subtract(jOrderTemp.getPayMoney()));
                }
                jCustomerStatmentMapper.insertBatch(jCustomerStatmentList);
                jOrderTempMapper.updateBatchById(jOrderTempList);
                jCustomerMapper.updateSelectiveById(jCustomer);
            }
            /**支付宝*/
            if (orderTempChargeReq.getChargeType()==44){

            }


            return new ModelRes(ModelRes.Status.SUCCESS, "支付成功！" ,null);
        }catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 获取临时订单服务列表
     * @param orderContractReq
     * @return
     */
    @ResponseBody
    @RequestMapping("/goods/find")
    public Object findGoods(@RequestBody OrderContractReq orderContractReq) {
        try {
            Map map = new HashMap();
            map.put("orderType",164);
            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !", ResponseUtil.List2Map(jGoodsContractMapper.selectByMap(map)));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }


    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody OrderTempReq orderTempReq, ServletRequest request) {
        try {
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            orderTempReq.setAdminId(jAdmin.getAdminId());
            orderTempReq.setPage(orderTempReq.getSize() * (orderTempReq.getPage() - 1));
            List<OrderTempRes> orderTempResList = jOrderTempMapper.getTempList(orderTempReq);
            Map map = ResponseUtil.List2Map(orderTempResList);
            map.put("count",jOrderTempMapper.getTempCount(orderTempReq));
            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !",map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

}
