package com.summ.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.summ.controller.basic.AutoMapperController;
import com.summ.mapper2.*;
import com.summ.model.*;
import com.summ.model.response.ModelRes;
import com.summ.model2.*;
import com.summ.model2.response.CustomerHouseRes;
import com.summ.utils.dbUtil.DBMoveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;
import java.util.*;

/**
 * Created by jygj_7500 on 17/11/8.
 */
@Controller
public class TestController extends AutoMapperController {

    @Autowired
    private CustomerInfoMapper customerInfoMapper;
    @Autowired
    private NannyInfoMapper nannyInfoMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private CustomerHouseMapper customerHouseMapper;
    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private CouponlistMapper couponlistMapper;
    @Autowired
    private CustomerStatementMapper customerStatementMapper;

    /**
     * 客户基本信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/CustomerInfo")
    @ResponseBody
    public Object CustomerInfo(@RequestBody Map map) {
        try {
            List<CustomerInfo> customerInfoList = customerInfoMapper.selectList(new EntityWrapper<CustomerInfo>());
            List<JCustomer> jCustomerList = new ArrayList<JCustomer>();
            for (CustomerInfo customerInfo : customerInfoList) {
                JCustomer jCustomer = new JCustomer();
                jCustomer.setCustomerId(customerInfo.getCustomerId());
                jCustomer.setCustomerBalance(customerInfo.getCustomerBalance());
                jCustomer.setCreateTime(customerInfo.getCreatetime());
                jCustomer.setCreateId(customerInfo.getCreateid());
                jCustomer.setCustomerName(customerInfo.getCustomerName());
                jCustomer.setCustomerPhone(customerInfo.getCustomerPhone());
                jCustomer.setCustomerSex(customerInfo.getCustomerSex() == 1 ? 9 : 10);
                jCustomer.setModifyTime(customerInfo.getModifytime());
                jCustomer.setModifyId(customerInfo.getModifyid());
                //warntype 存放老价格字段
                jCustomer.setWarnType(customerInfo.getOldprice());
                jCustomer.setCustomerType(1 == customerInfo.getCustomerType() ? 11 : 12);
                jCustomer.setIsDel(customerInfo.getIsDel() == 0 ? 16 : 17);
                jCustomer.setRemark(customerInfo.getBackup());
                jCustomer.setWeiXinOpenId(customerInfo.getWxopenid());
                System.out.println("客户信息："+jCustomer.toString());
                jCustomerList.add(jCustomer);
            }
            jCustomerMapper.insertBatch(jCustomerList);
            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "查找订单信息失败");
        }
    }


    @RequestMapping(value = "/CustomerHouse")
    @ResponseBody
    public Object CustomerHouse(@RequestBody Map map) {
        try {
            List<CustomerHouseRes> customerHouseList = customerHouseMapper.getCutomerHouse();
            List<CustomerHouseRes> customerHouseList1 = new ArrayList<CustomerHouseRes>();
            customerHouseList1.add(customerHouseList.get(0));

            List<JCustomerHouse> jCustomerHouseList = new ArrayList<>();
            for (CustomerHouseRes customerHouseRes:customerHouseList1){
                JCustomerHouse jCustomerHouse=new JCustomerHouse();
                jCustomerHouse.setHouseId(customerHouseRes.getHouseId());
                jCustomerHouse.setServiceId(0);
                jCustomerHouse.setShopId(customerHouseRes.getShopId());
                jCustomerHouse.setCreateTime(customerHouseRes.getCreatetime());
                jCustomerHouse.setHouseAddress(customerHouseRes.getHouseAddress());
                List<Integer> integerList=DBMoveUtil.getHouse(customerHouseRes.getRoomType());
                jCustomerHouse.setBedRoom(integerList.get(0));
                jCustomerHouse.setRestRoom(integerList.get(1));
                jCustomerHouse.setLivingRoom(integerList.get(2));
                jCustomerHouse.setHouseArea(customerHouseRes.getHouseArea());
                jCustomerHouse.setCreateId(customerHouseRes.getCreateid());
                jCustomerHouse.setIsDel(customerHouseRes.getIsDel()==0?16:17);
                jCustomerHouse.setLongitude(Double.valueOf(customerHouseRes.getLongitude()));
                jCustomerHouse.setLatitude(Double.valueOf(customerHouseRes.getLatitude()));
                jCustomerHouseList.add(jCustomerHouse);
            }
            jCustomerHouseMapper.insertBatch(jCustomerHouseList);
            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "查找订单信息失败");
        }
    }


    @RequestMapping(value = "/CustomerStatment")
    @ResponseBody
    public Object CustomerStatment(@RequestBody Map map) {
        try {
            List<CustomerStatement> customerStatementList = customerStatementMapper.selectList(new EntityWrapper<CustomerStatement>());
            List<CustomerStatement> customerStatementList1 = new ArrayList<>();customerStatementList1.add(customerStatementList.get(0));
            List<JCustomerStatment> jCustomerStatmentList = new ArrayList<>();
            for (CustomerStatement customerStatement : customerStatementList1){
                JCustomerStatment jCustomerStatment = new JCustomerStatment();
                jCustomerStatment.setStatmentId(customerStatement.getId());
                jCustomerStatment.setBalance(customerStatement.getBalance());
                jCustomerStatment.setStatmentCustomerType(DBMoveUtil.getCustomerStatmentType(customerStatement.getType(),customerStatement.getBackup(),customerStatement.getOrderType()));
                jCustomerStatment.setChargeDate(customerStatement.getCreatetime());
                jCustomerStatment.setCustomerId(customerStatement.getCustomerId());
                jCustomerStatment.setChargeMoney(new BigDecimal(customerStatement.getChargeMoney()));
                jCustomerStatment.setRemark(customerStatement.getBackup());
                jCustomerStatment.setServiceTimeLength(customerStatement.getMissionHour());
                //1、5合同2包月、3、4临时、6包年、0充值
                int orderType=customerStatement.getOrderType();
                jCustomerStatment.setOrderType(orderType==1?163:orderType==2?261:orderType==3?164:orderType==5?163:orderType==6?165:0);
                jCustomerStatment.setAdminId(customerStatement.getCreateid());
                jCustomerStatment.setStatus(53);
                jCustomerStatmentList.add(jCustomerStatment);
            }
            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "查找订单信息失败");
        }
    }



    @RequestMapping(value = "/NannyInfo")
    @ResponseBody
    public Object NannyInfo(@RequestBody Map map) {
        List<NannyInfo> nannyInfoList = nannyInfoMapper.selectList(new EntityWrapper<NannyInfo>());
        List<NannyInfo> nannyInfoList1 = new ArrayList<NannyInfo>();nannyInfoList1.add(nannyInfoList.get(0));
        JNannyInfo jNannyInfo = new JNannyInfo();
        for (NannyInfo nannyInfo:nannyInfoList1){
            jNannyInfo.setNannyId(nannyInfo.getNannyId());
            jNannyInfo.setNannyName(nannyInfo.getNannyName());
            jNannyInfo.setNannySex(nannyInfo.getNannySex()==1?9:10);
            jNannyInfo.setNannyPhone(nannyInfo.getNannyPhone());
            jNannyInfo.setNannyAddress(nannyInfo.getNannyAddress());
            jNannyInfo.setNannyBirthday(nannyInfo.getNannyBirthday().toString());
            jNannyInfo.setNannyOrigin(DBMoveUtil.getNannyOrigin(nannyInfo.getNannyRoot()));
            jNannyInfo.setNannyNation(Integer.parseInt(nannyInfo.getNannyNation()));
            jNannyInfo.setNannyAnimalSign(DBMoveUtil.getNannyAnimal(nannyInfo.getNannyZodiac()));
            jNannyInfo.setNannyHeight(nannyInfo.getNannyHeight());
            jNannyInfo.setNannyWeight(nannyInfo.getNannyWeight());
            jNannyInfo.setNannyStatus(nannyInfo.getNannyStatus());
            jNannyInfo.setNannyLevel(nannyInfo.getNannyLevel()==1?84:nannyInfo.getNannyLevel()==2?85:86);
            jNannyInfo.setNannyEducation(DBMoveUtil.getNannyEducation(nannyInfo.getNannyQualification()));
        }

        return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", jNannyInfo);
    }


    @RequestMapping(value = "/AdminInfo")
    @ResponseBody
    public Object adminInfo(@RequestBody Map map) {
        List<Admin> adminList = adminMapper.selectList(new EntityWrapper<Admin>());
        List<Admin> adminList1 = new ArrayList<Admin>();adminList1.add(adminList.get(0));
        JAdmin jAdmin = new JAdmin();
        JAdminType jAdminType = new JAdminType();
        JAdminShop jAdminShop = new JAdminShop();
        for (Admin admin:adminList1){
            jAdmin.setAdminId(admin.getAdminId());
            jAdmin.setAdminName(admin.getAdminName());
            jAdmin.setAdminPhone(admin.getAdminPhone());
            jAdmin.setIsDel(admin.getIsDel()==0?16:17);

            jAdminType.setAdminId(admin.getAdminId());
            int adminType=admin.getAdminType();
            jAdminType.setAdminTypeId(adminType==1?1:adminType==2?2:adminType==3?3:adminType==5?5:adminType==6?4:5);

            jAdminShop.setAdminId(admin.getAdminId());
            jAdminShop.setShopId(admin.getShopId());
        }

        return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", null);
    }


    @RequestMapping(value = "/Coupon")
    @ResponseBody
    public Object coupon(@RequestBody Map map) {
        List<Coupon> couponList =couponMapper.selectList(new EntityWrapper<Coupon>());
        List<JCoupon> jCouponList = new ArrayList<>();
        for (Coupon coupon:couponList){
            JCoupon jCoupon = new JCoupon();
            jCoupon.setCouponId(coupon.getCouponid());
            jCoupon.setIsDel(coupon.getIsdel()==0?16:17);
            jCoupon.setOrderMiniPrice(new BigDecimal(0));
            jCoupon.setCouponPrice(coupon.getCouponprice());
            jCoupon.setCouponOrigin(coupon.getCouponid()==1?35:coupon.getCouponid()==2?35:coupon.getCouponid()==3?35:36);
            jCoupon.setCouponName(coupon.getCouponname());
            jCoupon.setCouponDetail(coupon.getCoupondetail());
            jCoupon.setCreateTime(coupon.getCreatetime());
            Date date = new Date();
            jCoupon.setValidTime(new Date(date.getTime()+31536000));
            jCouponList.add(jCoupon);
        }
        jCouponMapper.insertBatch(jCouponList);
        return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", null);
    }

    @RequestMapping(value = "/CouponList")
    @ResponseBody
    public Object CouponList(@RequestBody Map map) {
        List<Couponlist> couponlists = couponlistMapper.selectList(new EntityWrapper<Couponlist>());
        List<JCouponList> jCouponListList = new ArrayList<>();
        for (Couponlist couponlist : couponlists){
            JCouponList jCouponList = new JCouponList();
            jCouponList.setCouponListId(couponlist.getCouponid());
            jCouponList.setCouponId(couponlist.getType());
            jCouponList.setCouponCode(couponlist.getNumber());
            jCouponList.setCouponStatus(couponlist.getStatus()==3?34:32);
            jCouponList.setCustomerId(couponlist.getCustomerId());
            jCouponList.setIsDel(couponlist.getIsDel()==0?16:17);
            jCouponList.setShopId(couponlist.getShopId());
            jCouponList.setOrderId(couponlist.getMissionId());
            jCouponList.setCreateTime(couponlist.getCreatetime());
            jCouponList.setRemark(couponlist.getBackup());

        }
        return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", null);
    }
}
