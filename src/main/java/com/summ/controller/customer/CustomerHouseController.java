package com.summ.controller.customer;

import com.summ.mapper.JAreaMapper;
import com.summ.mapper.JCityMapper;
import com.summ.mapper.JCustomerHouseMapper;
import com.summ.mapper.JProvinceMapper;
import com.summ.model.JCustomerHouse;
import com.summ.model.response.ModelRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by jygj_7500 on 17/11/28.
 */
@Controller
@RequestMapping("/customer/house")
public class CustomerHouseController {

    @Autowired
    private JAreaMapper jAreaMapper;
    @Autowired
    private JProvinceMapper jProvinceMapper;
    @Autowired
    private JCityMapper jCityMapper;
    @Autowired
    private JCustomerHouseMapper jCustomerHouseMapper;

    /**
     * CRUD for customer house
     * @param jCustomerHouse
     * @return
     */

    @ResponseBody
    @RequestMapping("/find")
    public Object findHouse(@RequestBody JCustomerHouse jCustomerHouse){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"search house info success !",new ModelRes(jCustomerHouseMapper.getList(jCustomerHouse.getCustomerId())));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Object insertHouse(@RequestBody JCustomerHouse jCustomerHouse){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"insert house info success !",jCustomerHouseMapper.insert(jCustomerHouse));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object deleteHouse(@RequestBody Map<String,List> map){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"delete house info success !",jCustomerHouseMapper.deleteList(map.get("houseId")));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object updateHouse(@RequestBody JCustomerHouse jCustomerHouse){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"update house info success !",jCustomerHouseMapper.updateById(jCustomerHouse));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

}
