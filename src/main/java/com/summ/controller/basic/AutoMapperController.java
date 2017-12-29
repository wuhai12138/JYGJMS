package com.summ.controller.basic;

import com.summ.mapper.*;
import com.summ.model.JNannyTrain;
import com.summ.model.JShop;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jygj_7500 on 17/12/18.
 */
public class AutoMapperController {
    @Autowired
    public JCouponMapper jCouponMapper;
    @Autowired
    public JCouponListMapper jCouponListMapper;
    @Autowired
    public JAreaMapper jAreaMapper;
    @Autowired
    public JProvinceMapper jProvinceMapper;
    @Autowired
    public JCityMapper jCityMapper;
    @Autowired
    public JCustomerHouseMapper jCustomerHouseMapper;
    @Autowired
    public JCustomerStatmentMapper jCustomerStatmentMapper;
    @Autowired
    public JCustomerMapper jCustomerMapper;
    @Autowired
    public JNannyInfoMapper jNannyInfoMapper;
    @Autowired
    public JNannyTrainMapper jNannyTrainMapper;
    @Autowired
    public JStreetMapper jStreetMapper;
    @Autowired
    public JDictInfoMapper jDictInfoMapper;
    @Autowired
    public JDictTypeMapper jDictTypeMapper;
    @Autowired
    public JAccessMapper jAccessMapper;
    @Autowired
    public JNannyJobLevelMapper jNannyJobLevelMapper;
    @Autowired
    public JNannyReligionMapper jNannyReligionMapper;
    @Autowired
    public JNannyLanguageMapper jNannyLanguageMapper;
    @Autowired
    public JNannySkillMapper jNannySkillMapper;
    @Autowired
    public JNannyCharacterMapper jNannyCharacterMapper;
    @Autowired
    public JNannyCertificateMapper jNannyCertificateMapper;
    @Autowired
    public JShopMapper jShopMapper;
    @Autowired
    public JNannyShopMapper jNannyShopMapper;


}
