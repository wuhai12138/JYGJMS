package com.summ.controller.nanny;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.summ.controller.basic.AutoMapperController;
import com.summ.model.*;
import com.summ.model.request.NannyWortTimeByOrderReq;
import com.summ.model.request.ServiceWeeksTimeReq;
import com.summ.model.response.CustomerServiceRes;
import com.summ.model.response.ModelRes;
import com.summ.model.response.NannyHotWorkTImeRes;
import com.summ.model.response.TimeAndWeekRes;
import com.summ.utils.JsonUtil;
import com.summ.utils.NannyWorkTimeUtil;
import com.summ.utils.ResponseUtil;
import com.summ.utils.StringUtil;
import com.summ.utils.mongodb.MongoDBUtil;
import com.summ.utils.mongodb.model.MongoConfig;
import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.ss.formula.functions.Na;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author jygj_7500
 * @date 18/1/11
 */
@Controller
@RequestMapping("/nanny/worktime")
public class NannyWorkTimeController extends AutoMapperController {
    /**
     * 验证服务师与订单是否可以匹配
     *
     * @param reqMap
     * @return
     */
    @ResponseBody
    @RequestMapping("/sign")
    public Object sign(@RequestBody Map reqMap) {
        try {
            List<Long> orderIdList = (List<Long>) reqMap.get("orderId");
//            Integer orderId = (Integer) reqMap.get("orderId");
            Integer nannyId = (Integer) reqMap.get("nannyId");

            //获取合同订单列表
            List<JOrderContract> jOrderContractList = jOrderContractMapper.selectBatchIds(orderIdList);
            //连接mongodb数据库
            mongoDBUtil = MongoDBUtil.getInstance(new MongoConfig());

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
                    return new ModelRes(ModelRes.Status.FAILED, "nanny work time not valid ! !", null);
                }
                //判断该服务师的日程是否符合订单时间要求
                List<JOrderSchedule> signNannySchedule = jOrderScheduleMapper.signNannySchedule(JsonUtil.Obj2Map(serviceWeeksTimeReq));
                if (signNannySchedule.size() > 0) {
                    return new ModelRes(ModelRes.Status.FAILED, "nanny schedule not valid ! !", ResponseUtil.List2Map(signNannySchedule));
                }
            }

            return new ModelRes(ModelRes.Status.SUCCESS, "nanny is valid !", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object getHotNannyByOrder(@RequestBody NannyWortTimeByOrderReq nannyWortTimeByOrderReq) {
        try {
            //获取常用服务师基本信息列表
            List<NannyHotWorkTImeRes> nannyHotWorkTImeResList = jNannyWorkTimeMapper.getHotNannyWorkTime();
            //循环每个常用服务师
            for (NannyHotWorkTImeRes nannyHotWorkTImeRes : nannyHotWorkTImeResList) {
                //保存服务师工时
                List<TimeAndWeekRes> timeAndWeekResList = new ArrayList<TimeAndWeekRes>();

                List<TimeAndWeekRes> timeAndWeekResListMonday = NannyWorkTimeUtil.value2TimeAndWeekRes(nannyHotWorkTImeRes.getMonday());
                for (TimeAndWeekRes timeAndWeekRes : timeAndWeekResListMonday) {
                    timeAndWeekRes.setStart(NannyWorkTimeUtil.id2Time(timeAndWeekRes.getStartId()));
                    timeAndWeekRes.setEnd(NannyWorkTimeUtil.id2Time(timeAndWeekRes.getEndId()));
                    timeAndWeekRes.setWeek("周一");
                    timeAndWeekRes.setDescribe("服务师工时");
                }
                timeAndWeekResList.addAll(timeAndWeekResListMonday);

                List<TimeAndWeekRes> timeAndWeekResListTuesday = NannyWorkTimeUtil.value2TimeAndWeekRes(nannyHotWorkTImeRes.getTuesday());
                for (TimeAndWeekRes timeAndWeekRes : timeAndWeekResListTuesday) {
                    timeAndWeekRes.setStart(NannyWorkTimeUtil.id2Time(timeAndWeekRes.getStartId()));
                    timeAndWeekRes.setEnd(NannyWorkTimeUtil.id2Time(timeAndWeekRes.getEndId()));
                    timeAndWeekRes.setWeek("周二");
                    timeAndWeekRes.setDescribe("服务师工时");
                }
                timeAndWeekResList.addAll(timeAndWeekResListTuesday);

                List<TimeAndWeekRes> timeAndWeekResListWednesday = NannyWorkTimeUtil.value2TimeAndWeekRes(nannyHotWorkTImeRes.getWednesday());
                for (TimeAndWeekRes timeAndWeekRes : timeAndWeekResListWednesday) {
                    timeAndWeekRes.setStart(NannyWorkTimeUtil.id2Time(timeAndWeekRes.getStartId()));
                    timeAndWeekRes.setEnd(NannyWorkTimeUtil.id2Time(timeAndWeekRes.getEndId()));
                    timeAndWeekRes.setWeek("周三");
                    timeAndWeekRes.setDescribe("服务师工时");
                }
                timeAndWeekResList.addAll(timeAndWeekResListWednesday);

                List<TimeAndWeekRes> timeAndWeekResListThursday = NannyWorkTimeUtil.value2TimeAndWeekRes(nannyHotWorkTImeRes.getThursday());
                for (TimeAndWeekRes timeAndWeekRes : timeAndWeekResListThursday) {
                    timeAndWeekRes.setStart(NannyWorkTimeUtil.id2Time(timeAndWeekRes.getStartId()));
                    timeAndWeekRes.setEnd(NannyWorkTimeUtil.id2Time(timeAndWeekRes.getEndId()));
                    timeAndWeekRes.setWeek("周四");
                    timeAndWeekRes.setDescribe("服务师工时");
                }
                timeAndWeekResList.addAll(timeAndWeekResListThursday);

                List<TimeAndWeekRes> timeAndWeekResListFriday = NannyWorkTimeUtil.value2TimeAndWeekRes(nannyHotWorkTImeRes.getFriday());
                for (TimeAndWeekRes timeAndWeekRes : timeAndWeekResListFriday) {
                    timeAndWeekRes.setStart(NannyWorkTimeUtil.id2Time(timeAndWeekRes.getStartId()));
                    timeAndWeekRes.setEnd(NannyWorkTimeUtil.id2Time(timeAndWeekRes.getEndId()));
                    timeAndWeekRes.setWeek("周五");
                    timeAndWeekRes.setDescribe("服务师工时");
                }
                timeAndWeekResList.addAll(timeAndWeekResListFriday);

                List<TimeAndWeekRes> timeAndWeekResListSaturday = NannyWorkTimeUtil.value2TimeAndWeekRes(nannyHotWorkTImeRes.getSaturday());
                for (TimeAndWeekRes timeAndWeekRes : timeAndWeekResListSaturday) {
                    timeAndWeekRes.setStart(NannyWorkTimeUtil.id2Time(timeAndWeekRes.getStartId()));
                    timeAndWeekRes.setEnd(NannyWorkTimeUtil.id2Time(timeAndWeekRes.getEndId()));
                    timeAndWeekRes.setWeek("周六");
                    timeAndWeekRes.setDescribe("服务师工时");
                }
                timeAndWeekResList.addAll(timeAndWeekResListSaturday);

                List<TimeAndWeekRes> timeAndWeekResListSunday = NannyWorkTimeUtil.value2TimeAndWeekRes(nannyHotWorkTImeRes.getSunday());
                for (TimeAndWeekRes timeAndWeekRes : timeAndWeekResListSunday) {
                    timeAndWeekRes.setStart(NannyWorkTimeUtil.id2Time(timeAndWeekRes.getStartId()));
                    timeAndWeekRes.setEnd(NannyWorkTimeUtil.id2Time(timeAndWeekRes.getEndId()));
                    timeAndWeekRes.setWeek("周天");
                    timeAndWeekRes.setDescribe("服务师工时");
                }
                timeAndWeekResList.addAll(timeAndWeekResListSunday);

                nannyHotWorkTImeRes.setNannyWorkTime(timeAndWeekResList);


                //保存服务师日程已使用工时
                nannyWortTimeByOrderReq.setNannyId(nannyHotWorkTImeRes.getNannyId());
                List<TimeAndWeekRes> scheduleTimeAndWeekResList = jNannyWorkTimeMapper.getHotNannyScheduleTime(nannyWortTimeByOrderReq);
                nannyHotWorkTImeRes.setNannyScheduleTime(scheduleTimeAndWeekResList);
            }
            return new ModelRes(ModelRes.Status.SUCCESS, "find hot nanny success !", ResponseUtil.List2Map(nannyHotWorkTImeResList));
        } catch (Exception e) {
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }

    }

    @ResponseBody
    @RequestMapping("/insert")
    public Object insertWorktimeByNanny(@RequestBody Map map) {
        try {

            String stringWeekList = (String) map.get("weekList");
            List<Map> weekList = JsonUtil.json2List(stringWeekList, Map.class);
            String stringTimeList = (String) map.get("timeList");
            List<Map> timeList = JsonUtil.json2List(stringTimeList, Map.class);
            Integer nannyId = (Integer) map.get("nannyId");

            Map hMap = new HashMap();
            hMap.put("nannyId",nannyId);
            List<JNannyWorkTime> jNannyWorkTimeList = jNannyWorkTimeMapper.selectByMap(hMap);
            if (jNannyWorkTimeList.size()>0){
                /**手动清空老工时*/
                jNannyWorkTimeMapper.deleteSelective(jNannyWorkTimeList.get(0));
//                return new ModelRes(ModelRes.Status.FAILED, "该服务师已有工时，如需添加请先清空！");
            }
            Long workTime = 0L;
            for (int i = 0; i < timeList.size(); i++) {
                workTime += NannyWorkTimeUtil.getTimeListValue((Integer) timeList.get(i).get("startId"), (Integer) timeList.get(i).get("endId"));
            }
            JNannyWorkTime jNannyWorkTime = new JNannyWorkTime();
            jNannyWorkTime.setNannyId(nannyId);
            for (int i = 0; i < weekList.size(); i++) {
                if ("true".equals(weekList.get(i).get("active").toString())) {
                    if ("周一".equals(weekList.get(i).get("value").toString())) {
                        jNannyWorkTime.setMonday(workTime);
                    }
                    if ("周二".equals(weekList.get(i).get("value").toString())) {
                        jNannyWorkTime.setTuesday(workTime);
                    }
                    if ("周三".equals(weekList.get(i).get("value").toString())) {
                        jNannyWorkTime.setWednesday(workTime);
                    }
                    if ("周四".equals(weekList.get(i).get("value").toString())) {
                        jNannyWorkTime.setThursday(workTime);
                    }
                    if ("周五".equals(weekList.get(i).get("value").toString())) {
                        jNannyWorkTime.setFriday(workTime);
                    }
                    if ("周六".equals(weekList.get(i).get("value").toString())) {
                        jNannyWorkTime.setSaturday(workTime);
                    }
                    if ("周天".equals(weekList.get(i).get("value").toString())) {
                        jNannyWorkTime.setSunday(workTime);
                    }
                }
            }

            return new ModelRes(ModelRes.Status.SUCCESS, "update NannyInfo success !", jNannyWorkTimeMapper.insert(jNannyWorkTime));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestBody Map map) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "update NannyInfo success !", jNannyWorkTimeMapper.deleteByMap(map));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

}
