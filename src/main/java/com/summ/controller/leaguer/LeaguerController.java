package com.summ.controller.leaguer;

import com.summ.Consts;
import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JLeaguer;
import com.summ.model.request.LeaguerReq;
import com.summ.model.response.LeaguerListRes;
import com.summ.model.response.ModelRes;
import com.summ.utils.ResponseUtil;
import com.summ.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 加盟商模块
 * @author jygj_7500
 */
@Controller
@RequestMapping("/leaguer")
public class LeaguerController extends AutoMapperController{

    @ResponseBody
    @RequestMapping("/list")
    public Object findList(@RequestBody LeaguerReq leaguerReq) {
        try {
            leaguerReq.setPage(leaguerReq.getSize() * (leaguerReq.getPage() - 1));
            Map map = new HashMap();
            map.put("count", jLeaguerMapper.getLeaguerListCount(leaguerReq));
            map.put("list", jLeaguerMapper.getLeaguerList(leaguerReq));
            return new ModelRes(ModelRes.Status.SUCCESS, "search customer house info success !", map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/detail")
    public Object findDetail(@RequestBody Map map) {
        try {
            LeaguerListRes leaguerListRes = jLeaguerMapper.getLeaguerDetail((Integer) map.get("leaguerId"));
            if (!StringUtil.isBlank(leaguerListRes.getBusinessLicense())){
                leaguerListRes.setBusinessLicense(Consts.leaguerBusinessLicenseUrlRes + leaguerListRes.getBusinessLicense());
            }
            if (!StringUtil.isBlank(leaguerListRes.getIdCardBefore())){
                leaguerListRes.setIdCardBefore(Consts.leaguerIdcardUrlRes + leaguerListRes.getIdCardBefore());
            }
            if (!StringUtil.isBlank(leaguerListRes.getIdCardAfter())){
                leaguerListRes.setIdCardAfter(Consts.leaguerIdcardUrlRes + leaguerListRes.getIdCardAfter());
            }
            return new ModelRes(ModelRes.Status.SUCCESS, "search customer house info success !", leaguerListRes);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JLeaguer jLeaguer) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "insert customer house info success !", jLeaguerMapper.insertSelective(jLeaguer));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/online")
    public Object online(@RequestBody Map map) {
        try {
            Integer leaguerId = (Integer) map.get("leaguerId");
            JLeaguer jLeaguer = jLeaguerMapper.selectById(Long.valueOf(leaguerId));
            if (jLeaguer != null) {
                if (jLeaguer.getLeaguerStatus() == 181) {
                    return new ModelRes(ModelRes.Status.FAILED, "该供应商已上线 !");
                } else {
                    if (ResponseUtil.checkObjFieldIsNull(jLeaguer)) {
                        return new ModelRes(ModelRes.Status.FAILED, "供应商信息不完整 !");
                    } else {
                        jLeaguer.setLeaguerStatus(181);
                        return new ModelRes(ModelRes.Status.SUCCESS, "成功上线 !", jLeaguerMapper.updateSelectiveById(jLeaguer));
                    }
                }
            } else {
                return new ModelRes(ModelRes.Status.FAILED, "找不到该供应商 !");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object updateHouse(@RequestBody JLeaguer jLeaguer) {
        try {
            /**上传营业执照*/
            if (!StringUtil.isBlank(jLeaguer.getBusinessLicense())){
                String fileName = "SBL" + System.currentTimeMillis() + ".jpg";
                if (!StringUtil.generateImage(jLeaguer.getBusinessLicense(), Consts.leaguerBusinessLicenseUrl + fileName)) {
                    return new ModelRes(ModelRes.Status.FAILED, "供应商营业执照上传失败 !");
                }
                jLeaguer.setBusinessLicense(fileName);
            }
            /**上传身份证正面*/
            if (!StringUtil.isBlank(jLeaguer.getIdCardBefore())){
                String fileName = "SI" + System.currentTimeMillis() + ".jpg";
                if (!StringUtil.generateImage(jLeaguer.getIdCardBefore(), Consts.leaguerIdcardUrl + fileName)) {
                    return new ModelRes(ModelRes.Status.FAILED, "供应商身份证正面上传失败 !");
                }
                jLeaguer.setIdCardBefore(fileName);
            }
            /**上传身份证反面*/
            if (!StringUtil.isBlank(jLeaguer.getIdCardAfter())){
                String fileName = "SI" + System.currentTimeMillis() + ".jpg";
                if (!StringUtil.generateImage(jLeaguer.getIdCardAfter(), Consts.leaguerIdcardUrl + fileName)) {
                    return new ModelRes(ModelRes.Status.FAILED, "供应商身份证反面上传失败 !");
                }
                jLeaguer.setIdCardAfter(fileName);
            }
            jLeaguerMapper.updateSelectiveById(jLeaguer);

            LeaguerListRes leaguerListRes = jLeaguerMapper.getLeaguerDetail(jLeaguer.getLeaguerId());
            if (null!=leaguerListRes.getBusinessLicense()){
                leaguerListRes.setBusinessLicense(Consts.leaguerBusinessLicenseUrlRes + leaguerListRes.getBusinessLicense());
            }
            if (null!=leaguerListRes.getIdCardBefore()){
                leaguerListRes.setIdCardBefore(Consts.leaguerIdcardUrlRes + leaguerListRes.getIdCardBefore());
            }
            if (null!=leaguerListRes.getIdCardAfter()){
                leaguerListRes.setIdCardAfter(Consts.leaguerIdcardUrlRes + leaguerListRes.getIdCardAfter());
            }
            return new ModelRes(ModelRes.Status.SUCCESS, "update customer house info success !", leaguerListRes);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
}
