package com.summ.controller.nanny;

import com.summ.mapper.JNannyInfoMapper;
import com.summ.model.JNannyInfo;
import com.summ.model.JNannyTrain;
import com.summ.model.request.NannyInfoReq;
import com.summ.model.response.*;
import com.summ.utils.IdCardUtil;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jygj_7500
 * @date 17/12/11
 */
@Controller
@RequestMapping("/nanny")
public class NannyController {
    @Autowired
    private JNannyInfoMapper jNannyInfoMapper;

    /**
     * CRUD for nanny
     * @param jNannyInfo
     * @return
     */

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JNannyInfo jNannyInfo){
        try {
            if (IdCardUtil.isValidatedAllIdcard(jNannyInfo.getNannyIdCard())){
                jNannyInfo.setNannyAge(IdCardUtil.getAgeByIdCard(jNannyInfo.getNannyIdCard()));
                jNannyInfo.setCreateTime(new Date());
                return new ModelRes(ModelRes.Status.SUCCESS,"add NannyInfo success !",jNannyInfoMapper.insert(jNannyInfo));
            }else {
                return new ModelRes(ModelRes.Status.FAILED, "id card err !");
            }

        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

//    @ResponseBody
//    @RequestMapping("/delete")
//    public Object delete(@RequestBody Map<String,List> jNannyInfo){
//        try {
//            List list = jNannyInfo.get("NannyInfoId");
//            System.out.println(">>>>>>>>>>>list>>>>>>>>>>>>" + list);
//            return new ModelRes(ModelRes.Status.SUCCESS,"delete NannyInfo success !",jNannyInfoMapper.deleteList(list));
//        }catch (Exception e){
//            e.printStackTrace();
//            return new ModelRes(ModelRes.Status.ERROR, "server err !");
//        }
//    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody JNannyInfo jNannyInfo){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannyInfoMapper.updateById(jNannyInfo));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find/list")
    public Object find(@RequestBody NannyInfoReq nannyInfoReq){
        try {
            nannyInfoReq.setPage(nannyInfoReq.getSize() * (nannyInfoReq.getPage()-1));
            Map<String,Object> map = new HashedMap();
            map.put("count",jNannyInfoMapper.getCount(nannyInfoReq));
            map.put("list",jNannyInfoMapper.getNannyInfoList(nannyInfoReq));
            return new ModelRes(ModelRes.Status.SUCCESS,"search NannyInfo success !",map);
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find/basic")
    public Object findBasicData(@RequestBody JNannyInfo jNannyInfo){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"search NannyInfo success !",jNannyInfoMapper.getNannyBasic(jNannyInfo.getNannyId()));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find/job")
    public Object findJobData(@RequestBody JNannyInfo jNannyInfo){
        try {
            NannyInfoRes nannyInfoRes = jNannyInfoMapper.getJobData(jNannyInfo.getNannyId());
            List<NannyTrainRes> jNannyTrains = jNannyInfoMapper.getNannyTrain(jNannyInfo.getNannyId());
            nannyInfoRes.setNannyTrainRes(jNannyTrains);
            List<NannyJobLevelRes> jobLevelRes = jNannyInfoMapper.getNannyJobLevel(jNannyInfo.getNannyId());
            nannyInfoRes.setNannyJobLevelRes(jobLevelRes);
            return new ModelRes(ModelRes.Status.SUCCESS,"search NannyInfo success !",nannyInfoRes);
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find/other")
    public Object findOtherData(@RequestBody JNannyInfo jNannyInfo){
        try {
            int nannyId = jNannyInfo.getNannyId();
            NannyInfoRes nannyInfoRes = jNannyInfoMapper.getNannyOther(nannyId);
            List<NannyReligionRes> nannyReligionRes = jNannyInfoMapper.getNannyReligion(nannyId);
            nannyInfoRes.setNannyReligionRes(nannyReligionRes);
            List<NannyLanguageRes> nannyLanguageRes = jNannyInfoMapper.getNannyLanguage(nannyId);
            nannyInfoRes.setNannyLanguageRes(nannyLanguageRes);
            List<NannySkillRes> nannySkillRes = jNannyInfoMapper.getNannySkill(nannyId);
            nannyInfoRes.setNannySkillRes(nannySkillRes);
            List<NannyCharacterRes> nannyCharacterRes = jNannyInfoMapper.getNannyCharacter(nannyId);
            nannyInfoRes.setNannyCharacterRes(nannyCharacterRes);
            return new ModelRes(ModelRes.Status.SUCCESS,"search NannyInfo success !",nannyInfoRes);
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find/certificate")
    public Object findCertificateData(@RequestBody JNannyInfo jNannyInfo){
        try {
            Map map = new HashMap();
            map.put("certificate",jNannyInfoMapper.getNannyCertificate(jNannyInfo.getNannyId()));
            return new ModelRes(ModelRes.Status.SUCCESS,"search NannyInfo success !",map);
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
}
