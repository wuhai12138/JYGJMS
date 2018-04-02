package com.summ.controller.supplier;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JSupplierInvoice;
import com.summ.model.response.ModelRes;
import com.summ.utils.ResponseUtil;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 供应商发票
 * @author jygj_7500
 */
@Controller
@RequestMapping("/supplier/invoice")
public class SupplierInvoiceController extends AutoMapperController{

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JSupplierInvoice jSupplierInvoice) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"",jSupplierInvoiceMapper.insertSelective(jSupplierInvoice));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody JSupplierInvoice jSupplierInvoice) {
        try {
            EntityWrapper entityWrapper = new EntityWrapper();
            return new ModelRes(ModelRes.Status.SUCCESS,"", ResponseUtil.List2Map(jSupplierInvoiceMapper.selectList(entityWrapper)));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
}
