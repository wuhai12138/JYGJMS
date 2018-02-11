package com.summ.controller.nanny;

import com.summ.Consts;
import com.summ.controller.basic.AutoMapperController;
import com.summ.mapper.JNannyShopMapper;
import com.summ.model.JAdmin;
import com.summ.model.JNannyInfo;
import com.summ.model.JNannyShop;
import com.summ.model.request.NannyInfoReq;
import com.summ.model.response.*;
import com.summ.utils.FileUploadUtil;
import com.summ.utils.IdCardUtil;
import com.summ.utils.ResponseUtil;
import com.summ.utils.StringUtil;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jygj_7500
 * @date 17/12/11
 */
@Controller
@RequestMapping("/nanny")
public class NannyController extends AutoMapperController {

    /**
     * CRUD for nanny
     *
     * @param jNannyInfo
     * @return
     */

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JNannyInfo jNannyInfo, @RequestBody Map map, ServletRequest request) {
        try {
            //根据身份证判断服务师信息是否已录入
            Map idMap = new HashMap(1);
            idMap.put("nannyIdCard", jNannyInfo.getNannyIdCard());
            List<JNannyInfo> idCardNannyInfo = jNannyInfoMapper.selectByMap(idMap);
            if (idCardNannyInfo.size() > 0) {
                //如果已经录入则返回服务师相关信息
                Map resMap = new HashMap(2);
                resMap.put("NannyInfoRes", idCardNannyInfo.get(0));
                resMap.put("NannyShopRes", jNannyInfoMapper.getNannyShop(idCardNannyInfo.get(0).getNannyId()));
                return new ModelRes(ModelRes.Status.BUILT, "nanny exist", resMap);
            }
            String fileName = "NA" + System.currentTimeMillis() + ".jpg";
//            if (IdCardUtil.isValidatedAllIdcard(jNannyInfo.getNannyIdCard()) && StringUtil.generateImage(jNannyInfo.getNannyAvatar(),"C:/Users/jygj_7500/Desktop/upload/" + fileName)){
            //判断身份证是否合法以及照片上传是否成功
            if ("".equals(jNannyInfo.getNannyAvatar()) || null == jNannyInfo.getNannyAvatar()){

                if (IdCardUtil.isValidatedAllIdcard(jNannyInfo.getNannyIdCard())) {
                    //根据身份证生成年龄
                    jNannyInfo.setNannyAge(IdCardUtil.getAgeByIdCard(jNannyInfo.getNannyIdCard()));
                    jNannyInfo.setNannyAvatar(fileName);
                    jNannyInfo.setCreateTime(new Date());
                    //新增服务师
                    jNannyInfoMapper.insert(jNannyInfo);
                    //给服务师添加管理员所属门店
                    JNannyShop jNannyShop = new JNannyShop();
                    jNannyShop.setNannyId(((JNannyInfo) jNannyInfoMapper.selectByMap(idMap).get(0)).getNannyId());
                    jNannyShop.setShopId((Integer) map.get("shopId"));
                    return new ModelRes(ModelRes.Status.SUCCESS, "search NannyInfo success !", jNannyShopMapper.insert(jNannyShop));
                } else {
                    return new ModelRes(ModelRes.Status.FAILED, " avatar err !");
                }
            }else {
                if (IdCardUtil.isValidatedAllIdcard(jNannyInfo.getNannyIdCard()) && StringUtil.generateImage(jNannyInfo.getNannyAvatar(), Consts.nannyAvatarUrl + fileName)) {
                    //根据身份证生成年龄
                    jNannyInfo.setNannyAge(IdCardUtil.getAgeByIdCard(jNannyInfo.getNannyIdCard()));
                    jNannyInfo.setNannyAvatar(fileName);
                    jNannyInfo.setCreateTime(new Date());
                    //新增服务师
                    jNannyInfoMapper.insert(jNannyInfo);
                    //给服务师添加管理员所属门店
                    JNannyShop jNannyShop = new JNannyShop();
                    jNannyShop.setNannyId(((JNannyInfo) jNannyInfoMapper.selectByMap(idMap).get(0)).getNannyId());
                    jNannyShop.setShopId((Integer) map.get("shopId"));
                    return new ModelRes(ModelRes.Status.SUCCESS, "search NannyInfo success !", jNannyShopMapper.insert(jNannyShop));
                } else {
                    return new ModelRes(ModelRes.Status.FAILED, "id card or avatar err !");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 更新服务师是否为常用服务师
     * @param jNannyInfo
     * @return
     */
    @ResponseBody
    @RequestMapping("/upload")
    public Object upload(@RequestBody JNannyInfo jNannyInfo) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "upload success", jNannyInfoMapper.updateSelectiveById(jNannyInfo));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody NannyInfoReq nannyInfoReq, ServletRequest request) {
        try {
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            nannyInfoReq.setAdminId(jAdmin.getAdminId());
            nannyInfoReq.setPage(nannyInfoReq.getSize() * (nannyInfoReq.getPage() - 1));
            Map<String, Object> map = new HashedMap();
            map.put("list", jNannyInfoMapper.getNannyInfoList(nannyInfoReq));
            map.put("count", jNannyInfoMapper.getCount(nannyInfoReq));
            return new ModelRes(ModelRes.Status.SUCCESS, "search NannyInfo success !", map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
}
