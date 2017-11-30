package com.summ.controller.basic;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.summ.mapper.*;
import com.summ.model.*;
import com.summ.model.request.AddressReq;
import com.summ.model.response.ModelRes;
import com.summ.utils.JsonUtil;
import com.summ.utils.ResponseUtil;
import com.summ.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    private JStreetMapper jStreetMapper;
    @Autowired
    private JAreaMapper jAreaMapper;
    @Autowired
    private JProvinceMapper jProvinceMapper;
    @Autowired
    private JCityMapper jCityMapper;
    @Autowired
    private JDictInfoMapper jDictInfoMapper;

    /**
     * 获取省市区列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/address")
    public Object getProvinceCityAndArea(@RequestBody AddressReq addressReq) {
        try {
            Map map = new HashMap();
            JStreet jStreet = new JStreet();
            JArea jArea = new JArea();
            JCity jCity = new JCity();
            if (addressReq.getAreaCode() != null && addressReq.getAreaCode().length() > 0) {
                //区code不为空则返回该code下的街道列表
                System.out.println("区code不为空则返回该code下的街道列表");
                jStreet.setAreaCode(addressReq.getAreaCode());
                EntityWrapper<JStreet> streetEntityWrapper = new EntityWrapper<JStreet>(jStreet);
                map.put("areaCode",addressReq.getAreaCode());
                return new ModelRes(ModelRes.Status.SUCCESS, "search address success !", ResponseUtil.List2Map(jStreetMapper.selectByMap(map)));
            } else if (addressReq.getCityCode() != null && addressReq.getCityCode().length() > 0) {
                //区列表为空，市code不为空则返回该市下的区列表
                System.out.println("区列表为空，市code不为空则返回该市下的区列表");
                jArea.setCityCode(addressReq.getCityCode());
                EntityWrapper<JArea> areaEntityWrapper = new EntityWrapper<JArea>(jArea);
                map.put("cityCode",addressReq.getCityCode());
                return new ModelRes(ModelRes.Status.SUCCESS, "search address success !", ResponseUtil.List2Map(jAreaMapper.selectByMap(map)));
            } else if (addressReq.getProvinceCode() != null && addressReq.getProvinceCode().length() > 0) {
                //省code不为空则返回该省下的市列表
                System.out.println("省code不为空则返回该省下的市列表");
                jCity.setProvinceCode(addressReq.getProvinceCode());
                EntityWrapper<JCity> cityEntityWrapper = new EntityWrapper<JCity>(jCity);
                map.put("provinceCode",addressReq.getProvinceCode());
                return new ModelRes(ModelRes.Status.SUCCESS, "search address success !", ResponseUtil.List2Map(jCityMapper.selectByMap(map)));
            } else {
                //啥都不传则返回上海区列表
                System.out.println("啥都不传则返回上海区列表");
                map.put("cityCode","11010000");
                return new ModelRes(ModelRes.Status.SUCCESS, "search address success !", ResponseUtil.List2Map(jAreaMapper.selectByMap(map)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/dict")
    public Object getDict(@RequestBody Map<String, Integer> typeCode) {
        try {
            Map map = new HashMap();
            map.put("list", jDictInfoMapper.getList(typeCode.get("typeCode")));
            return new ModelRes(ModelRes.Status.SUCCESS, "search address success !", map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
}
