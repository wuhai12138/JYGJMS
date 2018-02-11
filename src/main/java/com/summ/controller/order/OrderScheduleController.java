package com.summ.controller.order;

import com.summ.controller.basic.AutoMapperController;
import com.summ.mapper.JGoodsContractMapper;
import com.summ.mapper.JScheduleNannyMapper;
import com.summ.model.*;
import com.summ.model.request.OrderScheduleReq;
import com.summ.model.request.ServiceWeeksTimeReq;
import com.summ.model.response.*;
import com.summ.utils.*;
import com.summ.utils.mongodb.MongoDBUtil;
import com.summ.utils.mongodb.model.MongoConfig;
import com.sun.tools.internal.xjc.reader.dtd.bindinfo.BIAttribute;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.ls.LSException;

import javax.servlet.ServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * 订单日程
 *
 * @author jygj_7500
 * @date 18/1/13
 */

@Controller
@RequestMapping("/order/schedule")
public class OrderScheduleController extends AutoMapperController {

    /**
     * 生成合同订单日程
     * @param reqMap
     * @return
     */
    @ResponseBody
    @RequestMapping("/generate")
    public Object insert(@RequestBody Map reqMap) {
        try {
            //日程列表用以存放订单日程
            List<JOrderSchedule> orderScheduleList = new ArrayList<JOrderSchedule>();
            //服务师日程列表用以存放日程的服务师
            List<JScheduleNanny> scheduleNannyList = new ArrayList<JScheduleNanny>();

            List<Long> orderIdList = (List<Long>) reqMap.get("orderId");
            Integer nannyId = (Integer) reqMap.get("nannyId");
            Date startDate = (Date) reqMap.get("startDate");
            Date endDate = (Date) reqMap.get("endDate");

            /**验证服务师工时*/
            //获取合同订单列表
            List<JOrderContract> jOrderContractList = jOrderContractMapper.selectBatchIds(orderIdList);
            //目前只使用验证一个订单，所以日期只需改变数组第一个订单的时间
            jOrderContractList.get(0).setStartDate(startDate);
            jOrderContractList.get(0).setEndDate(endDate);
            //连接mongodb数据库
            mongoDBUtil = MongoDBUtil.getInstance(new MongoConfig("192.168.1.148", 27017, "logger", "log", "123"));

            //存储订单列表对应的星期列表和时间列表和日期列表
            List<Date> startDateLIst = new ArrayList<Date>();
            List<Date> endDateLIst = new ArrayList<Date>();
            List<List<Map>> weeksList = new ArrayList<List<Map>>();
            List<List<Long>> timesList = new ArrayList<List<Long>>();
            for (int i = 0; i < jOrderContractList.size(); i++) {
                Map mongoMap = new HashedMap();
                mongoMap.put("serviceId", jOrderContractList.get(i).getServiceId());
                Map mapJson = JsonUtil.json2Map(mongoDBUtil.query("customer_service", mongoMap));

                List<Map> weeks = (List<Map>) mapJson.get("weekListTime");
                List<Map> times = (List<Map>) mapJson.get("addTime");
                //计算出每天的所有时间id数组
                List<Long> timeList = new ArrayList<Long>();
                for (int j = 0; j < times.size(); j++) {
                    timeList.addAll(NannyWorkTimeUtil.id2Value((Integer) times.get(j).get("startId"), (Integer) times.get(j).get("endId")));
                }

                weeksList.add(weeks);
                timesList.add(timeList);
                startDateLIst.add(jOrderContractList.get(i).getStartDate());
                endDateLIst.add(jOrderContractList.get(i).getEndDate());

            }

//            //判断订单之间时间是否冲突
//            if (weeksList.size()>1){
//                for (int i = 0; i < weeksList.size()-1; i++) {
//                    for (int j=i+1;j<weeksList.size();j++){
//                        for (int k=0;k<weeksList.get(0).size();k++){
//                            List<Map> weekA = weeksList.get(i);
//                            List<Map> weekB = weeksList.get(j);
//                        }
//                    }
//                }
//
//            }

            //循环订单判断订单与服务师是否冲突
            for (int x = 0; x < orderIdList.size(); x++) {
                ServiceWeeksTimeReq serviceWeeksTimeReq = new ServiceWeeksTimeReq();
                //服务师id
                serviceWeeksTimeReq.setNannyId(nannyId);
                //订单计划书需求时间值列表
                serviceWeeksTimeReq.setLongList(timesList.get(x));
                //订单开始结束时间
                serviceWeeksTimeReq.setStartDate(jOrderContractList.get(x).getStartDate());
                serviceWeeksTimeReq.setEndDate(jOrderContractList.get(x).getEndDate());
                //weekList为星期列表，用于验证服务师的日程与订单是否冲突
                List<String> weekListTemp = new ArrayList<String>();
                for (int i = 0; i < weeksList.get(x).size(); i++) {
                    if ("true".equals(weeksList.get(x).get(i).get("active").toString())) {
                        if ("周一".equals(weeksList.get(x).get(i).get("value").toString())) {
                            serviceWeeksTimeReq.setMonday("周一");
                            weekListTemp.add("周一");
                        }
                        if ("周二".equals(weeksList.get(x).get(i).get("value").toString())) {
                            serviceWeeksTimeReq.setTuesday("周二");
                            weekListTemp.add("周二");
                        }
                        if ("周三".equals(weeksList.get(x).get(i).get("value").toString())) {
                            serviceWeeksTimeReq.setWednesday("周三");
                            weekListTemp.add("周三");
                        }
                        if ("周四".equals(weeksList.get(x).get(i).get("value").toString())) {
                            serviceWeeksTimeReq.setThursday("周四");
                            weekListTemp.add("周四");
                        }
                        if ("周五".equals(weeksList.get(x).get(i).get("value").toString())) {
                            serviceWeeksTimeReq.setFriday("周五");
                            weekListTemp.add("周五");
                        }
                        if ("周六".equals(weeksList.get(x).get(i).get("value").toString())) {
                            serviceWeeksTimeReq.setSaturday("周六");
                            weekListTemp.add("周六");
                        }
                        if ("周天".equals(weeksList.get(x).get(i).get("value").toString())) {
                            serviceWeeksTimeReq.setSunday("周天");
                            weekListTemp.add("周天");
                        }
                    }
                }
                serviceWeeksTimeReq.setWeekList(weekListTemp);

                System.out.println(">>>>>>>>sql>>>>>>>>>>>>>" + JsonUtil.Obj2Map(serviceWeeksTimeReq).toString());
                //判断该服务师的工时是否符合订单时间要求
                List<JNannyInfo> signNannyWorkTime = jNannyWorkTimeMapper.signNannyWorkTime(JsonUtil.Obj2Map(serviceWeeksTimeReq));
                if (signNannyWorkTime.size() < 1) {
                    return new ModelRes(ModelRes.Status.FAILED, "服务师工时不匹配 ! !", null);
                }
                //判断该服务师的日程是否符合订单时间要求
                List<JOrderSchedule> signNannySchedule = jOrderScheduleMapper.signNannySchedule(JsonUtil.Obj2Map(serviceWeeksTimeReq));
                if (signNannySchedule.size() > 0) {
                    return new ModelRes(ModelRes.Status.FAILED, "服务师日程占用 ! !", ResponseUtil.List2Map(signNannySchedule));
                }
            }





            /**生成日程*/
            //订单相关信息
//            List<JOrderContract> jOrderContractList = jOrderContractMapper.selectBatchIds(orderIdList);
            for (int m =0;m<jOrderContractList.size();m++){
                Integer houseId = jOrderContractList.get(m).getHouseId();
                Map mapService = new HashedMap();
                mapService.put("houseId", houseId);
                //根据房产id获取服务计划书id
                List<JCustomerService> jCustomerService = jCustomerServiceMapper.selectByMap(mapService);
                //根据服务计划书去MongoDB获取计划书详情json
                Map mapMongo = new HashedMap();
                mapMongo.put("serviceId", jCustomerService.get(0).getServiceId());
                mongoDBUtil = MongoDBUtil.getInstance(new MongoConfig("192.168.1.148", 27017, "logger", "log", "123"));
                String serviceJson = mongoDBUtil.query("customer_service", mapMongo);
                //解析json
                Map mapJson = JsonUtil.json2Map(serviceJson);
                //计划书星期列表：[{"value":"周一","id":"1","active":true},{"value":"周二","id":"2","active":true},{"value":"周三","id":"3","active":true},{"value":"周四","id":"4","active":true},{"value":"周五","id":"5","active":true},{"value":"周六","id":"6","active":true},{"value":"周天","id":"7","active":true}]
                List<Map> weeks = (List<Map>) mapJson.get("weekListTime");
                //计划书每天时间列表：[{"startId":23,"endId":25,"startTime":"03:30","start":"00:00","end":"24:00","endTime":"","firstSelect":false,"or":1},{"startId":37,"endId":39,"startTime":"03:30","start":"00:00","end":"24:00","endTime":"","firstSelect":false,"or":1}]
                List<Map> times = (List<Map>) mapJson.get("addTime");
                System.out.println(">>>>>>>times>>>" + times);

                //循环计划书中的weekListTime 即一周的七天
                for (int i = 0; i < weeks.size(); i++) {
                    if ("true".equals(weeks.get(i).get("active").toString())) {
                        if ("周一".equals(weeks.get(i).get("value").toString())) {
                            List<Date> dateList = DateUtil.weekAndDay(1, jOrderContractList.get(m).getStartDate(), jOrderContractList.get(m).getEndDate());
                            //循环每天的时间区间，几个区间则分别生成几个区间的日程
                            for (int k = 0; k < times.size(); k++) {
                                //根据订单开始结束日期计算出有多少个周一，并循环
                                for (int j = 0; j < dateList.size(); j++) {
                                    //日程信息
                                    JOrderSchedule jOrderSchedule = new JOrderSchedule();
                                    jOrderSchedule.setScheduleStatus(152);
                                    jOrderSchedule.setPayStatus(157);
                                    jOrderSchedule.setStartTime((Integer) times.get(k).get("startId"));
                                    jOrderSchedule.setEndTime((Integer) times.get(k).get("endId"));
                                    jOrderSchedule.setStartTimeValue(NannyWorkTimeUtil.id2Time(jOrderSchedule.getStartTime()));
                                    jOrderSchedule.setEndTimeValue(NannyWorkTimeUtil.id2Time(jOrderSchedule.getEndTime()));
                                    jOrderSchedule.setTimeValue(NannyWorkTimeUtil.getTimeListValue((Integer) times.get(k).get("startId"), (Integer) times.get(k).get("endId")));
                                    //订单id
                                    jOrderSchedule.setOrderId(jOrderContractList.get(m).getOrderId());
                                    //价格改变为实时变动的，此处生成日程时不做输入
                                    //单价
//                                jOrderSchedule.setUnitPrice(jGoodsContract.getPrice());
                                    //总价 单价乘以上工小时数，格式为big decimal，保留两位小数
//                                jOrderSchedule.setTotalPrice(jGoodsContract.getPrice().multiply(new BigDecimal(((Integer) times.get(k).get("endId") - (Integer) times.get(k).get("startId")) / 2f)).setScale(2));
                                    //成本（取决于服务师薪资）
//                                jOrderSchedule.setCost(new BigDecimal(nannyInfoRes.getNannyLevelInfo()).multiply(new BigDecimal(((Integer) times.get(k).get("endId") - (Integer) times.get(k).get("startId")) / 2f)).setScale(2));
                                    jOrderSchedule.setScheduleDate(dateList.get(j));
                                    jOrderSchedule.setWeekday("周一");
                                    orderScheduleList.add(jOrderSchedule);


                                }
                            }
                        }
                        if ("周二".equals(weeks.get(i).get("value").toString())) {
                            List<Date> dateList = DateUtil.weekAndDay(2, jOrderContractList.get(m).getStartDate(), jOrderContractList.get(m).getEndDate());
                            for (int k = 0; k < times.size(); k++) {
                                //根据订单开始结束日期计算出有多少个周一，并循环
                                for (int j = 0; j < dateList.size(); j++) {
                                    //日程信息
                                    JOrderSchedule jOrderSchedule = new JOrderSchedule();
                                    jOrderSchedule.setScheduleStatus(152);
                                    jOrderSchedule.setPayStatus(157);
                                    jOrderSchedule.setStartTime((Integer) times.get(k).get("startId"));
                                    jOrderSchedule.setEndTime((Integer) times.get(k).get("endId"));
                                    jOrderSchedule.setStartTimeValue(NannyWorkTimeUtil.id2Time(jOrderSchedule.getStartTime()));
                                    jOrderSchedule.setEndTimeValue(NannyWorkTimeUtil.id2Time(jOrderSchedule.getEndTime()));
                                    jOrderSchedule.setTimeValue(NannyWorkTimeUtil.getTimeListValue((Integer) times.get(k).get("startId"), (Integer) times.get(k).get("endId")));
                                    //订单id
                                    jOrderSchedule.setOrderId(jOrderContractList.get(m).getOrderId());
                                    jOrderSchedule.setScheduleDate(dateList.get(j));
                                    jOrderSchedule.setWeekday("周二");
                                    orderScheduleList.add(jOrderSchedule);

                                }
                            }
                        }
                        if ("周三".equals(weeks.get(i).get("value").toString())) {
                            List<Date> dateList = DateUtil.weekAndDay(3, jOrderContractList.get(m).getStartDate(), jOrderContractList.get(m).getEndDate());
                            for (int k = 0; k < times.size(); k++) {
                                //根据订单开始结束日期计算出有多少个周一，并循环
                                for (int j = 0; j < dateList.size(); j++) {
                                    //日程信息
                                    JOrderSchedule jOrderSchedule = new JOrderSchedule();
                                    jOrderSchedule.setScheduleStatus(152);
                                    jOrderSchedule.setPayStatus(157);
                                    jOrderSchedule.setStartTime((Integer) times.get(k).get("startId"));
                                    jOrderSchedule.setEndTime((Integer) times.get(k).get("endId"));
                                    jOrderSchedule.setStartTimeValue(NannyWorkTimeUtil.id2Time(jOrderSchedule.getStartTime()));
                                    jOrderSchedule.setEndTimeValue(NannyWorkTimeUtil.id2Time(jOrderSchedule.getEndTime()));
                                    jOrderSchedule.setTimeValue(NannyWorkTimeUtil.getTimeListValue((Integer) times.get(k).get("startId"), (Integer) times.get(k).get("endId")));
                                    //订单id
                                    jOrderSchedule.setOrderId(jOrderContractList.get(m).getOrderId());
                                    jOrderSchedule.setScheduleDate(dateList.get(j));
                                    jOrderSchedule.setWeekday("周三");
                                    orderScheduleList.add(jOrderSchedule);

                                }
                            }
                        }
                        if ("周四".equals(weeks.get(i).get("value").toString())) {
                            List<Date> dateList = DateUtil.weekAndDay(4, jOrderContractList.get(m).getStartDate(), jOrderContractList.get(m).getEndDate());
                            for (int k = 0; k < times.size(); k++) {
                                //根据订单开始结束日期计算出有多少个周一，并循环
                                for (int j = 0; j < dateList.size(); j++) {
                                    //日程信息
                                    JOrderSchedule jOrderSchedule = new JOrderSchedule();
                                    jOrderSchedule.setScheduleStatus(152);
                                    jOrderSchedule.setPayStatus(157);
                                    jOrderSchedule.setStartTime((Integer) times.get(k).get("startId"));
                                    jOrderSchedule.setEndTime((Integer) times.get(k).get("endId"));
                                    jOrderSchedule.setStartTimeValue(NannyWorkTimeUtil.id2Time(jOrderSchedule.getStartTime()));
                                    jOrderSchedule.setEndTimeValue(NannyWorkTimeUtil.id2Time(jOrderSchedule.getEndTime()));
                                    jOrderSchedule.setTimeValue(NannyWorkTimeUtil.getTimeListValue((Integer) times.get(k).get("startId"), (Integer) times.get(k).get("endId")));
                                    //订单id
                                    jOrderSchedule.setOrderId(jOrderContractList.get(m).getOrderId());
                                    jOrderSchedule.setScheduleDate(dateList.get(j));
                                    jOrderSchedule.setWeekday("周四");
                                    orderScheduleList.add(jOrderSchedule);

                                }
                            }
                        }
                        if ("周五".equals(weeks.get(i).get("value").toString())) {
                            List<Date> dateList = DateUtil.weekAndDay(5, jOrderContractList.get(m).getStartDate(), jOrderContractList.get(m).getEndDate());
                            for (int k = 0; k < times.size(); k++) {
                                //根据订单开始结束日期计算出有多少个周一，并循环
                                for (int j = 0; j < dateList.size(); j++) {
                                    //日程信息
                                    JOrderSchedule jOrderSchedule = new JOrderSchedule();
                                    jOrderSchedule.setScheduleStatus(152);
                                    jOrderSchedule.setPayStatus(157);
                                    jOrderSchedule.setStartTime((Integer) times.get(k).get("startId"));
                                    jOrderSchedule.setEndTime((Integer) times.get(k).get("endId"));
                                    jOrderSchedule.setStartTimeValue(NannyWorkTimeUtil.id2Time(jOrderSchedule.getStartTime()));
                                    jOrderSchedule.setEndTimeValue(NannyWorkTimeUtil.id2Time(jOrderSchedule.getEndTime()));
                                    jOrderSchedule.setTimeValue(NannyWorkTimeUtil.getTimeListValue((Integer) times.get(k).get("startId"), (Integer) times.get(k).get("endId")));
                                    //订单id
                                    jOrderSchedule.setOrderId(jOrderContractList.get(m).getOrderId());
                                    jOrderSchedule.setScheduleDate(dateList.get(j));
                                    jOrderSchedule.setWeekday("周五");
                                    orderScheduleList.add(jOrderSchedule);

                                }
                            }
                        }
                        if ("周六".equals(weeks.get(i).get("value").toString())) {
                            List<Date> dateList = DateUtil.weekAndDay(6, jOrderContractList.get(m).getStartDate(), jOrderContractList.get(m).getEndDate());
                            for (int k = 0; k < times.size(); k++) {
                                //根据订单开始结束日期计算出有多少个周一，并循环
                                for (int j = 0; j < dateList.size(); j++) {
                                    //日程信息
                                    JOrderSchedule jOrderSchedule = new JOrderSchedule();
                                    jOrderSchedule.setScheduleStatus(152);
                                    jOrderSchedule.setPayStatus(157);
                                    jOrderSchedule.setStartTime((Integer) times.get(k).get("startId"));
                                    jOrderSchedule.setEndTime((Integer) times.get(k).get("endId"));
                                    jOrderSchedule.setStartTimeValue(NannyWorkTimeUtil.id2Time(jOrderSchedule.getStartTime()));
                                    jOrderSchedule.setEndTimeValue(NannyWorkTimeUtil.id2Time(jOrderSchedule.getEndTime()));
                                    jOrderSchedule.setTimeValue(NannyWorkTimeUtil.getTimeListValue((Integer) times.get(k).get("startId"), (Integer) times.get(k).get("endId")));
                                    //订单id
                                    jOrderSchedule.setOrderId(jOrderContractList.get(m).getOrderId());
                                    jOrderSchedule.setScheduleDate(dateList.get(j));
                                    jOrderSchedule.setWeekday("周六");
                                    orderScheduleList.add(jOrderSchedule);

                                }
                            }
                        }
                        if ("周天".equals(weeks.get(i).get("value").toString())) {
                            List<Date> dateList = DateUtil.weekAndDay(0, jOrderContractList.get(m).getStartDate(), jOrderContractList.get(m).getEndDate());
                            for (int k = 0; k < times.size(); k++) {
                                //根据订单开始结束日期计算出有多少个周一，并循环
                                for (int j = 0; j < dateList.size(); j++) {
                                    //日程信息
                                    JOrderSchedule jOrderSchedule = new JOrderSchedule();
                                    jOrderSchedule.setScheduleStatus(152);
                                    jOrderSchedule.setPayStatus(157);
                                    jOrderSchedule.setStartTime((Integer) times.get(k).get("startId"));
                                    jOrderSchedule.setEndTime((Integer) times.get(k).get("endId"));
                                    jOrderSchedule.setStartTimeValue(NannyWorkTimeUtil.id2Time(jOrderSchedule.getStartTime()));
                                    jOrderSchedule.setEndTimeValue(NannyWorkTimeUtil.id2Time(jOrderSchedule.getEndTime()));
                                    jOrderSchedule.setTimeValue(NannyWorkTimeUtil.getTimeListValue((Integer) times.get(k).get("startId"), (Integer) times.get(k).get("endId")));
                                    //订单id
                                    jOrderSchedule.setOrderId(jOrderContractList.get(m).getOrderId());
                                    jOrderSchedule.setScheduleDate(dateList.get(j));
                                    jOrderSchedule.setWeekday("周天");
                                    orderScheduleList.add(jOrderSchedule);

                                }
                            }
                        }
                    }
                }
            }



            //添加日程
            jOrderScheduleMapper.insertBatch(orderScheduleList);
            //添加日程的服务师
            for (int i = 0; i < orderScheduleList.size(); i++) {
                JScheduleNanny jScheduleNanny = new JScheduleNanny(orderScheduleList.get(i).getScheduleId(),nannyId);
                scheduleNannyList.add(jScheduleNanny);
            }
            jScheduleNannyMapper.insertBatch(scheduleNannyList);

            return new ModelRes(ModelRes.Status.SUCCESS, "日程添加成功 !", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody OrderScheduleReq orderScheduleReq){
        try {
            orderScheduleReq.setOrderType(163);
            orderScheduleReq.setPage(orderScheduleReq.getSize() * (orderScheduleReq.getPage() - 1));
            List<OrderScheduleRes> orderScheduleResList = jOrderScheduleMapper.getScheduleList(orderScheduleReq);

            for (int i=0;i<orderScheduleResList.size();i++){
                orderScheduleResList.get(i).setUnitPrice(orderScheduleResList.get(i).getScheduleCurrentPrice());
                //判断服务师工资是否为0，是则实时计算出服务师当前工资
                if (orderScheduleResList.get(i).getCost().compareTo(new BigDecimal(0))==0){
                    orderScheduleResList.get(i).setCost(new BigDecimal(orderScheduleResList.get(i).getNannyCurrentPayment()).multiply(new BigDecimal(String.valueOf((orderScheduleResList.get(i).getEndTime()-orderScheduleResList.get(i).getStartTime()) / 2f))).setScale(2));
                }
                //判断日程总价是否为0，是则实时计算出当前总价
                if (orderScheduleResList.get(i).getTotalPrice().compareTo(new BigDecimal(0))==0){
                    orderScheduleResList.get(i).setTotalPrice(orderScheduleResList.get(i).getScheduleCurrentPrice().multiply(new BigDecimal(String.valueOf((orderScheduleResList.get(i).getEndTime()-orderScheduleResList.get(i).getStartTime()) / 2f))).setScale(2));
                }
            }
            Map map = ResponseUtil.List2Map(orderScheduleResList);
            map.put("count",jOrderScheduleMapper.getScheduleCount(orderScheduleReq));
            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !",map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 暂停
     * @return
     */
    @ResponseBody
    @RequestMapping("/suspend")
    public Object suspend(@RequestBody Map<String,List<Integer>> jOrderScheduleList){
        try {
            List<Integer> list = jOrderScheduleList.get("list");
            List<JOrderSchedule> orderScheduleList = new ArrayList<JOrderSchedule>();

            for (int i=0;i<list.size();i++){
                JOrderSchedule jOrderSchedule = new JOrderSchedule();
                jOrderSchedule.setScheduleId(list.get(i));
                jOrderSchedule.setScheduleStatus(154);
                jOrderSchedule.setSuspendTime(new Date());
                orderScheduleList.add(jOrderSchedule);
            }
            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !", jOrderScheduleMapper.updateBatchById(orderScheduleList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 取消
     * @return
     */
    @ResponseBody
    @RequestMapping("/cancel")
    public Object cancel(@RequestBody Map<String,List<Integer>> jOrderScheduleList){
        try {
            List<Integer> list = jOrderScheduleList.get("list");
            List<JOrderSchedule> orderScheduleList = new ArrayList<JOrderSchedule>();

            for (int i=0;i<list.size();i++){
                JOrderSchedule jOrderSchedule = new JOrderSchedule();
                jOrderSchedule.setScheduleId(list.get(i));
                jOrderSchedule.setScheduleStatus(155);
                jOrderSchedule.setCancelTime(new Date());
                orderScheduleList.add(jOrderSchedule);
            }
            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !", jOrderScheduleMapper.updateBatchById(orderScheduleList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 签到
     * @return
     */
    @ResponseBody
    @RequestMapping("/clock")
    public Object clock(@RequestBody Map<String,List<Integer>> jOrderScheduleList){
        try {
            List<Integer> list = jOrderScheduleList.get("list");
            List<JOrderSchedule> orderScheduleList = new ArrayList<JOrderSchedule>();

            for (int i=0;i<list.size();i++){
                JOrderSchedule jOrderSchedule = new JOrderSchedule();
                jOrderSchedule.setScheduleId(list.get(i));
                jOrderSchedule.setScheduleStatus(153);
                jOrderSchedule.setClockTime(new Date());
                orderScheduleList.add(jOrderSchedule);
            }
            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !", jOrderScheduleMapper.updateBatchById(orderScheduleList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 完工
     * @param jOrderScheduleList
     * @return
     */
    @ResponseBody
    @RequestMapping("/complete")
    public Object complete(@RequestBody Map<String,List<Integer>> jOrderScheduleList){
        try {
            List<Integer> list = jOrderScheduleList.get("list");
            List<JOrderSchedule> orderScheduleList = new ArrayList<JOrderSchedule>();

            for (int i=0;i<list.size();i++){
                JOrderSchedule jOrderSchedule = new JOrderSchedule();
                jOrderSchedule.setScheduleId(list.get(i));
                jOrderSchedule.setScheduleStatus(156);
                jOrderSchedule.setCompletedTime(new Date());
                orderScheduleList.add(jOrderSchedule);
            }
            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !", jOrderScheduleMapper.updateBatchById(orderScheduleList));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 结算
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkout")
    public Object checkout(@RequestBody Map<String,List<Integer>> list, ServletRequest request){
        try {

            //获取管理员id
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            Integer adminId = jAdmin.getAdminId();

            //根据日程id列表查出日程信息
            List<Integer> integerList =list.get("list");
            List<OrderScheduleRes> orderScheduleResList =jOrderScheduleMapper.getScheduleListByList(integerList);

            //判断支付状态
            for (int i =0;i<orderScheduleResList.size();i++){
                if (orderScheduleResList.get(i).getPayStatus()==158){
                    return new ModelRes(ModelRes.Status.FAILED, "有订单已结算 !", null);
                }
            }

            //存放并循环更新客户余额
            //获取客户初始余额
            JOrderContract jOrderContractBalance = jOrderContractMapper.selectById(Long.valueOf(orderScheduleResList.get(0).getOrderId()));
            JCustomer jCustomer = jCustomerMapper.selectById(Long.valueOf(jOrderContractBalance.getCustomerId()));
            BigDecimal customerBalance = jCustomer.getCustomerBalance();

            //判断日程价格和服务师薪资是否需要实时计算
            for (int i =0;i<orderScheduleResList.size();i++){
                //判断服务师工资是否为0，是则实时计算出服务师当前工资
                if (orderScheduleResList.get(i).getCost().compareTo(new BigDecimal(0))==0){
                    orderScheduleResList.get(i).setCost(new BigDecimal(orderScheduleResList.get(i).getNannyCurrentPayment()).multiply(new BigDecimal(String.valueOf((orderScheduleResList.get(i).getEndTime()-orderScheduleResList.get(i).getStartTime()) / 2f))).setScale(2));
                }
                orderScheduleResList.get(i).setUnitPrice(orderScheduleResList.get(i).getScheduleCurrentPrice());
                //判断日程总价是否为0，是则实时计算出当前总价A
                if (orderScheduleResList.get(i).getTotalPrice().compareTo(new BigDecimal(0))==0){
                    orderScheduleResList.get(i).setTotalPrice(orderScheduleResList.get(i).getScheduleCurrentPrice().multiply(new BigDecimal(String.valueOf((orderScheduleResList.get(i).getEndTime()-orderScheduleResList.get(i).getStartTime()) / 2f))).setScale(2));
                }
            }

            //客户对账单列表
            List<JCustomerStatment> jCustomerStatmentList = new ArrayList<JCustomerStatment>();
            //服务师对账单列表
            List<JNannyStatment> jNannyStatmentList = new ArrayList<JNannyStatment>();
            for (int i=0;i<orderScheduleResList.size();i++){

                //计算客户余额
                customerBalance = customerBalance.subtract(orderScheduleResList.get(i).getTotalPrice());
                if (customerBalance.compareTo(new BigDecimal(0))<0){
                    return new ModelRes(ModelRes.Status.FAILED, "余额不足", null);
                }

                //新增客户对账单
                JOrderContract jOrderContract = jOrderContractMapper.selectById(Long.valueOf(orderScheduleResList.get(i).getOrderId()));
                String serviceTime = orderScheduleResList.get(i).getStartTimeValue()+"-"+orderScheduleResList.get(i).getEndTimeValue();
                Double serviceTimeLength = Double.valueOf((orderScheduleResList.get(i).getEndTime() - orderScheduleResList.get(i).getStartTime()) / 2f);


                JCustomerStatment jCustomerStatment = new JCustomerStatment(OrderUtil.generateStamentNumber(48,39),
                        jOrderContract.getCustomerId(),jOrderContract.getGoodsId(), jOrderContract.getHouseId(),
                        jOrderContract.getOrderId(),163,orderScheduleResList.get(i).getScheduleId(),
                        jOrderContract.getShopId(), serviceTime, serviceTimeLength,
                        orderScheduleResList.get(i).getScheduleDate(), new Date(), 39, orderScheduleResList.get(i).getTotalPrice(),
                        48, adminId, 49, 53, customerBalance,
                        "", "");
                jCustomerStatmentList.add(jCustomerStatment);
                //新增服务师对账单
                Map map = new HashedMap();
                map.put("scheduleId",orderScheduleResList.get(i).getScheduleId());
                List<JScheduleNanny> jScheduleNannyList = jScheduleNannyMapper.selectByMap(map);
                JNannyStatment jNannyStatment = new JNannyStatment(OrderUtil.generateStamentNumber(48,162),jScheduleNannyList.get(0).getNannyId(),
                        orderScheduleResList.get(i).getScheduleId(),orderScheduleResList.get(i).getOrderId(),
                        jOrderContract.getShopId(),jOrderContract.getHouseId(),jOrderContract.getCustomerId(),
                        162,orderScheduleResList.get(i).getCost(),163,jOrderContract.getShopId(), serviceTime, serviceTimeLength,
                        orderScheduleResList.get(i).getScheduleDate(),"");
                jNannyStatmentList.add(jNannyStatment);



            }
            jCustomerStatmentMapper.insertBatch(jCustomerStatmentList);
            jNannyStatmentMapper.insertBatch(jNannyStatmentList);

            //修改客户账户余额
            jCustomer.setCustomerBalance(customerBalance);
            jCustomerMapper.updateSelectiveById(jCustomer);

            //更新完工时间以及日程状态
            List<JOrderSchedule> jOrderScheduleList = new ArrayList<JOrderSchedule>();
            for (int i=0;i<orderScheduleResList.size();i++){
                JOrderSchedule jOrderSchedule = new JOrderSchedule();
                jOrderSchedule.setScheduleId(orderScheduleResList.get(i).getScheduleId());
                jOrderSchedule.setPayStatus(158);
                jOrderScheduleList.add(jOrderSchedule);
            }
            jOrderScheduleMapper.updateBatchById(jOrderScheduleList);

            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
}
