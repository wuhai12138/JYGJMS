package com.summ.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.summ.controller.basic.AutoMapperController;
import com.summ.mapper.JNannyEmergencyContactMapper;
import com.summ.mapper.JOrderMonthMapper;
import com.summ.mapper2.*;
import com.summ.model.*;
import com.summ.model.response.ModelRes;
import com.summ.model2.*;
import com.summ.model2.response.CustomerHouseRes;
import com.summ.utils.JsonUtil;
import com.summ.utils.OrderUtil;
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
    private OrderSmallMapper orderSmallMapper;
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
    @Autowired
    private NannyFamilyMapper nannyFamilyMapper;
    @Autowired
    private NannyPhotoFileMapper nannyPhotoFileMapper;
    @Autowired
    private NannyStatementMapper nannyStatementMapper;
    @Autowired
    private NannyWorkTimeMapper nannyWorkTimeMapper;
    @Autowired
    private CustomerShareMapper customerShareMapper;
    @Autowired
    private OrderBigMapper orderBigMapper;

    /**
     * 客户基本信息
     *
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
                System.out.println("客户信息：" + jCustomer.toString());
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
            for (CustomerHouseRes customerHouseRes : customerHouseList1) {
                JCustomerHouse jCustomerHouse = new JCustomerHouse();
                jCustomerHouse.setHouseId(customerHouseRes.getHouseId());
                jCustomerHouse.setServiceId(0);
                jCustomerHouse.setShopId(customerHouseRes.getShopId());
                jCustomerHouse.setCreateTime(customerHouseRes.getCreatetime());
                jCustomerHouse.setHouseAddress(customerHouseRes.getHouseAddress());
                List<Integer> integerList = DBMoveUtil.getHouse(customerHouseRes.getRoomType());
                jCustomerHouse.setBedRoom(integerList.get(0));
                jCustomerHouse.setRestRoom(integerList.get(1));
                jCustomerHouse.setLivingRoom(integerList.get(2));
                jCustomerHouse.setHouseArea(customerHouseRes.getHouseArea());
                jCustomerHouse.setCreateId(customerHouseRes.getCreateid());
                jCustomerHouse.setIsDel(customerHouseRes.getIsDel() == 0 ? 16 : 17);
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
            List<CustomerStatement> customerStatementList1 = new ArrayList<>();
            customerStatementList1.add(customerStatementList.get(0));
            List<JCustomerStatment> jCustomerStatmentList = new ArrayList<>();
            for (CustomerStatement customerStatement : customerStatementList1) {
                JCustomerStatment jCustomerStatment = new JCustomerStatment();
                jCustomerStatment.setStatmentId(customerStatement.getId());
                jCustomerStatment.setBalance(customerStatement.getBalance());
                jCustomerStatment.setStatmentCustomerType(DBMoveUtil.getCustomerStatmentType(customerStatement.getType(), customerStatement.getBackup(), customerStatement.getOrderType()));
                jCustomerStatment.setChargeDate(customerStatement.getCreatetime());
                jCustomerStatment.setCustomerId(customerStatement.getCustomerId());
                jCustomerStatment.setChargeMoney(new BigDecimal(customerStatement.getChargeMoney()));
                jCustomerStatment.setRemark(customerStatement.getBackup());
                jCustomerStatment.setServiceTimeLength(customerStatement.getMissionHour());
                //1、5合同2包月、3、4临时、6包年、0充值
                int orderType = customerStatement.getOrderType();
                jCustomerStatment.setOrderType(orderType == 1 ? 163 : orderType == 2 ? 261 : orderType == 3 ? 164 : orderType == 5 ? 163 : orderType == 6 ? 165 : 0);
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

    /**
     * 地址物业
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/property")
    @ResponseBody
    public Object NannyWorkTime(@RequestBody Map map) {
        List<CustomerShare> customerShareList = customerShareMapper.selectList(new EntityWrapper<CustomerShare>());
        List<CustomerShare> customerShareList1 = new ArrayList<>();
        customerShareList1.add(customerShareList.get(20));
        JCustomerHouseProperty jCustomerHouseProperty = new JCustomerHouseProperty();
        for (CustomerShare customerShare : customerShareList1) {
            jCustomerHouseProperty.setPropertyId(customerShare.getId());
            jCustomerHouseProperty.setPropertyName(customerShare.getName());
            jCustomerHouseProperty.setPropertyAddress(customerShare.getAddress());
            jCustomerHouseProperty.setIsDel(customerShare.getIsDel() == 0 ? 16 : 17);
            jCustomerHouseProperty.setCreateDate(customerShare.getCreatetime());

        }

        return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", jCustomerHouseProperty);
    }


    @RequestMapping(value = "/NannyInfo")
    @ResponseBody
    public Object NannyInfo(@RequestBody Map map) {
        List<NannyInfo> nannyInfoList = nannyInfoMapper.selectList(new EntityWrapper<NannyInfo>());
        List<NannyInfo> nannyInfoList1 = new ArrayList<NannyInfo>();
        nannyInfoList1.add(nannyInfoList.get(0));
        JNannyInfo jNannyInfo = new JNannyInfo();
        for (NannyInfo nannyInfo : nannyInfoList1) {
            jNannyInfo.setNannyId(nannyInfo.getNannyId());
            jNannyInfo.setNannyName(nannyInfo.getNannyName());
            jNannyInfo.setNannySex(nannyInfo.getNannySex() == 1 ? 9 : 10);
            jNannyInfo.setNannyPhone(nannyInfo.getNannyPhone());
            jNannyInfo.setNannyAddress(nannyInfo.getNannyAddress());
            jNannyInfo.setNannyBirthday(nannyInfo.getNannyBirthday().toString());
            jNannyInfo.setNannyOrigin(DBMoveUtil.getNannyOrigin(nannyInfo.getNannyRoot()));
            jNannyInfo.setNannyNation(Integer.parseInt(nannyInfo.getNannyNation()));
            jNannyInfo.setNannyAnimalSign(DBMoveUtil.getNannyAnimal(nannyInfo.getNannyZodiac()));
            jNannyInfo.setNannyHeight(nannyInfo.getNannyHeight());
            jNannyInfo.setNannyWeight(nannyInfo.getNannyWeight());
            jNannyInfo.setNannyStatus(nannyInfo.getNannyStatus());
            jNannyInfo.setNannyLevel(nannyInfo.getNannyLevel() == 1 ? 84 : nannyInfo.getNannyLevel() == 2 ? 85 : 86);
            jNannyInfo.setNannyEducation(DBMoveUtil.getNannyEducation(nannyInfo.getNannyQualification()));
        }

        return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", jNannyInfo);
    }

    /**
     * 服务师紧急联系人
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/NannyFamily")
    @ResponseBody
    public Object NannyFamily(@RequestBody Map map) {
        List<NannyFamily> nannyFamilyList = nannyFamilyMapper.selectList(new EntityWrapper<NannyFamily>());
        List<NannyFamily> nannyFamilyList1 = new ArrayList<NannyFamily>();
        nannyFamilyList1.add(nannyFamilyList.get(0));
        JNannyEmergencyContact jNannyEmergencyContact = new JNannyEmergencyContact();
        for (NannyFamily nannyFamily : nannyFamilyList1) {
            jNannyEmergencyContact.setEmergencyContactId(nannyFamily.getFamilyId());
            jNannyEmergencyContact.setIsDel(nannyFamily.getIsDel() == 0 ? 16 : 17);
            jNannyEmergencyContact.setName(nannyFamily.getFamilyName());
            jNannyEmergencyContact.setNannyId(nannyFamily.getNannyId());
            jNannyEmergencyContact.setPhone(nannyFamily.getFamilyPhone());
            jNannyEmergencyContact.setRelationship(nannyFamily.getFamilyRelationship());
            jNannyEmergencyContactMapper.insertSelective(jNannyEmergencyContact);
        }

        return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", jNannyEmergencyContact);
    }

    /**
     * 服务师证件信息
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/NannyCertificate")
    @ResponseBody
    public Object NannyCertificate(@RequestBody Map map) {
        List<NannyPhotoFile> nannyPhotoFileList = nannyPhotoFileMapper.selectList(new EntityWrapper<NannyPhotoFile>());
        List<NannyPhotoFile> nannyPhotoFileList1 = new ArrayList<>();
        nannyPhotoFileList1.add(nannyPhotoFileList.get(0));
        JNannyCertificate jNannyCertificate = new JNannyCertificate();
        for (NannyPhotoFile nannyPhotoFile : nannyPhotoFileList1) {
            jNannyCertificate.setNannyCertId(nannyPhotoFile.getFileId());
            jNannyCertificate.setCertificateId(DBMoveUtil.getNannyCertificate(nannyPhotoFile.getFileBack()));
            jNannyCertificate.setPhoto(nannyPhotoFile.getFileName());
            jNannyCertificate.setIsDel(nannyPhotoFile.getIsDel() == 0 ? 16 : 17);
            jNannyCertificate.setNannyId(nannyPhotoFile.getNannyId());
            jNannyCertificateMapper.insertSelective(jNannyCertificate);
        }

        return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", jNannyCertificate);
    }

    /**
     * 服务师对账单记录
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/NannyStatment")
    @ResponseBody
    public Object NannyStatment(@RequestBody Map map) {
        List<NannyStatement> nannyStatementList = nannyStatementMapper.selectList(new EntityWrapper<NannyStatement>());
        List<NannyStatement> nannyStatementList1 = new ArrayList<>();
        nannyStatementList1.add(nannyStatementList.get(2000));
        JNannyStatment jNannyStatment = new JNannyStatment();
        for (NannyStatement nannyStatement : nannyStatementList1) {

            NannyInfo nannyInfo = nannyInfoMapper.selectById(Long.valueOf(nannyStatement.getNannyId()));
            if (nannyStatement.getMissionId() != 0) {
                OrderSmall orderSmall = orderSmallMapper.selectById(Long.valueOf(nannyStatement.getMissionId()));
                CustomerHouse customerHouse = customerHouseMapper.selectById(Long.valueOf(orderSmall.getHouseId()));
                jNannyStatment.setOrderId(orderSmall.getOrderId());
                jNannyStatment.setHouseId(orderSmall.getHouseId());
                jNannyStatment.setCustomerId(customerHouse.getCustomerId());
                jNannyStatment.setOrderType(DBMoveUtil.getOrderType(orderSmall.getOrderType()));
                jNannyStatment.setGoodsId(orderSmall.getPriceId());
                jNannyStatment.setServiceTime(orderSmall.getMissionTime());
                jNannyStatment.setServiceDate(orderSmall.getMissionDate());
            }

            jNannyStatment.setNannyCurrentJobLevel(DBMoveUtil.getNannyCurrentJobLevel(nannyStatement.getMissionHour(), nannyStatement.getMissionCost()));
            jNannyStatment.setNannyCurrentUnitPrice(DBMoveUtil.getNannyCurrentUnitPrice(nannyStatement.getMissionHour(), nannyStatement.getMissionCost()));
            ;
            jNannyStatment.setStatmentNanny(OrderUtil.generateStamentNumber(nannyStatement.getNannyId()));
            jNannyStatment.setCreateDate(nannyStatement.getCreatetime());
            jNannyStatment.setStatmentId(nannyStatement.getStatementId());
            jNannyStatment.setNannyId(nannyStatement.getNannyId());
            jNannyStatment.setServiceTimeLength(nannyStatement.getMissionHour());
            jNannyStatment.setStatmentNannyType(DBMoveUtil.getNannyStatmentType(nannyStatement.getMissionType()));
            jNannyStatment.setStatmentMoney(nannyStatement.getMissionCost());
            jNannyStatment.setScheduleId(nannyStatement.getMissionId());
            jNannyStatment.setShopId(nannyStatement.getShopId());
            jNannyStatment.setRemark(nannyStatement.getBackup());
            jNannyStatmentMapper.insertSelective(jNannyStatment);
        }

        return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", jNannyStatment);
    }

    @RequestMapping(value = "/AdminInfo")
    @ResponseBody
    public Object adminInfo(@RequestBody Map map) {
        List<Admin> adminList = adminMapper.selectList(new EntityWrapper<Admin>());
        List<Admin> adminList1 = new ArrayList<Admin>();
        adminList1.add(adminList.get(0));
        JAdmin jAdmin = new JAdmin();
        JAdminType jAdminType = new JAdminType();
        JAdminShop jAdminShop = new JAdminShop();
        for (Admin admin : adminList1) {
            jAdmin.setAdminId(admin.getAdminId());
            jAdmin.setAdminName(admin.getAdminName());
            jAdmin.setAdminPhone(admin.getAdminPhone());
            jAdmin.setIsDel(admin.getIsDel() == 0 ? 16 : 17);

            jAdminType.setAdminId(admin.getAdminId());
            int adminType = admin.getAdminType();
            jAdminType.setAdminTypeId(adminType == 1 ? 1 : adminType == 2 ? 2 : adminType == 3 ? 3 : adminType == 5 ? 5 : adminType == 6 ? 4 : 5);

            jAdminShop.setAdminId(admin.getAdminId());
            jAdminShop.setShopId(admin.getShopId());
        }

        return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", null);
    }


    @RequestMapping(value = "/Coupon")
    @ResponseBody
    public Object coupon(@RequestBody Map map) {
        List<Coupon> couponList = couponMapper.selectList(new EntityWrapper<Coupon>());
        List<JCoupon> jCouponList = new ArrayList<>();
        for (Coupon coupon : couponList) {
            JCoupon jCoupon = new JCoupon();
            jCoupon.setCouponId(coupon.getCouponid());
            jCoupon.setIsDel(coupon.getIsdel() == 0 ? 16 : 17);
            jCoupon.setOrderMiniPrice(new BigDecimal(0));
            jCoupon.setCouponPrice(coupon.getCouponprice());
            jCoupon.setCouponOrigin(coupon.getCouponid() == 1 ? 35 : coupon.getCouponid() == 2 ? 35 : coupon.getCouponid() == 3 ? 35 : 36);
            jCoupon.setCouponName(coupon.getCouponname());
            jCoupon.setCouponDetail(coupon.getCoupondetail());
            jCoupon.setCreateTime(coupon.getCreatetime());
            Date date = new Date();
            jCoupon.setValidTime(new Date(date.getTime() + 31536000));
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
        for (Couponlist couponlist : couponlists) {
            JCouponList jCouponList = new JCouponList();
            jCouponList.setCouponListId(couponlist.getCouponid());
            jCouponList.setCouponId(couponlist.getType());
            jCouponList.setCouponCode(couponlist.getNumber());
            jCouponList.setCouponStatus(couponlist.getStatus() == 3 ? 34 : 32);
            jCouponList.setCustomerId(couponlist.getCustomerId());
            jCouponList.setIsDel(couponlist.getIsDel() == 0 ? 16 : 17);
            jCouponList.setShopId(couponlist.getShopId());
            jCouponList.setOrderId(couponlist.getMissionId());
            jCouponList.setCreateTime(couponlist.getCreatetime());
            jCouponList.setRemark(couponlist.getBackup());

        }
        return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", null);
    }

    /**
     * 大订单
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/BigOrder")
    @ResponseBody
    public Object order(@RequestBody Map map) {
        List<OrderBig> orderBigList = orderBigMapper.getOrderList();
        List<OrderBig> orderBigList1 = new ArrayList<>();
        orderBigList1.add(orderBigList.get(0));
        JOrderContract jOrderContract = new JOrderContract();
        JOrderTemp jOrderTemp = new JOrderTemp();
        JOrderYears jOrderYears = new JOrderYears();
        JOrderMonth jOrderMonth = new JOrderMonth();
        for (OrderBig orderBig : orderBigList1) {
            System.out.println(">>>>>>>>>>>"+JsonUtil.toJson(orderBig));
            /**0全部1合同2包月3一次性4免费5包年*/
            switch (orderBig.getOrderType()) {
                case 1:
                    jOrderContract.setOrderId(orderBig.getOrderId());
                    jOrderContract.setCustomerId(orderBig.getCustomerId());
                    jOrderContract.setShopId(orderBig.getShopId());
                    jOrderContract.setHouseId(orderBig.getHouseId());
                    jOrderContract.setServiceId(0);
                    jOrderContract.setOrderStatus(DBMoveUtil.getOrderStatus(orderBig.getOrderStatus()));
                    jOrderContract.setStartDate(orderBig.getOrderStartDate());
                    jOrderContract.setEndDate(orderBig.getOrderEndDate());
                    jOrderContract.setGoodsId(orderBig.getPriceId());
                    jOrderContract.setSupplierId(0);
                    jOrderContract.setTeacherId(orderBig.getTeacher());
                    jOrderContract.setCreateId(orderBig.getCreateid());
                    jOrderContract.setCreateTime(orderBig.getCreatetime());
                    jOrderContract.setModifyId(orderBig.getModifyid());
                    jOrderContract.setModifyTime(orderBig.getModifytime());
                    jOrderContract.setRemark(orderBig.getBackup());
                    jOrderContract.setIsDel(orderBig.getIsDel() == 0 ? 16 : 17);
                    jOrderContractMapper.insertSelective(jOrderContract);
                    return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", jOrderContract);
                case 2:
                    jOrderMonth.setOrderId(orderBig.getOrderId());
                    jOrderMonth.setCustomerId(orderBig.getCustomerId());
                    jOrderMonth.setShopId(orderBig.getShopId());
                    jOrderMonth.setHouseId(orderBig.getHouseId());
                    jOrderMonth.setServiceId(0);
                    jOrderMonth.setOrderStatus(DBMoveUtil.getOrderStatus(orderBig.getOrderStatus()));
                    jOrderMonth.setStartDate(orderBig.getOrderStartDate());
                    jOrderMonth.setEndDate(orderBig.getOrderEndDate());
                    jOrderMonth.setGoodsId(orderBig.getPriceId());
                    jOrderMonth.setSupplierId(0);
                    jOrderMonth.setTeacherId(orderBig.getTeacher());
                    jOrderMonth.setCreateId(orderBig.getCreateid());
                    jOrderMonth.setCreateTime(orderBig.getCreatetime());
                    jOrderMonth.setModifyId(orderBig.getModifyid());
                    jOrderMonth.setModifyTime(orderBig.getModifytime());
                    jOrderMonth.setRemark(orderBig.getBackup());
                    jOrderMonth.setIsDel(orderBig.getIsDel() == 0 ? 16 : 17);
                    jOrderMonthMapper.insertSelective(jOrderMonth);
                    return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", jOrderMonth);
                case 3:
                    jOrderTemp.setOrderId(orderBig.getOrderId());
                    jOrderTemp.setCustomerId(orderBig.getCustomerId());
                    jOrderTemp.setShopId(orderBig.getShopId());
                    jOrderTemp.setHouseId(orderBig.getHouseId());
                    jOrderTemp.setOrderStatus(DBMoveUtil.getOrderStatus(orderBig.getOrderStatus()));
                    jOrderTemp.setGoodsId(orderBig.getPriceId());
                    jOrderTemp.setOrderDate(orderBig.getOrderStartDate());
                    jOrderTemp.setTeacherId(orderBig.getTeacher());
                    jOrderTemp.setCreateId(orderBig.getCreateid());
                    jOrderTemp.setCreateTime(orderBig.getCreatetime());
                    jOrderTemp.setModifyId(orderBig.getModifyid());
                    jOrderTemp.setModifyTime(orderBig.getModifytime());
                    jOrderTemp.setRemark(orderBig.getBackup());
                    jOrderTemp.setIsDel(orderBig.getIsDel() == 0 ? 16 : 17);
                    jOrderTemp.setUnitPrice(new BigDecimal(orderBig.getPrice()));
                    jOrderTemp.setTotalPrice(new BigDecimal(orderBig.getTotalPrice()));
                    jOrderTempMapper.insertSelective(jOrderTemp);
                    return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", jOrderTemp);
                case 5:
                    jOrderYears.setOrderId(orderBig.getOrderId());
                    jOrderYears.setCustomerId(orderBig.getCustomerId());
                    jOrderYears.setShopId(orderBig.getShopId());
                    jOrderYears.setHouseId(orderBig.getHouseId());
                    jOrderYears.setServiceId(0);
                    jOrderYears.setOrderStatus(DBMoveUtil.getOrderStatus(orderBig.getOrderStatus()));
                    jOrderYears.setStartDate(orderBig.getOrderStartDate());
                    jOrderYears.setEndDate(orderBig.getOrderEndDate());
                    jOrderYears.setGoodsId(orderBig.getPriceId());
                    jOrderYears.setSupplierId(0);
                    jOrderYears.setTeacherId(orderBig.getTeacher());
                    jOrderYears.setCreateId(orderBig.getCreateid());
                    jOrderYears.setCreateTime(orderBig.getCreatetime());
                    jOrderYears.setModifyId(orderBig.getModifyid());
                    jOrderYears.setModifyTime(orderBig.getModifytime());
                    jOrderYears.setServiceFees(new BigDecimal(orderBig.getPrice()));
                    jOrderYears.setAgencyFees(orderBig.getDeposit());
                    jOrderYears.setRemark(orderBig.getBackup());
                    jOrderYears.setIsDel(orderBig.getIsDel() == 0 ? 16 : 17);
                    jOrderYearsMapper.insertSelective(jOrderYears);
                    return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", jOrderYears);
                default:
                    return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", null);
            }
        }
        return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", null);}

    @RequestMapping(value = "/SmallOrder")
    @ResponseBody
    public Object SmallOrder(@RequestBody Map map) {
        List<Coupon> couponList = couponMapper.selectList(new EntityWrapper<Coupon>());
        List<JCoupon> jCouponList = new ArrayList<>();
        for (Coupon coupon : couponList) {
            JCoupon jCoupon = new JCoupon();
            jCoupon.setCouponId(coupon.getCouponid());
            jCoupon.setIsDel(coupon.getIsdel() == 0 ? 16 : 17);
            jCoupon.setOrderMiniPrice(new BigDecimal(0));
            jCoupon.setCouponPrice(coupon.getCouponprice());
            jCoupon.setCouponOrigin(coupon.getCouponid() == 1 ? 35 : coupon.getCouponid() == 2 ? 35 : coupon.getCouponid() == 3 ? 35 : 36);
            jCoupon.setCouponName(coupon.getCouponname());
            jCoupon.setCouponDetail(coupon.getCoupondetail());
            jCoupon.setCreateTime(coupon.getCreatetime());
            Date date = new Date();
            jCoupon.setValidTime(new Date(date.getTime() + 31536000));
            jCouponList.add(jCoupon);
        }
        jCouponMapper.insertBatch(jCouponList);
        return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 ", null);
    }
}
