package com.summ.controller.customer;

import com.summ.mapper.JCustomerStatmentMapper;
import com.summ.model.JAdmin;
import com.summ.model.JCustomer;
import com.summ.model.JCustomerStatment;
import com.summ.model.request.CustomerPagReq;
import com.summ.model.request.CustomerStatmentReq;
import com.summ.model.response.ModelRes;
import com.summ.utils.ExcelUtil;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by jygj_7500 on 17/11/29.
 */
@Controller
@RequestMapping("/customer/statment")
public class CustomerStatmentController {

    @Autowired
    private JCustomerStatmentMapper jCustomerStatmentMapper;

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
            return new ModelRes(ModelRes.Status.SUCCESS,"add customer statment success !",jCustomerStatmentMapper.insert(jCustomerStatment));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

//    @ResponseBody
//    @RequestMapping("/update")
//    public Object update(@RequestBody JCustomer jCustomer){
//        try {
//            return new ModelRes(ModelRes.Status.SUCCESS,"update customer success !",jCustomerMapper.updateById(jCustomer));
//        }catch (Exception e){
//            e.printStackTrace();
//            return new ModelRes(ModelRes.Status.ERROR, "server err !");
//        }
//    }

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody CustomerStatmentReq customerStatmentReq){
        try {
            customerStatmentReq.setPage(customerStatmentReq.getSize() * (customerStatmentReq.getPage()-1));
            Map map = new HashedMap();
            map.put("count",jCustomerStatmentMapper.getCount(customerStatmentReq));
            map.put("list",jCustomerStatmentMapper.getStatmentList(customerStatmentReq));
            return new ModelRes(ModelRes.Status.SUCCESS,"search customer statment success !",map);
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
