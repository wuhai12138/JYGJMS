package com.summ.controller.customer;

import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.ExtendParams;
import com.alipay.demo.trade.model.GoodsDetail;
import com.alipay.demo.trade.model.builder.AlipayTradePrecreateRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPrecreateResult;
import com.alipay.demo.trade.service.AlipayMonitorService;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayMonitorServiceImpl;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import com.alipay.demo.trade.service.impl.AlipayTradeWithHBServiceImpl;
import com.alipay.demo.trade.utils.ZxingUtils;
import com.summ.Consts;
import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JAdmin;
import com.summ.model.JCustomer;
import com.summ.model.JCustomerStatment;
import com.summ.model.JShop;
import com.summ.model.response.ALIPayResult;
import com.summ.model.response.CustomerRes;
import com.summ.model.response.ModelRes;
import com.summ.utils.AlipayUtil;
import com.summ.utils.JsonUtil;
import com.summ.utils.OrderUtil;
import com.summ.utils.StringUtil;
import com.sun.deploy.nativesandbox.comm.Request;
import org.apache.commons.collections.map.HashedMap;
import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.*;

/**
 * 客户充值
 * Created by jygj_7500 on 18/1/18.
 */
@Controller
public class CustomerRechargeController extends AutoMapperController {




    /**
     * 客户充值
     *
     * @param map
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/customer/charge")
    public Object recharge(@RequestBody Map map, ServletRequest request) {
        String rechargeMoney = (String) map.get("money");
        Integer customerId = (Integer) map.get("customerId");
        Integer chargeWay = (Integer) map.get("chargeWay");
        JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
        JCustomer jCustomer = jCustomerMapper.selectById(Long.valueOf(customerId));
        JShop jShop = jShopMapper.selectById(Long.valueOf(jCustomer.getShopId()));

        JCustomerStatment jCustomerStatment = new JCustomerStatment();
        jCustomerStatment.setStatmentCustomer(OrderUtil.generateStamentNumber(chargeWay, 38));
        jCustomerStatment.setCustomerId(customerId);
        //38表示充值
        jCustomerStatment.setStatmentCustomerType(38);
        jCustomerStatment.setChargeDate(new Date());
        jCustomerStatment.setBalance(jCustomer.getCustomerBalance());
        jCustomerStatment.setTerminal(49);
        jCustomerStatment.setChargeMoney(new BigDecimal(rechargeMoney));
        jCustomerStatment.setChargeWay(Consts.zhifubao);
        jCustomerStatment.setAdminId(jAdmin.getAdminId());
        //54表示支付未成功，等待支付宝回调
        jCustomerStatment.setStatus(54);
        jCustomerStatment.setBalance(jCustomer.getCustomerBalance());

        jCustomerStatmentMapper.insertSelective(jCustomerStatment);

        //支付宝支付
        if (chargeWay == Consts.zhifubao) {
            /** 一定要在创建AlipayTradeService之前调用Configs.init()设置默认参数
             *  Configs会读取classpath下的zfbinfo.properties文件配置信息，如果找不到该文件则确认该文件是否在classpath目录
             */
            Configs.init("zfbinfo.properties");

            /** 使用Configs提供的默认参数
             *  AlipayTradeService可以使用单例或者为静态成员对象，不需要反复new
             */
            AlipayUtil.tradeService = new AlipayTradeServiceImpl.ClientBuilder().build();

            // 支付宝当面付2.0服务（集成了交易保障接口逻辑）
            AlipayUtil.tradeWithHBService = new AlipayTradeWithHBServiceImpl.ClientBuilder().build();

            /** 如果需要在程序中覆盖Configs提供的默认参数, 可以使用ClientBuilder类的setXXX方法修改默认参数 否则使用代码中的默认设置 */
            /**monitorService = new AlipayMonitorServiceImpl.ClientBuilder().setGatewayUrl("http://mcloudmonitor.com/gateway.do").setCharset("GBK").setFormat("json").build();*/

            AlipayF2FPrecreateResult result = AlipayUtil.test_trade_precreate("家有管家--扫码充值",jCustomerStatment.getStatmentCustomer(), rechargeMoney, customerId, jCustomer.getCustomerName(), jCustomer.getCustomerPhone(), jShop.getShopName(), "http://api.jyguanjia.com:8081/JYGJMS/aliPay/callback");

            switch (result.getTradeStatus()) {
                case SUCCESS:
                    System.out.println("支付宝预下单成功: ");

                    AlipayTradePrecreateResponse response = result.getResponse();

                    return new ModelRes(ModelRes.Status.SUCCESS, "success !", response.getQrCode());

                case FAILED:
                    System.out.println("支付宝预下单失败!!!");
                    return new ModelRes(ModelRes.Status.FAILED, "支付宝预下单失败 !", null);

                case UNKNOWN:
                    System.out.println("系统异常，预下单状态未知!!!");
                    return new ModelRes(ModelRes.Status.FAILED, " 系统异常，预下单状态未知!", null);

                default:
                    System.out.println("不支持的交易状态，交易返回异常!!!");
                    return new ModelRes(ModelRes.Status.FAILED, "不支持的交易状态，交易返回异常 !", null);
            }

        } else {
            return new ModelRes(ModelRes.Status.FAILED, "当前不支持微信支付 !", null);
        }

    }

    /**
     * 支付宝充值回调
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/aliPay/callback", method = RequestMethod.POST)
    public String AliPayResult(HttpServletRequest request) throws Exception {
        Map requestParams = request.getParameterMap();
        System.out.println("Aly Callback data Map:" + JsonUtil.toJson(requestParams));

        ALIPayResult aliPayResult = JsonUtil.json2Bean(JsonUtil.toJson(requestParams), ALIPayResult.class);

        if (request.getParameter("trade_status") != null && request.getParameter("trade_status").equals("TRADE_SUCCESS")) {

            //通过系统订单号找到该对账单
            Map map = new HashedMap();
            map.put("statmentCustomer", aliPayResult.getOut_trade_no().get(0));
            JCustomerStatment jCustomerStatment = (JCustomerStatment) jCustomerStatmentMapper.selectByMap(map).get(0);

            //修改对账单余额和状态
            jCustomerStatment.setBalance(jCustomerStatment.getBalance().subtract(jCustomerStatment.getChargeMoney()));
            jCustomerStatment.setStatus(53);
            jCustomerStatment.setSerialNumber(aliPayResult.getTrade_no().get(0));

            //修改客户余额
            JCustomer jCustomer = new JCustomer();
            jCustomer.setCustomerId(jCustomerStatment.getCustomerId());
            jCustomer.setCustomerBalance(jCustomerStatment.getBalance());

            jCustomerStatmentMapper.updateSelectiveById(jCustomerStatment);
            jCustomerMapper.updateSelectiveById(jCustomer);
            return "PayResult";
        } else {
            return "error";
        }
    }


}
