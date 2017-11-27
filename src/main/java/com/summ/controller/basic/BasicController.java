package com.summ.controller.basic;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.summ.mapper.JAreaMapper;
import com.summ.mapper.JCityMapper;
import com.summ.mapper.JCustomerHouseMapper;
import com.summ.mapper.JProvinceMapper;
import com.summ.model.JArea;
import com.summ.model.JCity;
import com.summ.model.JProvince;
import com.summ.model.response.ModelRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jygj_7500 on 17/11/27.
 */
@Controller
@RequestMapping("/basic")
public class BasicController {

    @Autowired
    private JAreaMapper jAreaMapper;
    @Autowired
    private JProvinceMapper jProvinceMapper;
    @Autowired
    private JCityMapper jCityMapper;

    @ResponseBody
    @RequestMapping("/address")
    public Object getProvinceCityAndArea(){
        try {
            Map map = new HashMap();
            Map provinceMap = new HashMap();
            Map cityMap = new HashMap();
            Map areaMap = new HashMap();
            List list = new ArrayList();
            EntityWrapper<JArea> entityArea = null;
            EntityWrapper<JCity> entityCity = null;
            EntityWrapper<JProvince> entityProvince = null;
            provinceMap.put("provinceList",jProvinceMapper.selectList(entityProvince));
            cityMap.put("cityList",jCityMapper.selectList(entityCity));
            areaMap.put("areaList",jAreaMapper.selectList(entityArea));
            list.add(provinceMap);
            list.add(cityMap);
            list.add(areaMap);
            map.put("list",list);
            return new ModelRes(ModelRes.Status.SUCCESS,"search address success !",map);
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
}
