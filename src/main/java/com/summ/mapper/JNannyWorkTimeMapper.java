package com.summ.mapper;

import com.summ.model.JNannyInfo;
import com.summ.model.JNannyWorkTime;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.request.NannyWortTimeByOrderReq;
import com.summ.model.response.NannyHotWorkTImeRes;
import com.summ.model.response.TimeAndWeekRes;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 * JNannyWorkTime 表数据库控制层接口
 *
 */
public interface JNannyWorkTimeMapper extends AutoMapper<JNannyWorkTime> {
    List<JNannyInfo> signNannyWorkTime(@Param("map") Map map);

    List<NannyHotWorkTImeRes> getHotNannyWorkTime();

    List<TimeAndWeekRes> getHotNannyScheduleTime(NannyWortTimeByOrderReq nannyWortTimeByOrderReq);

}