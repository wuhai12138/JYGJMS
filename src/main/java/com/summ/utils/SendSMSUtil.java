package com.summ.utils;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * Created by admin on 2017/2/14.
 * aliyun.com yangxubin@jyguanjia.com Ilikedh123
 */
public class SendSMSUtil {



    private static String serverUrl = "http://gw.api.taobao.com/router/rest";
    private static String appKey = "23600218";
    private static String appSecret = "f26d78ecb2b899f62f518af835f438a4";
    private static String signName = "家有管家";


    /**
     * 充值短信发送
     * @param phone
     * @param shopName
     * @param chargeWay
     * @param money
     * @param customer_balance
     * @return
     */
    public static String sendPhoneMsg(String phone, String shopName, String chargeWay, Double money, double customer_balance ){
        System.out.println("sendPhoneMsg");

        TaobaoClient client = new DefaultTaobaoClient(serverUrl, appKey, appSecret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("");
        req.setSmsType("normal");
        req.setSmsFreeSignName(signName);
        req.setSmsParamString("{\"shop_name\":\""+shopName+"\",\"charge_way\":\""+chargeWay+"\",\"money\":\""+money+"\",\"balance\":\""+customer_balance+"\"}");
        req.setRecNum(phone);
        req.setSmsTemplateCode("SMS_46695220");
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        try {
            rsp = client.execute(req);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(rsp.getBody());
        return "发送成功!";
    }


    /**
     * 下单短信
     * @param phone
     * @param shop
     * @param type
     * @return
     */
    public static String sendPhoneMsgOrder(String phone, String shop, String type){
        System.out.println("sendPhoneMsg");

        TaobaoClient client = new DefaultTaobaoClient(serverUrl, appKey, appSecret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("");
        req.setSmsType("normal");
        req.setSmsFreeSignName(signName);
        req.setSmsParamString("{\"shop\":\""+shop+"\",\"type\":\""+type+"\"}");
        req.setRecNum(phone);
        req.setSmsTemplateCode("SMS_47085003");
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        try {
            rsp = client.execute(req);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(rsp.getBody());
        return "发送成功!";
    }


    /**
     * 下单通知门店短信
     * @param customerPhone
     * @param shopPhone
     * @param customerName
     * @return
     */
    public static String notifyShop(String customerPhone, String shopPhone, String customerName){
        System.out.println("notifyShop");

        TaobaoClient client = new DefaultTaobaoClient(serverUrl, appKey, appSecret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("");
        req.setSmsType("normal");
        req.setSmsFreeSignName(signName);
        req.setSmsParamString("{\"phone\":\""+customerPhone+"\",\"name\":\""+customerName+"\"}");
        req.setRecNum(shopPhone);
        req.setSmsTemplateCode("SMS_126357567");
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        try {
            rsp = client.execute(req);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(rsp.getBody());
        return "发送成功!";
    }

    /**
     * 新客户通知门店短信
     * @param customer_id
     * @param shopPhone
     * @return
     */
    public static String notifyShopCustomer(int customer_id, String shopPhone){
        System.out.println("notifyShopCustomer");

        TaobaoClient client = new DefaultTaobaoClient(serverUrl, appKey, appSecret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("");
        req.setSmsType("normal");
        req.setSmsFreeSignName(signName);
        req.setSmsParamString("{\"customer_id\":\""+customer_id+"\"}");
        req.setRecNum(shopPhone);
        req.setSmsTemplateCode("SMS_128880176");
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        try {
            rsp = client.execute(req);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(rsp.getBody());
        return "发送成功!";
    }
}
