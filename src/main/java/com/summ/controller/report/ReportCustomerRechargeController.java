package com.summ.controller.report;

import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JAdmin;
import com.summ.model.request.CustomerStatmentReq;
import com.summ.model.request.ReportCustomerRechargeReq;
import com.summ.model.request.ScheduleReq;
import com.summ.model.response.CustomerBalanceWarnRes;
import com.summ.model.response.CustomerStatmentRes;
import com.summ.model.response.ModelRes;
import com.summ.model.response.ReportCustomerRechargeRes;
import com.summ.utils.JsonUtil;
import com.summ.utils.ResponseUtil;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 客户充值报表
 * @author jygj_7500
 */
@Controller
@RequestMapping("/report/customer")
public class ReportCustomerRechargeController extends AutoMapperController{

    @ResponseBody
    @RequestMapping("/recharge/list")
    public Object find(@RequestBody ReportCustomerRechargeReq reportCustomerRechargeReq, ServletRequest request) {
        try {
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            reportCustomerRechargeReq.setAdminId(jAdmin.getAdminId());
            reportCustomerRechargeReq.setPage(reportCustomerRechargeReq.getSize() * (reportCustomerRechargeReq.getPage() - 1));


            Map<String, Object> map = new HashedMap();
            Map map1 = JsonUtil.Obj2Map(reportCustomerRechargeReq);
            map1.put("startDate",new Date((Long) map1.get("startDate")));
            map1.put("endDate",new Date((Long) map1.get("endDate")));

            List<ReportCustomerRechargeRes> list = jCustomerStatmentMapper.getReportCustomerRecharge(map1);
            for (ReportCustomerRechargeRes reportCustomerRechargeRes : list){
                if (reportCustomerRechargeRes==null){
                    list.clear();
                    break;
                }
            }
            return new ModelRes(ModelRes.Status.SUCCESS, "server err !", ResponseUtil.List2Map(list,jCustomerStatmentMapper.getReportCustomerRechargeCount(map1)));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");

        }
    }

    @ResponseBody
    @RequestMapping("/recharge/detail")
    public Object detail(@RequestBody CustomerStatmentReq customerStatmentReq, ServletRequest request) {
        try {
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            customerStatmentReq.setAdminId(jAdmin.getAdminId());
            customerStatmentReq.setPage(customerStatmentReq.getSize() * (customerStatmentReq.getPage() - 1));


            return new ModelRes(ModelRes.Status.SUCCESS, "server err !", ResponseUtil.List2Map(jCustomerStatmentMapper.getCustomerRechargeDetail(customerStatmentReq),jCustomerStatmentMapper.getCustomerRechargeDetailCount(customerStatmentReq)));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");

        }
    }

}
