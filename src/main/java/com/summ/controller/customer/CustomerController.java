package com.summ.controller.customer;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.summ.mapper.*;
import com.summ.model.*;
import com.summ.model.request.CustomerPagReq;
import com.summ.model.response.ModelRes;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jygj_7500
 * @date 17/11/20
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private JCustomerMapper jCustomerMapper;
    @Autowired
    private JAreaMapper jAreaMapper;
    @Autowired
    private JProvinceMapper jProvinceMapper;
    @Autowired
    private JCityMapper jCityMapper;
    @Autowired
    private JCustomerHouseMapper jCustomerHouseMapper;

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JCustomer jCustomer){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"add customer success !",jCustomerMapper.insert(jCustomer));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestBody Map<String,List> jCustomer){
        try {
            List list = jCustomer.get("customerId");
            System.out.println(">>>>>>>>>>>list>>>>>>>>>>>>" + list);
            return new ModelRes(ModelRes.Status.SUCCESS,"delete customer success !",jCustomerMapper.deleteList(list));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody JCustomer jCustomer){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"update customer success !",jCustomerMapper.updateById(jCustomer));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody CustomerPagReq customerPagReq){
        try {
            customerPagReq.setPage(customerPagReq.getSize() * (customerPagReq.getPage()-1));
            Map<String,Object> map = new HashedMap();
            map.put("count",jCustomerMapper.getCount(customerPagReq));
            map.put("list",jCustomerMapper.getCustomerList(customerPagReq));
            return new ModelRes(ModelRes.Status.SUCCESS,"search customer success !",map);
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/house/find")
    public Object findHouse(@RequestBody JCustomerHouse jCustomerHouse){
        try {
            List list = jCustomerHouseMapper.getList(jCustomerHouse.getCustomerId());
            Map map = new HashMap();
            map.put("list",list);
            return new ModelRes(ModelRes.Status.SUCCESS,"search house info success !",map);
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/house/insert")
    public Object insertHouse(@RequestBody JCustomerHouse jCustomerHouse){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"insert house info success !",jCustomerHouseMapper.insert(jCustomerHouse));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/house/delete")
    public Object deleteHouse(@RequestBody Map<String,List> map){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"delete house info success !",jCustomerHouseMapper.deleteList(map.get("houseId")));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/house/update")
    public Object updateHouse(@RequestBody JCustomerHouse jCustomerHouse){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"update house info success !",jCustomerHouseMapper.updateById(jCustomerHouse));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

}
