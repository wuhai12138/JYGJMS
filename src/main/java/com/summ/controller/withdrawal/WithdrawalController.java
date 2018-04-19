package com.summ.controller.withdrawal;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JAdmin;
import com.summ.model.JWithdrawal;
import com.summ.model.request.WithdrawalReq;
import com.summ.model.response.ModelRes;
import com.summ.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;

/**
 * 提现模块
 */
@Controller
@RequestMapping("/withdrawal")
public class WithdrawalController extends AutoMapperController{

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody JWithdrawal jWithdrawal, ServletRequest request) {
        try {
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !", jWithdrawalMapper.insertSelective(jWithdrawal));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody JWithdrawal jWithdrawal) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !", jWithdrawalMapper.updateSelectiveById(jWithdrawal));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody WithdrawalReq withdrawalReq, ServletRequest request) {
        try {
            return new ModelRes(ModelRes.Status.SUCCESS, "操作成功 !", ResponseUtil.List2Map(jWithdrawalMapper.selectList(new EntityWrapper<JWithdrawal>())));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }
}
