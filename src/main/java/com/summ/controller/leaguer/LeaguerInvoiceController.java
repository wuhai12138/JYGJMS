package com.summ.controller.leaguer;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JLeaguerInvoice;
import com.summ.model.JSupplierInvoice;
import com.summ.model.response.ModelRes;
import com.summ.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 供应商发票
 * @author jygj_7500
 */
@Controller
@RequestMapping("/leaguer/invoice")
public class LeaguerInvoiceController extends AutoMapperController{

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JLeaguerInvoice jLeaguerInvoice) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS,"",jLeaguerInvoiceMapper.insertSelective(jLeaguerInvoice));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody JLeaguerInvoice jLeaguerInvoice) {
        try {
            EntityWrapper entityWrapper = new EntityWrapper();
            return new ModelRes(ModelRes.Status.SUCCESS,"", ResponseUtil.List2Map(jLeaguerInvoiceMapper.selectList(entityWrapper)));
        }catch (Exception e){
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
}
