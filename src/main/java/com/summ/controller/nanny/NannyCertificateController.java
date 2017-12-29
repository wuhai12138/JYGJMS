package com.summ.controller.nanny;

import com.summ.Consts;
import com.summ.controller.basic.AutoMapperController;
import com.summ.mapper.JNannyCertificateMapper;
import com.summ.model.JNannyCertificate;
import com.summ.model.JNannyInfo;
import com.summ.model.response.ModelRes;
import com.summ.model.response.NannyCertificateRes;
import com.summ.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jygj_7500
 * @date 17/12/18
 */
@Controller
@RequestMapping("/nanny/certificate")
public class NannyCertificateController extends AutoMapperController {

    @ResponseBody
    @RequestMapping("/find")
    public Object findCertificateData(@RequestBody JNannyInfo jNannyInfo) {
        try {
            Map map = new HashMap();
            List<NannyCertificateRes> list = jNannyInfoMapper.getNannyCertificate(jNannyInfo.getNannyId());
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setPhoto(Consts.nannyCertUrlRes + list.get(i).getPhoto());
            }
            map.put("certificate", list);
            return new ModelRes(ModelRes.Status.SUCCESS, "search NannyInfo success !", map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object deleteCertificateData(@RequestBody Map map) {
        try {
            JNannyCertificate jNannyCertificate = new JNannyCertificate();
            jNannyCertificate.setNannyCertId((Integer) map.get("id"));
            return new ModelRes(ModelRes.Status.SUCCESS, "search NannyInfo success !", jNannyCertificateMapper.deleteSelective(jNannyCertificate));
        } catch (Exception e) {

            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JNannyCertificate jNannyCertificate) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "add NannyInfo success !", jNannyCertificateMapper.insert(jNannyCertificate));
        } catch (Exception e)
        {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/upload")
    public Object upload(@RequestBody JNannyCertificate jNannyCertificate) {
        try {
            String fileName = "NC"+System.currentTimeMillis()+".jpg";
            if(StringUtil.generateImage(jNannyCertificate.getPhoto(),Consts.nannyCertUrl + fileName)){
                jNannyCertificate.setPhoto(fileName);
                return new ModelRes(ModelRes.Status.SUCCESS,"add NannyInfo success !",jNannyCertificateMapper.updateSelectiveById(jNannyCertificate));
            }
            return new ModelRes(ModelRes.Status.FAILED, "photo err !");
        } catch (Exception e)
        {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
}
