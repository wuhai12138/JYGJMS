package com.summ.mapper;

import com.summ.model.AASql;
import com.summ.model.JNannyWorkTimeDic;
import com.baomidou.mybatisplus.mapper.AutoMapper;

import java.util.List;

/**
 *
 * JNannyWorkTimeDic 表数据库控制层接口
 *
 */
public interface JNannyWorkTimeDicMapper extends AutoMapper<JNannyWorkTimeDic> {
    List<String> test(AASql sql);
}