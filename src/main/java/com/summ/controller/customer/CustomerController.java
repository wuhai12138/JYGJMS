package com.summ.controller.customer;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.summ.Consts;
import com.summ.controller.basic.AutoMapperController;
import com.summ.model.*;
import com.summ.model.request.CustomerPagReq;
import com.summ.model.request.CustomerReq;
import com.summ.model.response.ModelRes;
import com.summ.model.response.ShopRes;
import com.summ.utils.*;
import com.summ.utils.mongodb.MongoDBUtil;
import com.summ.utils.mongodb.model.MongoConfig;
import com.sun.imageio.plugins.jpeg.JPEG;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author jygj_7500
 * @date 17/11/20
 */
@Controller
@RequestMapping("/customer")
public class CustomerController extends AutoMapperController {
    /**
     * CRUD for customer
     *
     * @param customerReq
     * @return
     */

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody CustomerReq customerReq,ServletRequest request) {
        try {
            Map<String, Double> baiduMap =BaiduAPIUtil.getLngAndLat("上海市"+customerReq.getHouseAddress());
            if (baiduMap == null){
                return new ModelRes(ModelRes.Status.FAILED, "获取不到该地址，请重新输入 !");
            }

            JCustomer jCustomer = new JCustomer();
            jCustomer.setCustomerName(customerReq.getCustomerName());
            jCustomer.setCustomerSex(customerReq.getCustomerSex());;
            jCustomer.setCustomerPhone(customerReq.getCustomerPhone());
            jCustomer.setRemark(customerReq.getRemark());
            jCustomerMapper.insert(jCustomer);

            JCustomerService jCustomerService=new JCustomerService();
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            jCustomerService.setAdminId(jAdmin.getAdminId());
            jCustomerService.setCustomerId(jCustomer.getCustomerId());
            jCustomerServiceMapper.insert(jCustomerService);
            Map map = new HashedMap();
            map.put("serviceDetail",customerReq.getServiceDetail());
            map.put("serviceId",jCustomerService.getServiceId());
            System.out.println("map>>>>>>>>>>>>>>>>>>>" + map.toString());
            mongoDBUtil = MongoDBUtil.getInstance(mongoConfig);
            mongoDBUtil.insert(map,"customer_service");

            JCustomerHouse jCustomerHouse = new JCustomerHouse();
            jCustomerHouse.setCustomerId(jCustomer.getCustomerId());
            jCustomerHouse.setBedRoom(customerReq.getBedRoom());
            jCustomerHouse.setLivingRoom(customerReq.getLivingRoom());
            jCustomerHouse.setRestRoom(customerReq.getRestRoom());
            jCustomerHouse.setHouseArea(customerReq.getHouseArea());
            jCustomerHouse.setAreaId(customerReq.getAreaId());
            jCustomerHouse.setHouseAddress(customerReq.getHouseAddress());
            jCustomerHouse.setLatitude(baiduMap.get("lat"));
            jCustomerHouse.setLongitude(baiduMap.get("lng"));
            jCustomerHouse.setServiceId(jCustomerService.getServiceId());
            jCustomerHouseMapper.insert(jCustomerHouse);

            List<JShop> shopList = jShopMapper.getShopList();
            List<JShop> shopListRes = new ArrayList<JShop>();
            for (JShop jShop: shopList){
                double distance =BaiduAPIUtil.getDistance(jCustomerHouse.getLongitude(),jCustomerHouse.getLatitude(),jShop.getLongitude(),jShop.getLatitude());
                if(distance<2000){
                    jShop.setDistance((int)distance);
                    shopListRes.add(jShop);
                }
            }
            Map responseMap = new HashedMap();
            responseMap.put("customerId",jCustomer.getCustomerId());
            responseMap.put("list",shopListRes);
            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !", responseMap);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestBody Map<String, List> jCustomer) {
        try {
            List list = jCustomer.get("customerId");
            System.out.println(">>>>>>>>>>>list>>>>>>>>>>>>" + list);
            return new ModelRes(ModelRes.Status.SUCCESS, "delete customer success !", jCustomerMapper.deleteList(list));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody JCustomer jCustomer) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "update customer success !", jCustomerMapper.updateSelectiveById(jCustomer));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody CustomerPagReq customerPagReq,ServletRequest request) {
        try {
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            customerPagReq.setAdminId(jAdmin.getAdminId());
            customerPagReq.setPage(customerPagReq.getSize() * (customerPagReq.getPage() - 1));
            Map<String, Object> map = new HashedMap();
            map.put("count", jCustomerMapper.getCount(customerPagReq));
            map.put("list", jCustomerMapper.getCustomerList(customerPagReq));
            return new ModelRes(ModelRes.Status.SUCCESS, "search customer success !", map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 客户充值接口
     *
     * @param jCustomerStatment
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/recharge")
    public Object recharge(@RequestBody JCustomerStatment jCustomerStatment, ServletRequest request) {
        try {

            jCustomerStatment.setStatmentCustomer(String.valueOf(System.currentTimeMillis()));
            //获取管理员id
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            jCustomerStatment.setAdminId(jAdmin.getAdminId());
            //对账单类型为充值，38
            jCustomerStatment.setStatmentCustomerType(38);
            //如果是现金或者刷卡充值则直接修改余额，无需等待支付公司回调。
            if (jCustomerStatment.getChargeWay() == Consts.card || jCustomerStatment.getChargeWay() == Consts.cash) {
                //获取用户余额
                BigDecimal balance = jCustomerMapper.selectById(Long.valueOf(jCustomerStatment.getCustomerId())).getCustomerBalance();
                //更新余额
                JCustomer jCustomer = new JCustomer();
                jCustomer.setCustomerId(jCustomerStatment.getCustomerId());
                jCustomer.setCustomerBalance(balance.add(jCustomerStatment.getChargeMoney()));
                jCustomerMapper.updateSelectiveById(jCustomer);
                //新增對賬單，状态为充值成功
                jCustomerStatment.setStatus(53);
                jCustomerStatment.setBalance(balance.add(jCustomerStatment.getChargeMoney()));
                return new ModelRes(ModelRes.Status.SUCCESS, "search customer success !", jCustomerStatmentMapper.insert(jCustomerStatment));
            }
            //对账单状态为充值中，128
            jCustomerStatment.setStatus(128);
            return new ModelRes(ModelRes.Status.SUCCESS, "search customer success !", jCustomerStatmentMapper.insert(jCustomerStatment));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 客户提现接口
     *
     * @param jCustomerStatment
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/cash")
    public Object cash(@RequestBody JCustomerStatment jCustomerStatment, ServletRequest request) {
        try {
            jCustomerStatment.setStatmentCustomer(String.valueOf(System.currentTimeMillis()));
            //获取管理员id
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            jCustomerStatment.setAdminId(jAdmin.getAdminId());
            //对账单状态为提现中，129
            jCustomerStatment.setStatus(129);
            //对账单类型为提现，41
            jCustomerStatment.setStatmentCustomerType(41);
            return new ModelRes(ModelRes.Status.SUCCESS, "search customer success !", jCustomerStatmentMapper.insert(jCustomerStatment));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
}
