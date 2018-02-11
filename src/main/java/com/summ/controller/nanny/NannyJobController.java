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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jygj_7500
 * @date 17/12/18
 */
@Controller
@RequestMapping("/nanny/job")
public class NannyJobController extends AutoMapperController {

    @ResponseBody
    @RequestMapping("/find")
    public Object findJobData(@RequestBody JNannyInfo jNannyInfo) {
        try {
            NannyInfoRes nannyInfoRes = jNannyInfoMapper.getJobData(jNannyInfo.getNannyId());
            //判断nannyInfoRes是否有数据，没有数据则该对象为空，需重新new。
            if (nannyInfoRes == null) {
                NannyInfoRes nannyInfoRes1 = new NannyInfoRes();
                List<NannyShopRes> nannyShopResList = jNannyInfoMapper.getNannyShop(jNannyInfo.getNannyId());
                if (nannyShopResList != null) {
                    nannyInfoRes1.setNannyShopRes(nannyShopResList);
                }
                List<NannyJobLevelRes> jobLevelRes = jNannyInfoMapper.getNannyJobLevel(jNannyInfo.getNannyId());
                if (jobLevelRes != null) {
                    nannyInfoRes1.setNannyJobLevelRes(jobLevelRes);
                }
                return new ModelRes(ModelRes.Status.SUCCESS, "search NannyInfo success !", nannyInfoRes1);
            }

            List<NannyShopRes> nannyShopResList = jNannyInfoMapper.getNannyShop(jNannyInfo.getNannyId());
            if (nannyShopResList != null) {
                nannyInfoRes.setNannyShopRes(nannyShopResList);
            }
            List<NannyJobLevelRes> jobLevelRes = jNannyInfoMapper.getNannyJobLevel(jNannyInfo.getNannyId());
            if (jobLevelRes != null) {
                nannyInfoRes.setNannyJobLevelRes(jobLevelRes);
            }
            return new ModelRes(ModelRes.Status.SUCCESS, "search NannyInfo success !", nannyInfoRes);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object updateJobData(@RequestBody JNannyInfo jNannyInfo) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "update NannyInfo success !", jNannyInfoMapper.updateSelectiveById(jNannyInfo));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 给服务师绑定门店
     *
     * @param map
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/shop/insert")
    public Object shopInsert(@RequestBody Map map, ServletRequest request) {
        try {
            Integer shopId = (Integer) map.get("shopId");
            Integer nannyId = (Integer) map.get("nannyId");
            Map map1 = new HashMap();
            map1.put("shopId",shopId);
            map1.put("nannyId",nannyId);
            if (jNannyShopMapper.selectByMap(map1).size()<=0){
                JNannyShop jNannyShop = new JNannyShop();
                jNannyShop.setNannyId(nannyId);
                jNannyShop.setShopId(shopId);
                jNannyShopMapper.insert(jNannyShop);
            }else {
                return new ModelRes(ModelRes.Status.FAILED, "该服务师不能重复添加同一门店 !",null );
            }

            return new ModelRes(ModelRes.Status.SUCCESS, "search NannyInfo success !",null );

        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 服务师工种增删改查
     *
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/level/insert")
    public Object insertLevel(@RequestBody Map map) {
        try {
            Integer languageId = (Integer) map.get("id");
            if (languageId == 0) {
                //新增数据字典
                JDictInfo jDictInfo = new JDictInfo();
                jDictInfo.setTypecode(16);
                jDictInfo.setInfo((String) map.get("info"));
                jDictInfoMapper.insert(jDictInfo);

                //插入服务师技能表
                JNannyJobLevel jNannyJobLevel = new JNannyJobLevel();
                jNannyJobLevel.setNannyId((Integer) map.get("nannyId"));
                jNannyJobLevel.setJobLevelId(jDictInfo.getId());
                return new ModelRes(ModelRes.Status.SUCCESS, "update NannyInfo success !", jNannyJobLevelMapper.insert(jNannyJobLevel));
            } else {
                JNannyJobLevel jNannyJobLevel = new JNannyJobLevel();
                jNannyJobLevel.setNannyId((Integer) map.get("nannyId"));
                jNannyJobLevel.setJobLevelId((Integer) map.get("id"));
                return new ModelRes(ModelRes.Status.SUCCESS, "update NannyInfo success !", jNannyJobLevelMapper.insert(jNannyJobLevel));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/level/delete")
    public Object deleteLevel(@RequestBody Map map) {
        try {
            Map map1 = new HashMap();
            map1.put("nannyJobLevelId", map.get("id"));
            return new ModelRes(ModelRes.Status.SUCCESS, "update NannyInfo success !", jNannyJobLevelMapper.deleteByMap(map1));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 服务师已选工种
     *
     * @param jNannyJobLevel
     * @return
     */
    @ResponseBody
    @RequestMapping("/level/find/selected")
    public Object findLevel(@RequestBody JNannyJobLevel jNannyJobLevel) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "update NannyInfo success !", jNannyJobLevelMapper.getSelectedLevelList(jNannyJobLevel.getNannyId()));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 服务师未选工种
     *
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/level/find/unselected")
    public Object LevelDict(@RequestBody Map map) {
        try {
            Integer nannyId = (Integer) map.get("nannyId");
            String name = (String) map.get("name");
            return new ModelRes(ModelRes.Status.SUCCESS, "update NannyInfo success !", JsonUtil.list2map(jNannyJobLevelMapper.getUnselectedLevelList(nannyId, name)));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }


}
