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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
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
public class NannyController extends AutoMapperController{

    /**
     * CRUD for nanny
     * @param jNannyInfo
     * @return
     */

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JNannyInfo jNannyInfo, ServletRequest request){
        try {
            //根据身份证判断服务师信息是否已录入
            Map idMap = new HashMap(1);
            idMap.put("nannyIdCard",jNannyInfo.getNannyIdCard());
            List<JNannyInfo> idCardNannyInfo =jNannyInfoMapper.selectByMap(idMap);
            if (idCardNannyInfo.size()>0){
                //如果已经录入则返回服务师相关信息
                Map resMap = new HashMap(2);
                resMap.put("NannyInfoRes",idCardNannyInfo.get(0));
                resMap.put("NannyShopRes",jNannyInfoMapper.getNannyShop(idCardNannyInfo.get(0).getNannyId()));
                return new ModelRes(ModelRes.Status.BUILT, "nanny exist", resMap);
            }

            String fileName = "NA"+System.currentTimeMillis()+".jpg";
//            if (IdCardUtil.isValidatedAllIdcard(jNannyInfo.getNannyIdCard()) && StringUtil.generateImage(jNannyInfo.getNannyAvatar(),"C:/Users/jygj_7500/Desktop/upload/" + fileName)){
            //判断身份证是否合法以及照片上传是否成功
            if (IdCardUtil.isValidatedAllIdcard(jNannyInfo.getNannyIdCard())){
//                if (IdCardUtil.isValidatedAllIdcard(jNannyInfo.getNannyIdCard()) && StringUtil.generateImage(jNannyInfo.getNannyAvatar(), Consts.nannyAvatarUrl + fileName)){
                //根据身份证生成年龄
                jNannyInfo.setNannyAge(IdCardUtil.getAgeByIdCard(jNannyInfo.getNannyIdCard()));
                jNannyInfo.setNannyAvatar(fileName);
                jNannyInfo.setCreateTime(new Date());
                //新增服务师
                jNannyInfoMapper.insert(jNannyInfo);
                //给服务师添加管理员所属门店
                JNannyShop jNannyShop = new JNannyShop();

                jNannyShop.setNannyId(((JNannyInfo)jNannyInfoMapper.selectByMap(idMap).get(0)).getNannyId());
                JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
                jNannyShop.setShopId(jAdmin.getShopId());
                return new ModelRes(ModelRes.Status.SUCCESS,"search NannyInfo success !",jNannyShopMapper.insert(jNannyShop));
            }else {
                return new ModelRes(ModelRes.Status.FAILED, "id card or avatar err !");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/upload")
    public Object upload(@RequestBody JNannyInfo jNannyInfo){
        try {
            String fileName = System.currentTimeMillis()+".jpg";
            boolean boo = StringUtil.generateImage(jNannyInfo.getNannyAvatar(),"C:/Users/jygj_7500/Desktop/upload/" + fileName);
            if(boo){
                JNannyInfo jNannyInfo1 = new JNannyInfo(jNannyInfo.getNannyId(),fileName);
                jNannyInfoMapper.updateSelectiveById(jNannyInfo1);
                return  new ModelRes(ModelRes.Status.SUCCESS, "upload success", fileName);
            }else {
                return new ModelRes(ModelRes.Status.FAILED, "file err !");
            }

        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
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
}
