package com.summ.mapper;

import com.summ.model.JNannyCashPledgeRecord;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.request.NannyCashPledgeReq;
import com.summ.model.response.NannyCashPledgeRes;
import com.summ.model.response.ReportCashPledgeRes;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 *
 * JNannyCashPledgeRecord 表数据库控制层接口
 *
 */
public interface JNannyCashPledgeRecordMapper extends AutoMapper<JNannyCashPledgeRecord> {

    List<NannyCashPledgeRes> getNannyCashPledgeList(Integer nannyId);

    List<ReportCashPledgeRes> getReportCashPledge(Date startDate,Date endDate);

    List<NannyCashPledgeRes> getReportCashPledgeDetailList(@Param("nannyCashPledgeReq") NannyCashPledgeReq nannyCashPledgeReq);

    Integer getReportCashPledgeDetailCount(@Param("nannyCashPledgeReq") NannyCashPledgeReq nannyCashPledgeReq);

}