package com.summ.mapper;

import com.summ.model.JTeacher;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.request.NannyInfoReq;
import com.summ.model.request.TeacherReq;
import com.summ.model.response.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * JTeacher 表数据库控制层接口
 *
 */
public interface JTeacherMapper extends AutoMapper<JTeacher> {
    /**
     * 带教门店
     * @param id
     * @return
     */
    List<TeacherShopRes> getTeacherShop(int id);

    List<TeacherListRes> getTeacherList(@Param("teacherReq") TeacherReq teacherReq);

    Integer getCount(@Param("teacherReq")TeacherReq teacherReq);

    TeacherRes getTeacherById(Integer teacherId);


}