package com.summ.controller.nanny;

import com.summ.controller.basic.AutoMapperController;
import com.summ.model.*;
import com.summ.model.response.*;
import com.summ.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 *
 * @author jygj_7500
 * @date 17/12/18
 */
@Controller
@RequestMapping("/nanny/other")
public class NannyOtherController extends AutoMapperController{

    @ResponseBody
    @RequestMapping("/find")
    public Object findOtherData(@RequestBody JNannyInfo jNannyInfo){
        try {
            int nannyId = jNannyInfo.getNannyId();
            NannyInfoRes nannyInfoRes = jNannyInfoMapper.getNannyOther(nannyId);
            List<NannyReligionRes> nannyReligionRes = jNannyInfoMapper.getNannyReligion(nannyId);
            if (nannyReligionRes!=null){
                nannyInfoRes.setNannyReligionRes(nannyReligionRes);
            }

            List<NannyLanguageRes> nannyLanguageRes = jNannyInfoMapper.getNannyLanguage(nannyId);
            if (nannyLanguageRes!=null){
                nannyInfoRes.setNannyLanguageRes(nannyLanguageRes);
            }


            List<NannySkillRes> nannySkillRes = jNannyInfoMapper.getNannySkill(nannyId);
            if (nannySkillRes!=null){
                nannyInfoRes.setNannySkillRes(nannySkillRes);
            }

            List<NannyCharacterRes> nannyCharacterRes = jNannyInfoMapper.getNannyCharacter(nannyId);
            if (nannyCharacterRes!=null){
                nannyInfoRes.setNannyCharacterRes(nannyCharacterRes);
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

    /**
     * CRUD for nanny religion
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/religion/insert")
    public Object insertReligion(@RequestBody Map map){
        try {
            JNannyReligion jNannyReligion = new JNannyReligion();
            jNannyReligion.setNannyId((Integer) map.get("nannyId"));
            jNannyReligion.setReligionId((Integer) map.get("id"));
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannyReligionMapper.insert(jNannyReligion));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/religion/delete")
    public Object deleteReligion(@RequestBody Map map){
        try {
            JNannyReligion jNannyReligion = new JNannyReligion();
            Integer id = (Integer) map.get("id");
            jNannyReligion.setNannyReligId(id);
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannyReligionMapper.deleteSelective(jNannyReligion));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/religion/find/selected")
    public Object findReligion(@RequestBody JNannyReligion jNannyReligion){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannyReligionMapper.getSelectedReligion(jNannyReligion.getNannyId()));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/religion/find/unselected")
    public Object religionDict(@RequestBody Map map){
        try {
            Integer nannyId = (Integer) map.get("nannyId");
            String name = (String) map.get("name");

            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !", JsonUtil.list2map(jNannyReligionMapper.getUnselectedReligion(nannyId,name)));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * CRUD for nanny language
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/language/insert")
    public Object insertLanguage(@RequestBody Map map){
        try {
            JNannyLanguage jNannyLanguage = new JNannyLanguage();
            jNannyLanguage.setNannyId((Integer) map.get("nannyId"));
            jNannyLanguage.setLanguageId((Integer) map.get("id"));
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannyLanguageMapper.insert(jNannyLanguage));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/language/delete")
    public Object deleteLanguage(@RequestBody Map map){
        try {
            JNannyLanguage jNannyLanguage = new JNannyLanguage();
            jNannyLanguage.setNannyLangId((Integer) map.get("id"));
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannyLanguageMapper.deleteSelective(jNannyLanguage));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/language/find/selected")
    public Object findLanguage(@RequestBody JNannyLanguage jNannyLanguage){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannyLanguageMapper.getSelectedLanguage(jNannyLanguage.getNannyId()));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/language/find/unselected")
    public Object languageDict(@RequestBody Map map){
        try {
            Integer nannyId = (Integer) map.get("nannyId");
            String name = (String) map.get("name");
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",JsonUtil.list2map(jNannyLanguageMapper.getUnselectedLanguage(nannyId,name)));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * CRUD for nanny skill
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/skill/insert")
    public Object insertSkill(@RequestBody Map map){
        try {
            JNannySkill jNannySkill = new JNannySkill();
            jNannySkill.setNannyId((Integer) map.get("nannyId"));
            jNannySkill.setSkillId((Integer) map.get("id"));
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannySkillMapper.insert(jNannySkill));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/skill/delete")
    public Object deleteSkill(@RequestBody Map map){
        try {
            JNannySkill jNannySkill = new JNannySkill();
            jNannySkill.setNannySkillId((Integer) map.get("id"));
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannySkillMapper.deleteSelective(jNannySkill));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/skill/find/selected")
    public Object findSkill(@RequestBody JNannySkill jNannySkill){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannySkillMapper.getSelectedSkill(jNannySkill.getNannyId()));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/skill/find/unselected")
    public Object skillDict(@RequestBody Map map){
        try {
            Integer nannyId = (Integer) map.get("nannyId");
            String name = (String) map.get("name");
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",JsonUtil.list2map(jNannySkillMapper.getUnselectedSkill(nannyId,name)));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * CRUD for nanny character
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/character/insert")
    public Object insertCharacter(@RequestBody Map map){
        try {
            JNannyCharacter jNannyCharacter = new JNannyCharacter();
            jNannyCharacter.setNannyId((Integer) map.get("nannyId"));
            jNannyCharacter.setCharacterId((Integer) map.get("id"));
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannyCharacterMapper.insert(jNannyCharacter));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/character/delete")
    public Object deleteCharacter(@RequestBody Map map){
        try {
            JNannyCharacter jNannyCharacter = new JNannyCharacter();
            jNannyCharacter.setNannyChaId((Integer) map.get("id"));
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannyCharacterMapper.deleteSelective(jNannyCharacter));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/character/find/selected")
    public Object findCharacter(@RequestBody JNannyCharacter jNannyCharacter){
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",jNannyCharacterMapper.getSelectedCharacter(jNannyCharacter.getNannyId()));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/character/find/unselected")
    public Object characterDict(@RequestBody Map map){
        try {
            Integer nannyId = (Integer) map.get("nannyId");
            String name = (String) map.get("name");
            return new ModelRes(ModelRes.Status.SUCCESS,"update NannyInfo success !",JsonUtil.list2map(jNannyCharacterMapper.getUnselectedCharacter(nannyId,name)));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

}
