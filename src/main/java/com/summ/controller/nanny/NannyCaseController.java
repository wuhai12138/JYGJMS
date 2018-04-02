package com.summ.controller.nanny;

import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JNannyCase;
import com.summ.model.JNannyCashPledgeRecord;
import com.summ.model.JNannyInfo;
import com.summ.model.response.ModelRes;
import com.summ.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 服务师报案记录模块
 * @author jygj_7500
 */
@Controller
@RequestMapping("/nanny/case")
public class NannyCaseController extends AutoMapperController{

    /**
     * 添加报案记录
     * @param jNannyCase
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JNannyCase jNannyCase) {
        try {
            JNannyInfo jNannyInfo = jNannyInfoMapper.selectById(Long.valueOf(jNannyCase.getNannyId()));
            if (jNannyInfo.getCaseload()==null){
                jNannyInfo.setCaseload(1);
            }else {
                jNannyInfo.setCaseload(jNannyInfo.getCaseload()+1);
            }
            jNannyInfoMapper.updateSelectiveById(jNannyInfo);
            jNannyCaseMapper.insertSelective(jNannyCase);
            return new ModelRes(ModelRes.Status.SUCCESS, "upload success", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 结案
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/complete")
    public Object complete(@RequestBody Map map) {
        try {
            Integer caseId = (Integer) map.get("caseId");
            JNannyCase jNannyCase = jNannyCaseMapper.selectById(Long.valueOf(caseId));
            JNannyInfo jNannyInfo = jNannyInfoMapper.selectById(Long.valueOf(jNannyCase.getNannyId()));

            jNannyInfo.setCaseload(jNannyInfo.getCaseload()-1);
            jNannyInfoMapper.updateSelectiveById(jNannyInfo);

            jNannyCase.setModifyTime(new Date());
            jNannyCase.setCaseStatus(172);
            jNannyCaseMapper.updateSelectiveById(jNannyCase);
            return new ModelRes(ModelRes.Status.SUCCESS, "upload success", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody JNannyCase jNannyCase) {
        try {
            Map map = new HashMap();
            map.put("nannyId",jNannyCase.getNannyId());
            return new ModelRes(ModelRes.Status.SUCCESS, "upload success", ResponseUtil.List2Map(jNannyCaseMapper.selectByMap(map)));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

}
