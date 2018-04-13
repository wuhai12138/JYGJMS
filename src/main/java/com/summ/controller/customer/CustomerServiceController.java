package com.summ.controller.customer;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JAdmin;
import com.summ.model.JCustomer;
import com.summ.model.JCustomerService;
import com.summ.model.response.CustomerServiceRes;
import com.summ.model.response.ModelRes;
import com.summ.utils.JsonUtil;
import com.summ.utils.NannyWorkTimeUtil;
import com.summ.utils.ResponseUtil;
import com.summ.utils.mongodb.MongoDBUtil;
import com.summ.utils.mongodb.log.LogUtil;
import com.summ.utils.mongodb.model.MongoConfig;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.management.counter.perf.PerfInstrumentation;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jygj_7500 on 18/1/5.
 */
@Controller
@RequestMapping("/customer/service")
public class CustomerServiceController extends AutoMapperController{



    /**
     * CRUD for customer service
     * @return
     */
    @ResponseBody
    @RequestMapping("/house/list")
    public Object findServiceHouseList(@RequestBody JCustomerService jCustomerService){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"操作成功 !", ResponseUtil.List2Map(jCustomerServiceMapper.findServiceUnusedHouse(jCustomerService.getCustomerId())));
        } catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find/list")
    public Object findServiceList(@RequestBody JCustomerService jCustomerService){
        try {
            Map map = new HashedMap();
            map.put("customerId",jCustomerService.getCustomerId());
            List<CustomerServiceRes> jCustomerServiceRes = jCustomerServiceMapper.findServiceList(jCustomerService.getCustomerId());
            return new ModelRes(ModelRes.Status.SUCCESS,"操作成功 !", ResponseUtil.List2Map(jCustomerServiceRes));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object findHouse(@RequestBody JCustomerService jCustomerService){
        try {
            CustomerServiceRes jCustomerServiceRes = jCustomerServiceMapper.selectServiceById(jCustomerService.getServiceId());

            Map map = new HashedMap();
            map.put("serviceId",jCustomerService.getServiceId());
            mongoDBUtil = MongoDBUtil.getInstance(mongoConfig);
            jCustomerServiceRes.setServiceDetail(mongoDBUtil.query("customer_service",map));
            return new ModelRes(ModelRes.Status.SUCCESS,"操作成功 !",jCustomerServiceRes);
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Object insertHouse(@RequestBody JCustomerService jCustomerService, ServletRequest request){
        try {
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            jCustomerService.setAdminId(jAdmin.getAdminId());

            //将服务计划书简略信息存入mysql，详细信息存入mongodb
            Map mapJson = JsonUtil.json2Map(jCustomerService.getServiceDetail());
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


            jCustomerServiceMapper.insertSelective(jCustomerService);

            Map map = new HashedMap();
            map.put("serviceDetail",jCustomerService.getServiceDetail());
            map.put("serviceId",jCustomerService.getServiceId());
            System.out.println("map>>>>>>>>>>>>>>>>>>>" + map.toString());
            mongoDBUtil = MongoDBUtil.getInstance(mongoConfig);
            mongoDBUtil.insert(map,"customer_service");
            return new ModelRes(ModelRes.Status.SUCCESS,"操作成功 !",null);
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object deleteHouse(@RequestBody JCustomerService jCustomerService){
        try {
            if("".equals(jCustomerService.getServiceDetail())){
                return new ModelRes(ModelRes.Status.SUCCESS,"操作成功 !",jCustomerServiceMapper.updateSelectiveById(jCustomerService));
            }else {
                Map map = new HashedMap();
                map.put("serviceId",jCustomerService.getServiceId());
                mongoDBUtil = MongoDBUtil.getInstance(mongoConfig);
                mongoDBUtil.delete("customer_service",map);
                map.put("serviceDetail",jCustomerService.getServiceDetail());
                mongoDBUtil.insert("customer_service",map);

                jCustomerService.setServiceDetail("");
                return new ModelRes(ModelRes.Status.SUCCESS,"操作成功 !",jCustomerServiceMapper.updateSelectiveById(jCustomerService));
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 客户确认
     * @param jCustomerService
     * @return
     */
    @ResponseBody
    @RequestMapping("/customer/confirm")
    public Object customerConfirm(@RequestBody JCustomerService jCustomerService){
        try {
                return new ModelRes(ModelRes.Status.SUCCESS,"操作成功 !",jCustomerServiceMapper.updateSelectiveById(jCustomerService));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 管家确认
     * @param jCustomerService
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/confirm")
    public Object adminConfirm(@RequestBody JCustomerService jCustomerService){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"操作成功 !",jCustomerServiceMapper.updateSelectiveById(jCustomerService));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
}
