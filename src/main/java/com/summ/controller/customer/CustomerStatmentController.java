package com.summ.controller.customer;

import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JAdmin;
import com.summ.model.JCustomerStatment;
import com.summ.model.request.CustomerStatmentReq;
import com.summ.model.response.ModelRes;
import com.summ.utils.ExcelUtil;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *
 * @author jygj_7500
 * @date 17/11/29
 */
@Controller
@RequestMapping("/customer/statment")
public class CustomerStatmentController extends AutoMapperController{

    /**
     * CRUD for customer statment
     * @param jCustomerStatment
     * @return
     */

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JCustomerStatment jCustomerStatment, HttpServletRequest request){
        try {
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");

            jCustomerStatment.setAdminId(jAdmin.getAdminId());
            return new ModelRes(ModelRes.Status.SUCCESS,"操作成功!",jCustomerStatmentMapper.insertSelective(jCustomerStatment));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody CustomerStatmentReq customerStatmentReq){
        try {
            customerStatmentReq.setPage(customerStatmentReq.getSize() * (customerStatmentReq.getPage()-1));
            Map map = new HashedMap();
            map.put("count",jCustomerStatmentMapper.getCount(customerStatmentReq));
            map.put("list",jCustomerStatmentMapper.getStatmentList(customerStatmentReq));
            return new ModelRes(ModelRes.Status.SUCCESS,"操作成功 !",map);
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/export")
    public String export(@RequestBody CustomerStatmentReq customerStatmentReq){
        try {
            return ExcelUtil.ExportCustomerStatment(jCustomerStatmentMapper.getStatmentList(customerStatmentReq));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
