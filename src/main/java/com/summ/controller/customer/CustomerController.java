package com.summ.controller.customer;

import com.alibaba.druid.support.json.JSONUtils;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.result.AlipayF2FPrecreateResult;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import com.alipay.demo.trade.service.impl.AlipayTradeWithHBServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.summ.Consts;
import com.summ.controller.basic.AutoMapperController;
import com.summ.model.*;
import com.summ.model.others.GetWXResult;
import com.summ.model.others.PayCallBackObj;
import com.summ.model.others.WeiXinSign;
import com.summ.model.request.CustomerPagReq;
import com.summ.model.request.CustomerReq;
import com.summ.model.response.ALIPayResult;
import com.summ.model.response.ModelRes;
import com.summ.model.response.ShopRes;
import com.summ.utils.*;
import com.summ.utils.mongodb.MongoDBUtil;
import com.summ.utils.mongodb.model.MongoConfig;
import com.sun.imageio.plugins.jpeg.JPEG;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author jygj_7500
 * @date 17/11/20
 */
@Controller
@RequestMapping("/customer")
public class CustomerController extends AutoMapperController {
    /**
     * CRUD for customer
     *
     * @param customerReq
     * @return
     */

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(@RequestBody CustomerReq customerReq, ServletRequest request) {
        try {
            Map<String, Double> baiduMap = BaiduAPIUtil.getLngAndLat("上海市" + customerReq.getHouseAddress());
            if (baiduMap == null) {
                return new ModelRes(ModelRes.Status.FAILED, "获取不到该地址，请重新输入 !");
            }

            JCustomer jCustomer = new JCustomer();
            jCustomer.setCustomerName(customerReq.getCustomerName());
            jCustomer.setCustomerSex(customerReq.getCustomerSex());
            ;
            jCustomer.setCustomerPhone(customerReq.getCustomerPhone());
            jCustomer.setRemark(customerReq.getRemark());
            jCustomerMapper.insert(jCustomer);


            JCustomerService jCustomerService = new JCustomerService();
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            jCustomerService.setAdminId(jAdmin.getAdminId());
            jCustomerService.setCustomerId(jCustomer.getCustomerId());
            jCustomerServiceMapper.insert(jCustomerService);
            Map map = new HashedMap();
            map.put("serviceDetail", customerReq.getServiceDetail());
            map.put("serviceId", jCustomerService.getServiceId());
            System.out.println("map>>>>>>>>>>>>>>>>>>>" + map.toString());
            mongoDBUtil = MongoDBUtil.getInstance(mongoConfig);
            mongoDBUtil.insert(map, "customer_service");

            JCustomerHouse jCustomerHouse = new JCustomerHouse();
            jCustomerHouse.setCustomerId(jCustomer.getCustomerId());
            jCustomerHouse.setBedRoom(customerReq.getBedRoom());
            jCustomerHouse.setLivingRoom(customerReq.getLivingRoom());
            jCustomerHouse.setRestRoom(customerReq.getRestRoom());
            jCustomerHouse.setHouseArea(customerReq.getHouseArea());
            jCustomerHouse.setAreaId(customerReq.getAreaId());
            jCustomerHouse.setHouseAddress(customerReq.getHouseAddress());
            jCustomerHouse.setLatitude(baiduMap.get("lat"));
            jCustomerHouse.setLongitude(baiduMap.get("lng"));
            jCustomerHouse.setServiceId(jCustomerService.getServiceId());
            jCustomerHouseMapper.insert(jCustomerHouse);

            List<JShop> shopList = jShopMapper.getAllShop();
            List<JShop> shopListRes = new ArrayList<JShop>();
            for (JShop jShop : shopList) {
                double distance = BaiduAPIUtil.getDistance(jCustomerHouse.getLongitude(), jCustomerHouse.getLatitude(), jShop.getLongitude(), jShop.getLatitude());
                if (distance < 2000) {
                    jShop.setDistance((int) distance);
                    shopListRes.add(jShop);
                }
            }
            /**如果匹配不到门店则返回总部门店*/
            if (shopListRes.size() == 0) {
                for (JShop jShop : shopList) {
                    if (jShop.getShopId() == 1) {
                        double distance = BaiduAPIUtil.getDistance(jCustomerHouse.getLongitude(), jCustomerHouse.getLatitude(), jShop.getLongitude(), jShop.getLatitude());
                        jShop.setDistance((int) distance);
                        shopListRes.add(jShop);
                    }
                }
            }

            Map responseMap = new HashedMap();
            responseMap.put("customerId", jCustomer.getCustomerId());
            responseMap.put("list", shopListRes);
            return new ModelRes(ModelRes.Status.SUCCESS, "add customer success !", responseMap);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestBody Map<String, List> jCustomer) {
        try {
            List list = jCustomer.get("customerId");
            System.out.println(">>>>>>>>>>>list>>>>>>>>>>>>" + list);
            return new ModelRes(ModelRes.Status.SUCCESS, "delete customer success !", jCustomerMapper.deleteList(list));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody JCustomer jCustomer) {
        try {
            JCustomer jCustomer1 = jCustomerMapper.selectById(Long.valueOf(jCustomer.getCustomerId()));
            if (!jCustomer.getShopId().equals(jCustomer1.getShopId())) {
                System.out.println("通知管家客户门店变更！");
                JShop jShop = jShopMapper.selectById(Long.valueOf(jCustomer.getShopId()));
                SendSMSUtil.notifyShopCustomer(jCustomer.getCustomerId(), jShop.getShopMobile());
            }
            return new ModelRes(ModelRes.Status.SUCCESS, "update customer success !", jCustomerMapper.updateSelectiveById(jCustomer));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    @ResponseBody
    @RequestMapping("/find")
    public Object find(@RequestBody CustomerPagReq customerPagReq, ServletRequest request) {
        try {
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            customerPagReq.setAdminId(jAdmin.getAdminId());
            customerPagReq.setPage(customerPagReq.getSize() * (customerPagReq.getPage() - 1));
            Map<String, Object> map = new HashedMap();
            map.put("count", jCustomerMapper.getCount(customerPagReq));
            map.put("list", jCustomerMapper.getCustomerList(customerPagReq));
            return new ModelRes(ModelRes.Status.SUCCESS, "search customer success !", map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 客户提现接口
     *
     * @param jCustomerStatment
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/cash")
    public Object cash(@RequestBody JCustomerStatment jCustomerStatment, ServletRequest request) {
        try {
            jCustomerStatment.setStatmentCustomer(String.valueOf(System.currentTimeMillis()));
            //获取管理员id
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            jCustomerStatment.setAdminId(jAdmin.getAdminId());
            //对账单状态为提现中，129
            jCustomerStatment.setStatus(129);
            //对账单类型为提现，41
            jCustomerStatment.setStatmentCustomerType(41);
            return new ModelRes(ModelRes.Status.SUCCESS, "search customer success !", jCustomerStatmentMapper.insert(jCustomerStatment));
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
        }
    }

    /**
     * 客户充值接口
     *
     * @param map
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/recharge")
    public Object recharge(@RequestBody Map map, ServletRequest request) {
        try {
            String rechargeMoney = (String) map.get("money");
            Integer customerId = (Integer) map.get("customerId");
            Integer chargeWay = (Integer) map.get("chargeWay");
            JAdmin jAdmin = (JAdmin) request.getAttribute("admin");
            String serialNumber = (String) map.get("serialNumber");
            JCustomer jCustomer = jCustomerMapper.selectById(Long.valueOf(customerId));
            JShop jShop = jShopMapper.selectById(Long.valueOf(jCustomer.getShopId()));

            JCustomerStatment jCustomerStatment = new JCustomerStatment();
            jCustomerStatment.setStatmentCustomer(OrderUtil.generateStamentNumber(customerId));
            jCustomerStatment.setCustomerId(customerId);
            jCustomerStatment.setShopId(jCustomer.getShopId());
            //38表示充值
            jCustomerStatment.setStatmentCustomerType(38);
            jCustomerStatment.setChargeDate(new Date());
            jCustomerStatment.setBalance(jCustomer.getCustomerBalance());
            jCustomerStatment.setTerminal(49);
            jCustomerStatment.setChargeMoney(new BigDecimal(rechargeMoney));
            jCustomerStatment.setChargeWay(chargeWay);
            jCustomerStatment.setAdminId(jAdmin.getAdminId());
            //54表示支付未成功，等待支付宝回调
            jCustomerStatment.setStatus(54);

            /**支付服务器所需信息*/
            PayCallBackObj payCallBackObj = new PayCallBackObj(jCustomer.getCustomerId(), jCustomer.getCustomerName(), jCustomer.getCustomerPhone(), jAdmin.getAdminId(), jShop.getShopName(), jShop.getShopId());

            /**支付宝支付*/
            if (chargeWay == Consts.zhifubao) {

                /**先添加对账单记录*/
                jCustomerStatmentMapper.insertSelective(jCustomerStatment);


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

                AlipayF2FPrecreateResult result = AlipayUtil.test_trade_precreate("家有管家--扫码充值", jCustomerStatment.getStatmentCustomer(), rechargeMoney, payCallBackObj, Consts.serverUrl + "/customer/aliPay/callback");

                switch (result.getTradeStatus()) {
                    case SUCCESS:
                        System.out.println("支付宝预下单成功: ");

                        AlipayTradePrecreateResponse response = result.getResponse();

                        return new ModelRes(ModelRes.Status.SUCCESS, "success !", response.getQrCode());

                    case FAILED:
                        System.out.println("支付宝预下单失败!!!");
                        return new ModelRes(ModelRes.Status.FAILED, "支付宝预下单失败 !", null);

                    case UNKNOWN:
                        System.out.println("系统异常，预下单状态未知!!");
                        return new ModelRes(ModelRes.Status.FAILED, " 系统异常，预下单状态未知!", null);

                    default:
                        System.out.println("不支持的交易状态，交易返回异常!!");
                        return new ModelRes(ModelRes.Status.FAILED, "不支持的交易状态，交易返回异常 !", null);
                }

            }
            /**微信支付*/
            else if (chargeWay == Consts.weixin) {
                /**先添加对账单记录*/
                jCustomerStatmentMapper.insertSelective(jCustomerStatment);

                return WeixinUtil.weiXinQrcodePay(jCustomerStatment.getStatmentCustomer(), rechargeMoney, Consts.serverUrl + "/customer/WeiXin/callback", payCallBackObj, "家有官家--扫码充值");
            }
            /**现金或者刷卡支付*/
            else if (chargeWay == Consts.card || chargeWay == Consts.cash) {
                jCustomerStatment.setStatus(53);
                jCustomerStatment.setSerialNumber(serialNumber);
                jCustomerStatment.setBalance(jCustomerStatment.getBalance().add(jCustomerStatment.getChargeMoney()));
                jCustomerStatmentMapper.insertSelective(jCustomerStatment);

                jCustomer.setCustomerBalance(jCustomerStatment.getBalance());
                jCustomerMapper.updateSelectiveById(jCustomer);
                return new ModelRes(ModelRes.Status.SUCCESS, "充值成功 !", null);
            } else {
                return new ModelRes(ModelRes.Status.FAILED, "当前不支持当前支付 !", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelRes(ModelRes.Status.ERROR, "server err !");
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

            Map map = new HashMap();
            map.put("statmentCustomer", aliPayResult.getOut_trade_no().get(0));
            List<JCustomerStatment> jCustomerStatmentList = jCustomerStatmentMapper.selectByMap(map);
            for (JCustomerStatment jCustomerStatment : jCustomerStatmentList) {
                jCustomerStatment.setBalance(jCustomerStatment.getBalance().add(new BigDecimal(Double.valueOf(aliPayResult.getBuyer_pay_amount().get(0)))));
                jCustomerStatment.setSerialNumber(aliPayResult.getTrade_no().get(0));
                jCustomerStatment.setStatus(53);
                jCustomerStatmentMapper.updateById(jCustomerStatment);

                JCustomer jCustomer = new JCustomer();
                jCustomer.setCustomerId(jCustomerStatment.getCustomerId());
                jCustomer.setCustomerBalance(jCustomerStatment.getBalance());
                jCustomerMapper.updateSelectiveById(jCustomer);
            }
            return "PayResult";
        } else {
            return "error";
        }
    }

    /**
     * 微信充值回调
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/WeiXin/callback", method = RequestMethod.POST)
    public String WeiXinResult(HttpServletRequest request) throws Exception {
        String inputLine;
        StringBuffer notifyXml = new StringBuffer();
        try {
            while ((inputLine = request.getReader().readLine()) != null) {
                notifyXml.append(inputLine);
                System.out.println(" ");
            }
            request.getReader().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("notifyXml:" + notifyXml.toString());
        GetWXResult get = (GetWXResult) JsonUtil.getObjectFromXML(notifyXml.toString(), GetWXResult.class);
        System.out.println("notifyObj:" + get.toString());
        if (get.getResult_code().equals("SUCCESS")) {
            Map map = new HashMap();
            map.put("statmentCustomer", get.getOut_trade_no());
            List<JCustomerStatment> jCustomerStatmentList = jCustomerStatmentMapper.selectByMap(map);
            for (JCustomerStatment jCustomerStatment : jCustomerStatmentList) {
                jCustomerStatment.setBalance(jCustomerStatment.getBalance().add(new BigDecimal(Double.valueOf(get.getTotal_fee()) / 100)));
                jCustomerStatment.setSerialNumber(get.getTransaction_id());
                jCustomerStatment.setStatus(53);
                jCustomerStatmentMapper.updateById(jCustomerStatment);

                JCustomer jCustomer = new JCustomer();
                jCustomer.setCustomerId(jCustomerStatment.getCustomerId());
                jCustomer.setCustomerBalance(jCustomerStatment.getBalance());
                jCustomerMapper.updateSelectiveById(jCustomer);
            }
            return "PayResult";
        }
        return "error";
    }


}
