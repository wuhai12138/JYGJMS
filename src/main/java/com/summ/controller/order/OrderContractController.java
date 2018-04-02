package com.summ.controller.order;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.summ.controller.basic.AutoMapperController;
import com.summ.model.*;
import com.summ.model.request.OrderContractReq;
import com.summ.model.response.ModelRes;
import com.summ.model.response.OrderContractRes;
import com.summ.utils.JsonUtil;
import com.summ.utils.NannyWorkTimeUtil;
import com.summ.utils.ResponseUtil;
import com.summ.utils.SendSMSUtil;
import com.summ.utils.mongodb.MongoDBUtil;
import com.summ.utils.mongodb.model.MongoConfig;
import com.sun.org.apache.regexp.internal.RE;
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
 * 合同订单
 *
 * @author jygj_7500
 * @date 18/1/11
 */
@Controller
@RequestMapping("/order/contract")
public class OrderContractController extends AutoMapperController{

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JOrderContract jOrderContract,@RequestBody Map mapService, ServletRequest request) {
        try {

            /**添加或更新服务计划书*/
            JCustomerHouse jCustomerHouse = jCustomerHouseMapper.selectById(Long.valueOf(jOrderContract.getHouseId()));
            JCustomerService jCustomerService = new JCustomerService();
            //如果该房产已有服务计划书，则更新该计划书
            if (jCustomerHouse.getServiceId()!=0){
                jCustomerService.setServiceId(jCustomerHouse.getServiceId());
            }
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            jCustomerService.setAdminId(jAdmin.getAdminId());
            jCustomerService.setCustomerId(jOrderContract.getCustomerId());
            jCustomerService.setHouseId(jOrderContract.getHouseId());
            jCustomerService.setShopId(jOrderContract.getShopId());

            //将服务计划书简略信息存入mysql，详细信息存入mongodb
            Map mapJson = JsonUtil.json2Map((String) mapService.get("serviceDetail"));
            List<Map> weeks = (List<Map>) mapJson.get("weekListTime");
            List<Map> times = (List<Map>) mapJson.get("addTime");
            StringBuffer stringBufferServiceDetail = new StringBuffer();
            Map<String,List<String>> serviceDetailMap = new HashedMap();
            List weekList = new ArrayList();
            for (int i=0;i<weeks.size();i++){
                if ("true".equals(weeks.get(i).get("active").toString())){
                    if ("周一".equals(weeks.get(i).get("value").toString())){
                        weekList.add("周一");
                        stringBufferServiceDetail.append("周一,");
                    }
                    if ("周二".equals(weeks.get(i).get("value").toString())){
                        weekList.add("周二");
                        stringBufferServiceDetail.append("周二,");
                    }
                    if ("周三".equals(weeks.get(i).get("value").toString())){
                        weekList.add("周三");
                        stringBufferServiceDetail.append("周三,");
                    }
                    if ("周四".equals(weeks.get(i).get("value").toString())){
                        weekList.add("周四");
                        stringBufferServiceDetail.append("周四,");
                    }
                    if ("周五".equals(weeks.get(i).get("value").toString())){
                        weekList.add("周五");
                        stringBufferServiceDetail.append("周五,");
                    }
                    if ("周六".equals(weeks.get(i).get("value").toString())){
                        weekList.add("周六");
                        stringBufferServiceDetail.append("周六,");
                    }
                    if ("周天".equals(weeks.get(i).get("value").toString())){
                        weekList.add("周天");
                        stringBufferServiceDetail.append("周日,");
                    }
                }
            }
            serviceDetailMap.put("week",weekList);
            List timeList = new ArrayList();
            for (int i=0;i<times.size();i++){
                stringBufferServiceDetail.append(NannyWorkTimeUtil.id2Time((Integer) times.get(i).get("startId")));
                stringBufferServiceDetail.append("-");
                stringBufferServiceDetail.append(NannyWorkTimeUtil.id2Time((Integer) times.get(i).get("endId")));
                stringBufferServiceDetail.append(",");
            }
            jCustomerService.setServiceDetail(stringBufferServiceDetail.toString());

            /**如果有服务计划书则更新 否则新增*/
            if (jCustomerHouse.getServiceId()!=0){
                jCustomerServiceMapper.updateSelectiveById(jCustomerService);
            }else {
                jCustomerServiceMapper.insert(jCustomerService);
            }

            Map map = new HashedMap();
            map.put("serviceDetail",(String) mapService.get("serviceDetail"));
            map.put("serviceId",jCustomerService.getServiceId());
            System.out.println("map>>>>>>>>>>>>>>>>>>>" + map.toString());
            mongoDBUtil = MongoDBUtil.getInstance(mongoConfig);
            /**如果有服务计划书则更新 否则新增*/
            if (jCustomerHouse.getServiceId()!=0){
                Map serviceIdMap = new HashMap();
                serviceIdMap.put("serviceId",jCustomerService.getServiceId());
                mongoDBUtil.delete("customer_service",serviceIdMap);
                mongoDBUtil.insert(map,"customer_service");
            }else {
                mongoDBUtil.insert(map,"customer_service");
            }

//            Map map = new HashMap();
//            map.put("houseId",jOrderContract.getHouseId());
//            List<JCustomerService> jCustomerServiceList = jCustomerServiceMapper.selectByMap(map);
//            if (jCustomerServiceList.size()==0){
//                return new ModelRes(ModelRes.Status.ERROR, "服务计划书不存在！");
//            }
//            JCustomerService jCustomerService = jCustomerServiceList.get(0);
            jOrderContract.setServiceId(jCustomerService.getServiceId());
            jOrderContract.setOrderStatus(138);
            jOrderContractMapper.insert(jOrderContract);
            /**发送短信给门店手机号*/
            JShop jShop = jShopMapper.selectById(Long.valueOf(jOrderContract.getShopId()));
            JCustomer jCustomer = jCustomerMapper.selectById(Long.valueOf(jOrderContract.getCustomerId()));
            SendSMSUtil.notifyShop(jCustomer.getCustomerPhone(),jShop.getShopMobile(),jCustomer.getCustomerName());
            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody OrderContractReq orderContractReq, ServletRequest request) {
        try {
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            orderContractReq.setAdminId(jAdmin.getAdminId());
            orderContractReq.setPage(orderContractReq.getSize() * (orderContractReq.getPage() - 1));
            List<OrderContractRes> orderContractResList = jOrderContractMapper.getContractList(orderContractReq);
            Map map = ResponseUtil.List2Map(orderContractResList);
            map.put("count",jOrderContractMapper.getContractCount(orderContractReq));
            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !",map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody JOrderContract jOrderContract) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !", jOrderContractMapper.updateSelectiveById(jOrderContract));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/goods/find")
    public Object findGoods(@RequestBody OrderContractReq orderContractReq) {
        try {
            Map map = new HashMap();
            map.put("orderType",163);
            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !", ResponseUtil.List2Map(jGoodsContractMapper.selectByMap(map)));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

}
