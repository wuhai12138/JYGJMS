package com.summ.mapper;

import com.summ.model.JDictInfo;
import com.summ.model.JNannyLanguage;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.response.NannyLanguageRes;
import com.summ.model.response.NannyReligionRes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * JNannyLanguage 表数据库控制层接口
 */
public interface JNannyLanguageMapper extends AutoMapper<JNannyLanguage> {
    List<NannyLanguageRes> getSelectedLanguage(int nannyId);

    List<JDictInfo> getUnselectedLanguage(@Param("nannyId") int nannyId, @Param("name") String name);

}