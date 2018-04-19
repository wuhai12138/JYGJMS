package com.summ.controller.order;

import com.alibaba.druid.sql.ast.expr.SQLCharExpr;
import com.summ.controller.basic.AutoMapperController;
import com.summ.mapper.JGoodsCostMapper;
import com.summ.mapper.JSupplierMapper;
import com.summ.model.*;
import com.summ.model.request.OrderScheduleReq;
import com.summ.model.request.ServiceWeeksTimeReq;
import com.summ.model.response.ModelRes;
import com.summ.model.response.OrderScheduleRes;
import com.summ.model.response.OrderTempNannyRes;
import com.summ.model.response.OrderTempSupplierRes;
import com.summ.utils.*;
import org.apache.commons.collections.map.HashedMap;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author jygj_7500
 */
@Controller
@RequestMapping("/order/temp/schedule")
public class OrderTempScheduleController extends AutoMapperController {

    /**
     * 若选自营服务，查找自营服务师
     *
     * @param map
     * @return
     */
    @RequestMapping("/nanny")
    @ResponseBody
    public Object getNannyInfo(@RequestBody Map map) {
        try {

            Integer orderId = (Integer) map.get("orderId");
            String nannyName = (String) map.get("name");

            List<OrderTempNannyRes> list = jNannyInfoMapper.getOrderTempNannyList(orderId, nannyName);
            return new ModelRes(ModelRes.Status.SUCCESS,"操作成功  !", ResponseUtil.List2Map(list));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }

    }

    /**
     * 若选供应商，查找供应商列表
     *
     * @param map
     * @return
     */
    @RequestMapping("/supplier")
    @ResponseBody
    public Object getSupplierInfo(@RequestBody Map map) {
        try {

            Integer orderId = (Integer) map.get("orderId");
            String supplierName = (String) map.get("name");
            List<OrderTempSupplierRes> list = jGoodsCostMapper.getSupplierList(orderId, supplierName);
            return new ModelRes(ModelRes.Status.SUCCESS,"操作成功  !", ResponseUtil.List2Map(list));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }

    }

    /**
     * 生成日程
     *
     * @param map
     * @return
     */
    @RequestMapping("/generate")
    @ResponseBody
    public Object generate(@RequestBody Map map) {
        try {
            /**type区分是自营还是供应商*/
            Integer type = (Integer) map.get("type");
            Integer orderId = (Integer) map.get("orderId");
            Integer nannyId = (Integer) map.get("id");
            Integer startTime = (Integer) map.get("startTime");
            Integer endTime = (Integer) map.get("endTime");
            JOrderTemp jOrderTemp = jOrderTempMapper.selectById(Long.valueOf(orderId));
            JScheduleNanny jScheduleNanny = new JScheduleNanny();
            /**
             * 使用自营服务师
             */
            if (type == 1) {
                //验证订单时间和服务师时间是否冲突
                ServiceWeeksTimeReq serviceWeeksTimeReq = new ServiceWeeksTimeReq();
                serviceWeeksTimeReq.setNannyId(nannyId);
                serviceWeeksTimeReq.setLongList(NannyWorkTimeUtil.id2Value(startTime, endTime));
                List<String> weekList = new ArrayList<String>();
                serviceWeeksTimeReq.setWeekList(weekList);
                serviceWeeksTimeReq.setStartDate(jOrderTemp.getOrderDate());
                serviceWeeksTimeReq.setEndDate(new Date(jOrderTemp.getOrderDate().getTime() + (24 * 3600 * 1000)));

                /**换算开始结束时间*/
                Map map1 = JsonUtil.Obj2Map(serviceWeeksTimeReq);
                map1.put("startDate",new Date((Long) map1.get("startDate")));
                map1.put("endDate",new Date((Long) map1.get("endDate")));
                //判断该服务师的工时是否符合订单时间要求
                List<JNannyInfo> signNannyWorkTime = jNannyWorkTimeMapper.signNannyWorkTime(map1);
                if (signNannyWorkTime.size() < 1) {
                    return new ModelRes(ModelRes.Status.FAILED, "服务师工时不匹配 ! !", null);
                }
                //判断该服务师的日程是否符合订单时间要求
                List<JOrderSchedule> signNannySchedule = jOrderScheduleMapper.signNannySchedule(map1);
                if (signNannySchedule.size() > 0) {
                    return new ModelRes(ModelRes.Status.FAILED, "服务师日程占用 ! !", ResponseUtil.List2Map(signNannySchedule));
                }

                jScheduleNanny.setSupplierId(1);
                jScheduleNanny.setNannyId(nannyId);
            }
            if (type == -1) {
                /**此处验证带教工时*/
                //...
            }
            JOrderSchedule jOrderSchedule = new JOrderSchedule();
            if (jOrderTemp.getPayStatus()==158){
                jOrderSchedule.setPayStatus(158);
            }
            jOrderSchedule.setOrderId(jOrderTemp.getOrderId());
            jOrderSchedule.setOrderType(164);
            jOrderSchedule.setScheduleDate(jOrderTemp.getOrderDate());
            jOrderSchedule.setStartTime(jOrderTemp.getStartTime());
            jOrderSchedule.setEndTime(jOrderTemp.getEndTime());
            jOrderSchedule.setStartTimeValue(jOrderTemp.getStartTimeValue());
            jOrderSchedule.setEndTimeValue(jOrderTemp.getEndTimeValue());
            jOrderSchedule.setTimeValue(NannyWorkTimeUtil.getTimeListValue(startTime, endTime));
            jOrderSchedule.setWeekday(DateUtil.dateAndday(jOrderTemp.getOrderDate()));
            jOrderScheduleMapper.insertSelective(jOrderSchedule);

            /**生成日程服务师*/
            jScheduleNanny.setNannyId(nannyId);
            if (type == 1) {
                jScheduleNanny.setSupplierId(type);
            } else if (type == -1) {
                jScheduleNanny.setSupplierId(type);
            } else {
                jScheduleNanny.setSupplierId(nannyId);
            }
            jScheduleNanny.setScheduleId(jOrderSchedule.getScheduleId());
            jScheduleNannyMapper.insertSelective(jScheduleNanny);

            return new ModelRes(ModelRes.Status.SUCCESS, "已生成日程!", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody OrderScheduleReq orderScheduleReq) {
        try {
            /**指定为临时订单表的orderId*/
            orderScheduleReq.setOrderType(164);

            JOrderTemp jOrderTemp = jOrderTempMapper.selectById(Long.valueOf(orderScheduleReq.getOrderId()));
            List<OrderScheduleRes> orderScheduleResList = jOrderScheduleMapper.getTempScheduleList(orderScheduleReq.getOrderId());

            for (OrderScheduleRes orderScheduleRes : orderScheduleResList) {
                /**判断是不是需要实时计算成本 0则表明需要实时计算*/
                if (orderScheduleRes.getCost().compareTo(new BigDecimal(0)) == 0) {
                    /**判断日程是自营还是供应商提供 1为自营*/
                    if (orderScheduleRes.getSupplierId() == 1) {
                        JNannyInfo jNannyInfo = jNannyInfoMapper.selectById(Long.valueOf(orderScheduleRes.getNannyId()));
                        JDictInfo jDictInfo = jDictInfoMapper.selectById(Long.valueOf(jNannyInfo.getNannyLevel()));
                        /**根据服务师星级小时工资与日程工作时长计算成本*/
                        orderScheduleRes.setCost(new BigDecimal(jDictInfo.getInfo()).multiply(new BigDecimal(String.valueOf((orderScheduleRes.getEndTime() - orderScheduleRes.getStartTime()) / 2f))).setScale(2));
                        orderScheduleRes.setNannyName(jNannyInfo.getNannyName());
                        orderScheduleRes.setNannyPhone(jNannyInfo.getNannyPhone());
                    } else if (orderScheduleRes.getSupplierId() == -1) {
                        /**此处验证带教工时*/
                        //...
                    } else {
                        JSupplier jSupplier = jSupplierMapper.selectById(Long.valueOf(orderScheduleRes.getSupplierId()));
                        Map map = new HashMap();
                        map.put("goodsId", jOrderTemp.getGoodsId());
                        map.put("supplierId", orderScheduleRes.getSupplierId());
                        List<JGoodsCost> jGoodsCostList = jGoodsCostMapper.selectByMap(map);
                        /**根据供应商单位成本与订单产品的数量（平方米/个数）计算成本*/
                        orderScheduleRes.setCost(jGoodsCostList.get(0).getCost().multiply(new BigDecimal(jOrderTemp.getServiceAmount())).setScale(2));
                        orderScheduleRes.setNannyPhone(jSupplier.getPhone());
                        orderScheduleRes.setNannyName(jSupplier.getName());
                    }
                }
            }
            Map map = ResponseUtil.List2Map(orderScheduleResList);
            map.put("count", jOrderScheduleMapper.getScheduleCount(orderScheduleReq));
            return new ModelRes(ModelRes.Status.SUCCESS,"操作成功  !", map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 暂停
     *
     * @param jOrderScheduleList
     * @return
     */
    @ResponseBody
    @RequestMapping("/suspend")
    public Object suspend(@RequestBody Map<String, List<Integer>> jOrderScheduleList) {
        try {
            List<Integer> list = jOrderScheduleList.get("list");
            List<JOrderSchedule> orderScheduleList = new ArrayList<JOrderSchedule>();

            for (int i = 0; i < list.size(); i++) {
                JOrderSchedule jOrderSchedule = new JOrderSchedule();
                jOrderSchedule.setScheduleStatus(154);
                jOrderSchedule.setScheduleId(list.get(i));
                jOrderSchedule.setSuspendTime(new Date());
                orderScheduleList.add(jOrderSchedule);
            }
            return new ModelRes(ModelRes.Status.SUCCESS,"操作成功  !", jOrderScheduleMapper.updateBatchById(orderScheduleList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 签到
     *
     * @param listMap
     * @return
     */
    @ResponseBody
    @RequestMapping("/clock")
    public Object clock(@RequestBody Map<String, List<Integer>> listMap) {
        try {
            List<Integer> list = listMap.get("list");
            List<JOrderSchedule> orderScheduleList = new ArrayList<JOrderSchedule>();

            for (int i = 0; i < list.size(); i++) {
                JOrderSchedule jOrderSchedule = new JOrderSchedule();
                jOrderSchedule.setScheduleStatus(153);
                jOrderSchedule.setPayStatus(158);
                jOrderSchedule.setScheduleId(list.get(i));
                jOrderSchedule.setClockTime(new Date());
                orderScheduleList.add(jOrderSchedule);
            }
            return new ModelRes(ModelRes.Status.SUCCESS,"操作成功  !", jOrderScheduleMapper.updateBatchById(orderScheduleList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 完工
     *
     * @param jOrderScheduleList
     * @return
     */
    @ResponseBody
    @RequestMapping("/complete")
    public Object complete(@RequestBody Map<String, List<Integer>> jOrderScheduleList) {
        try {
            List<Integer> list = jOrderScheduleList.get("list");
            List<JOrderSchedule> orderScheduleList = new ArrayList<JOrderSchedule>();

            for (int i = 0; i < list.size(); i++) {
                JOrderSchedule jOrderSchedule = new JOrderSchedule();
                jOrderSchedule.setScheduleStatus(156);
                jOrderSchedule.setScheduleId(list.get(i));
                jOrderSchedule.setCompletedTime(new Date());
                orderScheduleList.add(jOrderSchedule);
            }
            return new ModelRes(ModelRes.Status.SUCCESS,"操作成功  !", jOrderScheduleMapper.updateBatchById(orderScheduleList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 结算
     *
     * @param list
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkout")
    public Object checkout(@RequestBody Map<String, List<Integer>> list, ServletRequest request) {
        List<Integer> scheduleIdList = list.get("list");
        List<OrderScheduleRes> orderScheduleResList = jOrderScheduleMapper.getTempScheduleListByList(scheduleIdList);

        /**判断支付状态*/
        for (int i = 0; i < orderScheduleResList.size(); i++) {
            if (orderScheduleResList.get(i).getPayStatus() == 158) {
                return new ModelRes(ModelRes.Status.FAILED, "有订单已结算 !", null);
            }
        }

        /**服务师对账单列表*/
        List<JNannyStatment> jNannyStatmentList = new ArrayList<JNannyStatment>();
        /**供应商对账单列表*/
        List<JSupplierStatment> jSupplierStatmentList = new ArrayList<JSupplierStatment>();

        for (OrderScheduleRes orderScheduleRes : orderScheduleResList) {
            JOrderTemp jOrderTemp = jOrderTempMapper.selectById(Long.valueOf(orderScheduleRes.getOrderId()));

            /**判断是不是需要实时计算成本 0则表明需要实时计算*/
            if (orderScheduleRes.getCost().compareTo(new BigDecimal(0)) == 0) {
                if (orderScheduleRes.getSupplierId() == 1) {
                    JNannyInfo jNannyInfo = jNannyInfoMapper.selectById(Long.valueOf(orderScheduleRes.getNannyId()));
                    JDictInfo jDictInfo = jDictInfoMapper.selectById(Long.valueOf(jNannyInfo.getNannyLevel()));
                    /**根据服务师星级小时工资与日程工作时长计算成本*/
                    orderScheduleRes.setCost(new BigDecimal(jDictInfo.getInfo()).multiply(new BigDecimal(String.valueOf((orderScheduleRes.getEndTime() - orderScheduleRes.getStartTime()) / 2f))).setScale(2));
                } else {
                    Map map = new HashMap();
                    map.put("goodsId", jOrderTemp.getGoodsId());
                    map.put("supplierId", orderScheduleRes.getSupplierId());
                    List<JGoodsCost> jGoodsCostList = jGoodsCostMapper.selectByMap(map);
                    /**根据供应商单位成本与订单产品的数量（平方米/个数）计算成本*/
                    orderScheduleRes.setCost(jGoodsCostList.get(0).getCost().multiply(new BigDecimal(jOrderTemp.getServiceAmount())).setScale(2));
                }
            }

            /**服务时间*/
            String serviceTime = orderScheduleRes.getStartTimeValue() + "-" + orderScheduleRes.getEndTimeValue();
            Double serviceTimeLength = Double.valueOf((orderScheduleRes.getEndTime() - orderScheduleRes.getStartTime()) / 2f);
            /**判断日程是自营还是供应商提供 1为自营*/
            if (orderScheduleRes.getSupplierId() == 1) {
                Map map = new HashedMap();
                map.put("scheduleId", orderScheduleRes.getScheduleId());
                List<JScheduleNanny> jScheduleNannyList = jScheduleNannyMapper.selectByMap(map);
                JNannyStatment jNannyStatment = new JNannyStatment(OrderUtil.generateStamentNumber(orderScheduleRes.getNannyId()),
                        jScheduleNannyList.get(0).getNannyId(),
                        orderScheduleRes.getScheduleId(), orderScheduleRes.getOrderId(),
                        jOrderTemp.getShopId(), jOrderTemp.getHouseId(), jOrderTemp.getCustomerId(),
                        166, orderScheduleRes.getCost(), 164, jOrderTemp.getShopId(), serviceTime, serviceTimeLength,
                        orderScheduleRes.getScheduleDate(), "");
                jNannyStatmentList.add(jNannyStatment);

            } else {
                JSupplierStatment jSupplierStatment = new JSupplierStatment(OrderUtil.generateStamentNumber(orderScheduleRes.getNannyId()),
                        orderScheduleRes.getSupplierId(), orderScheduleRes.getScheduleId(), orderScheduleRes.getOrderId(),
                        jOrderTemp.getShopId(), jOrderTemp.getHouseId(), jOrderTemp.getCustomerId(), 174, orderScheduleRes.getCost(),
                        164, jOrderTemp.getGoodsId(), serviceTime, serviceTimeLength, orderScheduleRes.getScheduleDate(), new Date(), "");
                jSupplierStatmentList.add(jSupplierStatment);
            }
        }

        if (jNannyStatmentList.size() > 0) {
            jNannyStatmentMapper.insertBatch(jNannyStatmentList);
        }
        if (jSupplierStatmentList.size() > 0) {
            jSupplierStatmentMapper.insertBatch(jSupplierStatmentList);
        }
        return new ModelRes(ModelRes.Status.SUCCESS, "", null);
    }
}
