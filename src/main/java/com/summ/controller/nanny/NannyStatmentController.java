package com.summ.controller.nanny;

import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JAdmin;
import com.summ.model.JNannyInfo;
import com.summ.model.request.NannyStatmentDetailReq;
import com.summ.model.request.NannyStatmentReq;
import com.summ.model.response.ModelRes;
import com.summ.utils.ResponseUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.util.Map;

/**
 * Created by jygj_7500 on 18/1/18.
 */
@Controller
@RequestMapping("/nanny/statment")
public class NannyStatmentController extends AutoMapperController{

    @ResponseBody
    @RequestMapping("/find/list")
    public Object updateJobData(@RequestBody NannyStatmentReq nannyStatmentReq, ServletRequest request) {
        try {
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            nannyStatmentReq.setAdminId(jAdmin.getAdminId());
            nannyStatmentReq.setPage(nannyStatmentReq.getSize() * (nannyStatmentReq.getPage()-1));
            return new ModelRes(ModelRes.Status.SUCCESS, "get Nanny statment list success !", ResponseUtil.List2Map(jNannyStatmentMapper.getNannyStatmentList(nannyStatmentReq)));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find/detail")
    public Object updateJobData(@RequestBody NannyStatmentDetailReq nannyStatmentDetailReq) {
        try {
            nannyStatmentDetailReq.setPage(nannyStatmentDetailReq.getSize() * (nannyStatmentDetailReq.getPage()-1));
            Map<String, Object> map = new HashedMap();
            map.put("count", jNannyStatmentMapper.getNannyStatmentDetailCount(nannyStatmentDetailReq));
            map.put("list", jNannyStatmentMapper.getNannyStatmentDetail(nannyStatmentDetailReq));
            return new ModelRes(ModelRes.Status.SUCCESS, "update NannyInfo success !", map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
}
