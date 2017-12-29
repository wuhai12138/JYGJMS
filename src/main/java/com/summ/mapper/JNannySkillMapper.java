package com.summ.mapper;

import com.summ.model.JDictInfo;
import com.summ.model.JNannySkill;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.response.NannyLanguageRes;
import com.summ.model.response.NannySkillRes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * JNannySkill 表数据库控制层接口
 */
public interface JNannySkillMapper extends AutoMapper<JNannySkill> {
    List<NannySkillRes> getSelectedSkill(int nannyId);

    List<JDictInfo> getUnselectedSkill(@Param("nannyId") int nannyId, @Param("name") String name);

}