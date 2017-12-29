package com.summ.controller.nanny;

import com.summ.controller.basic.AutoMapperController;
import com.summ.mapper.JNannyJobLevelMapper;
import com.summ.model.*;
import com.summ.model.request.NannyInfoReq;
import com.summ.model.response.*;
import com.summ.utils.JsonUtil;
import com.summ.utils.StringUtil;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jygj_7500
 * @date 17/12/18
 */
@Controller
@RequestMapping("/nanny/job")
public class NannyJobController extends AutoMapperController{

    @ResponseBody
    @RequestMapping("/find")
    public Object findJobData(@RequestBody JNannyInfo jNannyInfo){
        try {
            NannyInfoRes nannyInfoRes = jNannyInfoMapper.getJobData(jNannyInfo.getNannyId());

            List<NannyShopRes> nannyShopResList = jNannyInfoMapper.getNannyShop(jNannyInfo.getNannyId());
            if (nannyShopResList!=null){
                nannyInfoRes.setNannyShopRes(nannyShopResList);
            }
            List<NannyJobLevelRes> jobLevelRes = jNannyInfoMapper.getNannyJobLevel(jNannyInfo.getNannyId());
            if (jobLevelRes!=null){
                nannyInfoRes.setNannyJobLevelRes(jobLevelRes);
            }

            return new ModelRes(ModelRes.Status.SUCCESS,"search NannyInfo success !",nannyInfoRes);
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object updateJobData(@RequestBody JNannyInfo jNannyInfo){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannyInfoMapper.updateSelectiveById(jNannyInfo));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/shop/insert")
    public Object shopInsert(@RequestBody Map map, ServletRequest request){
        try {
            JNannyShop jNannyShop = new JNannyShop();
            jNannyShop.setNannyId((Integer) map.get("nannyId"));
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            jNannyShop.setShopId(jAdmin.getShopId());
            return new ModelRes(ModelRes.Status.SUCCESS,"search NannyInfo success !",jNannyShopMapper.insert(jNannyShop));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
    @ResponseBody
    @RequestMapping("/train/insert")
    public Object insertTrain(@RequestBody Map map){
        try {
            JNannyTrain jNannyTrain = null;
            jNannyTrain.setNannyId((Integer) map.get("nannyId"));
            jNannyTrain.setTrainId((Integer) map.get("id"));
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannyTrainMapper.insert(jNannyTrain));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/train/delete")
    public Object deleteTrain(@RequestBody Map map){
        try {
            JNannyTrain jNannyTrain = new JNannyTrain();
            jNannyTrain.setNannyTrainId((Integer) map.get("id"));
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannyTrainMapper.deleteSelective(jNannyTrain));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/train/find/selected")
    public Object findTrain(@RequestBody JNannyTrain jNannyTrain){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannyTrainMapper.getSelectedTrainList(jNannyTrain.getNannyId()));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/train/find/unselected")
    public Object trainDict(@RequestBody Map map){
        try {
            Integer nannyId = (Integer) map.get("nannyId");
            String name = (String) map.get("name");
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",JsonUtil.list2map(jNannyTrainMapper.getUnselectedTrainList(nannyId,name)));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/level/insert")
    public Object insertLevel(@RequestBody Map map){
        try {
            JNannyJobLevel jNannyJobLevel = new JNannyJobLevel();
            jNannyJobLevel.setNannyId((Integer) map.get("nannyId"));
            jNannyJobLevel.setJobLevelId((Integer) map.get("id"));
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !", jNannyJobLevelMapper.insert(jNannyJobLevel));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/level/delete")
    public Object deleteLevel(@RequestBody Map map){
        try {
            JNannyJobLevel jNannyJobLevel = new JNannyJobLevel();
            jNannyJobLevel.setNannyJobLevelId((Integer) map.get("id"));
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannyJobLevelMapper.deleteSelective(jNannyJobLevel));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/level/find/selected")
    public Object findLevel(@RequestBody JNannyJobLevel jNannyJobLevel){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannyJobLevelMapper.getSelectedLevelList(jNannyJobLevel.getNannyId()));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/level/find/unselected")
    public Object LevelDict(@RequestBody Map map){
        try {
            Integer nannyId = (Integer) map.get("nannyId");
            String name = (String) map.get("name");
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !", JsonUtil.list2map(jNannyJobLevelMapper.getUnselectedLevelList(nannyId,name)));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }


}
