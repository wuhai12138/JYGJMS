package com.summ.controller.supplier;

import com.summ.Consts;
import com.summ.controller.basic.AutoMapperController;
import com.summ.mapper.JSupplierMapper;
import com.summ.model.JAdmin;
import com.summ.model.JCustomerHouse;
import com.summ.model.JSupplier;
import com.summ.model.request.SupplierReq;
import com.summ.model.response.CustomerHouseRes;
import com.summ.model.response.ModelRes;
import com.summ.model.response.SupplierListRes;
import com.summ.utils.ResponseUtil;
import com.summ.utils.StringUtil;
import com.summ.utils.mongodb.MongoDBUtil;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.tools.internal.jxc.ap.Const;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/supplier")
public class SupplierController extends AutoMapperController {

    @ResponseBody
    @RequestMapping("/list")
    public Object findList(@RequestBody SupplierReq supplierReq) {
        try {
            supplierReq.setPage(supplierReq.getSize() * (supplierReq.getPage() - 1));
            Map map = new HashMap();
            map.put("count", jSupplierMapper.getSupplierListCount(supplierReq));
            map.put("list", jSupplierMapper.getSupplierList(supplierReq));
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
            SupplierListRes supplierListRes = jSupplierMapper.getSupplierDetail((Integer) map.get("supplierId"));
            if (!StringUtil.isBlank(supplierListRes.getBusinessLicense())){
                supplierListRes.setBusinessLicense(Consts.supplierBusinessLicenseUrlRes + supplierListRes.getBusinessLicense());
            }
            if (!StringUtil.isBlank(supplierListRes.getIdCardBefore())){
                supplierListRes.setIdCardBefore(Consts.supplierIdcardUrlRes + supplierListRes.getIdCardBefore());
            }
            if (!StringUtil.isBlank(supplierListRes.getIdCardAfter())){
                supplierListRes.setIdCardAfter(Consts.supplierIdcardUrlRes + supplierListRes.getIdCardAfter());
            }
            return new ModelRes(ModelRes.Status.SUCCESS, "search customer house info success !", supplierListRes);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JSupplier jSupplier) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "insert customer house info success !", jSupplierMapper.insertSelective(jSupplier));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/online")
    public Object online(@RequestBody Map map) {
        try {
            Integer supplierId = (Integer) map.get("supplierId");
            JSupplier jSupplier = jSupplierMapper.selectById(Long.valueOf(supplierId));
            if (jSupplier != null) {
                if (jSupplier.getSupplierStatus() == 181) {
                    return new ModelRes(ModelRes.Status.FAILED, "该供应商已上线 !");
                } else {
                    if (ResponseUtil.checkObjFieldIsNull(jSupplier)) {
                        return new ModelRes(ModelRes.Status.FAILED, "供应商信息不完整 !");
                    } else {
                        jSupplier.setSupplierStatus(181);
                        return new ModelRes(ModelRes.Status.SUCCESS, "成功上线 !", jSupplierMapper.updateSelectiveById(jSupplier));
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
    public Object updateHouse(@RequestBody JSupplier jSupplier) {
        try {
            /**上传营业执照*/
            if (!StringUtil.isBlank(jSupplier.getBusinessLicense())){
                String fileName = "SBL" + System.currentTimeMillis() + ".jpg";
                if (!StringUtil.generateImage(jSupplier.getBusinessLicense(), Consts.supplierBusinessLicenseUrl + fileName)) {
                    return new ModelRes(ModelRes.Status.FAILED, "供应商营业执照上传失败 !");
                }
                jSupplier.setBusinessLicense(fileName);
            }
            /**上传身份证正面*/
            if (!StringUtil.isBlank(jSupplier.getIdCardBefore())){
                String fileName = "SI" + System.currentTimeMillis() + ".jpg";
                if (!StringUtil.generateImage(jSupplier.getIdCardBefore(), Consts.supplierIdcardUrl + fileName)) {
                    return new ModelRes(ModelRes.Status.FAILED, "供应商身份证正面上传失败 !");
                }
                jSupplier.setIdCardBefore(fileName);
            }
            /**上传身份证反面*/
            if (!StringUtil.isBlank(jSupplier.getIdCardAfter())){
                String fileName = "SI" + System.currentTimeMillis() + ".jpg";
                if (!StringUtil.generateImage(jSupplier.getIdCardAfter(), Consts.supplierIdcardUrl + fileName)) {
                    return new ModelRes(ModelRes.Status.FAILED, "供应商身份证反面上传失败 !");
                }
                jSupplier.setIdCardAfter(fileName);
            }
            jSupplierMapper.updateSelectiveById(jSupplier);

            SupplierListRes supplierListRes = jSupplierMapper.getSupplierDetail(jSupplier.getSupplierId());
            if (!StringUtil.isBlank(supplierListRes.getBusinessLicense())){
                supplierListRes.setBusinessLicense(Consts.supplierBusinessLicenseUrlRes + supplierListRes.getBusinessLicense());
            }
            if (!StringUtil.isBlank(supplierListRes.getIdCardBefore())){
                supplierListRes.setIdCardBefore(Consts.supplierIdcardUrlRes + supplierListRes.getIdCardBefore());
            }
            if (!StringUtil.isBlank(supplierListRes.getIdCardAfter())){
                supplierListRes.setIdCardAfter(Consts.supplierIdcardUrlRes + supplierListRes.getIdCardAfter());
            }
            return new ModelRes(ModelRes.Status.SUCCESS, "update customer house info success !", supplierListRes);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

}
