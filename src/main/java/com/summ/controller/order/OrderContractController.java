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

            /**添加服务计划书*/
            JCustomerService jCustomerService = new JCustomerService();
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            jCustomerService.setAdminId(jAdmin.getAdminId());

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
                    }
                    if ("周二".equals(weeks.get(i).get("value").toString())){
                        weekList.add("周二");
                    }
                    if ("周三".equals(weeks.get(i).get("value").toString())){
                        weekList.add("周三");
                    }
                    if ("周四".equals(weeks.get(i).get("value").toString())){
                        weekList.add("周四");
                    }
                    if ("周五".equals(weeks.get(i).get("value").toString())){
                        weekList.add("周五");
                    }
                    if ("周六".equals(weeks.get(i).get("value").toString())){
                        weekList.add("周六");
                    }
                    if ("周天".equals(weeks.get(i).get("value").toString())){
                        weekList.add("周天");
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


            jCustomerServiceMapper.insert(jCustomerService);

            Map map = new HashedMap();
            map.put("serviceDetail",(String) mapService.get("serviceDetail"));
            map.put("serviceId",jCustomerService.getServiceId());
            System.out.println("map>>>>>>>>>>>>>>>>>>>" + map.toString());
            mongoDBUtil = MongoDBUtil.getInstance(mongoConfig);
            mongoDBUtil.insert(map,"customer_service");



//            Map map = new HashMap();
//            map.put("houseId",jOrderContract.getHouseId());
//            List<JCustomerService> jCustomerServiceList = jCustomerServiceMapper.selectByMap(map);
//            if (jCustomerServiceList.size()==0){
//                return new ModelRes(ModelRes.Status.ERROR, "服务计划书不存在！");
//            }
//            JCustomerService jCustomerService = jCustomerServiceList.get(0);
            jOrderContract.setServiceId(jCustomerService.getServiceId());
            jOrderContract.setOrderStatus(138);
            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !", jOrderContractMapper.insert(jOrderContract));
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
