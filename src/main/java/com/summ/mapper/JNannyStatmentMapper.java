package com.summ.mapper;

import com.summ.model.JNannyStatment;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.request.NannyStatmentDetailReq;
import com.summ.model.request.NannyStatmentReq;
import com.summ.model.response.NannyStatmentDetailRes;
import com.summ.model.response.NannyStatmentRes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * JNannyStatment 表数据库控制层接口
 *
 */
public interface JNannyStatmentMapper extends AutoMapper<JNannyStatment> {

    List<NannyStatmentRes> getNannyStatmentList(@Param("nannyStatmentReq") NannyStatmentReq nannyStatmentReq);

    List<NannyStatmentDetailRes> getNannyStatmentDetail(@Param("nannyStatmentDetailReq") NannyStatmentDetailReq nannyStatmentDetailReq);

    Integer getNannyStatmentDetailCount(@Param("nannyStatmentDetailReq") NannyStatmentDetailReq nannyStatmentDetailReq);

}