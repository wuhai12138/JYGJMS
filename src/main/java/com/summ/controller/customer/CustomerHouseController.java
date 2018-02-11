package com.summ.controller.customer;

import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JCustomerHouse;
import com.summ.model.response.CustomerHouseRes;
import com.summ.model.response.ModelRes;
import com.summ.utils.ResponseUtil;
import com.summ.utils.mongodb.MongoDBUtil;
import com.summ.utils.mongodb.model.MongoConfig;
import org.apache.commons.collections.map.HashedMap;
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
            mongoDBUtil = MongoDBUtil.getInstance(mongoConfig);
            List<CustomerHouseRes> customerHouseResList = jCustomerHouseMapper.getList(jCustomerHouse.getCustomerId());
            for (CustomerHouseRes customerHouseRes : customerHouseResList){
                Map map = new HashedMap();
                map.put("serviceId",customerHouseRes.getServiceId());
                customerHouseRes.setServiceDetail(mongoDBUtil.query("customer_service",map));
            }
            return new ModelRes(ModelRes.Status.SUCCESS,"search customer house info success !", ResponseUtil.List2Map(customerHouseResList));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Object insertHouse(@RequestBody JCustomerHouse jCustomerHouse){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"insert customer house info success !",jCustomerHouseMapper.insert(jCustomerHouse));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object deleteHouse(@RequestBody Map<String,List> map){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"delete customer house info success !",jCustomerHouseMapper.deleteList(map.get("houseId")));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object updateHouse(@RequestBody JCustomerHouse jCustomerHouse){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"update customer house info success !",jCustomerHouseMapper.updateSelectiveById(jCustomerHouse));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

}
