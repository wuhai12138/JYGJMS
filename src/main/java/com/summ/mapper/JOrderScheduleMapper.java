package com.summ.mapper;

import com.summ.model.JNannyInfo;
import com.summ.model.JOrderSchedule;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.request.OrderScheduleReq;
import com.summ.model.response.OrderScheduleRes;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 * JOrderSchedule 表数据库控制层接口
 *
 */
public interface JOrderScheduleMapper extends AutoMapper<JOrderSchedule> {

    List<OrderScheduleRes> getScheduleList(@Param("orderScheduleReq")OrderScheduleReq orderScheduleReq);

    List<OrderScheduleRes> getScheduleListByList(List<Integer> list);

    Integer getScheduleCount(@Param("orderScheduleReq")OrderScheduleReq orderScheduleReq);

    List<JOrderSchedule> signNannySchedule(@Param("map") Map map);

    List<OrderScheduleRes> getTempScheduleList(int orderId);

    List<OrderScheduleRes> getTempScheduleListByList(List<Integer> list);
}