package com.summ.controller.customer;

import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JCustomerHouse;
import com.summ.model.response.ModelRes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jygj_7500
 * @date 17/11/28
 */
@Controller
@RequestMapping("/customer/house")
public class CustomerHouseController extends AutoMapperController{

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
