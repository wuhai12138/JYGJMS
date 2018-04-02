package com.summ.utils;

import com.summ.Consts;
import com.summ.model.others.PayCallBackObj;
import com.summ.model.others.WeiXinSign;
import com.summ.model.response.ModelRes;
import com.thoughtworks.xstream.XStream;
import okhttp3.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by Mc on 2016/9/18.
 */

public class WeixinUtil {


    public static final String Base_URL = "http://112.74.182.69:8082/customer/";
    public static String APP_ID = "wx2b937f00f2ba8f15";
    public static String APP_SECERT = "b068a4f1c5ca181e37420a329a40b1ae";
    public static String MCH_ID = "1442095502";//商户号
    public static String PACKAGE_VALUE = "Sign=WXPay";//packageValue
    public static String API_KEY = "92737eewewesERERXCYUYjfdqwqSSD61";
    public static final String wxNotifyUrl = Base_URL + "WeiXinPayResult";//微信回调接口
    public static final String prepayId = "https://api.mch.weixin.qq.com/pay/unifiedorder";//微信获取prepayid


    /**
     * 微信面对面支付生成二维码
     * @param rechargeMoney
     * @param callBackUrl
     * @return
     */
    public static Object weiXinQrcodePay(String outTradeNo, String rechargeMoney, String callBackUrl, PayCallBackObj payCallBackObj, String body) {
        final String nonceStr = (System.currentTimeMillis() / 1000) + "";
        String responseStr = null;
        Map<String, String> paramMap = new HashMap<String, String>();

        //appid：每个公众号都有一个appid
        paramMap.put("appid", Consts.ConstWeiXin.APP_ID);
        //商户号：开通微信支付后分配
        paramMap.put("mch_id", Consts.ConstWeiXin.MCH_ID);
        //随机数
        paramMap.put("nonce_str", nonceStr);
        //商品描述
        paramMap.put("body", body);
        //附加数据
        paramMap.put("attach", payCallBackObj.toString());
        //商户订单号
        paramMap.put("out_trade_no", outTradeNo);
        //金额必须为整数  单位为分
        paramMap.put("total_fee", StringUtil.DoubleToAmountString(Double.valueOf(rechargeMoney) * 100, -1));
        //本机的Ip
        paramMap.put("spbill_create_ip", "192.168.1.31");
        //支付成功后，回调地址
        paramMap.put("notify_url", callBackUrl);
        //交易类型
        paramMap.put("trade_type", "NATIVE");

        System.out.println("paramMap>>>>>>>>>>>>>>" + paramMap);

        //调用签名函数生成签名
        String result = WeixinUtil.getSign(paramMap);

        //根据微信签名规则，生成签名。随机参数可以在商户后台管理系统中进行设置。
        paramMap.put("sign", result);
        //把参数转换成XML数据格式
        StringBuffer stringBuffer = new StringBuffer("<xml>");
        WeixinUtil.mapToXML(paramMap, stringBuffer);
        stringBuffer.append("</xml>");
        System.out.println("微信提交xml: \n" + stringBuffer.toString());

        okhttp3.RequestBody requestBody = okhttp3.RequestBody.create(MediaType.parse("utf-8"), stringBuffer.toString());
        okhttp3.Request okRequest = new okhttp3.Request.Builder().addHeader("Content-Type", "text/xml").url(Consts.ConstWeiXin.URL).post(requestBody).build();


        OkHttpClient okHttpClient = new OkHttpClient();
        try {
            Response response = okHttpClient.newCall(okRequest).execute();
            responseStr = response.body().string();

            WeiXinSign weiXinSign = (WeiXinSign) JsonUtil.getObjectFromXML(responseStr, WeiXinSign.class);


            Map<String, String> signMap = new HashMap<String, String>();
            signMap.put("appid", weiXinSign.getAppid());
            signMap.put("partnerid", Consts.ConstWeiXin.MCH_ID);
            signMap.put("prepayid", weiXinSign.getPrepay_id());
            signMap.put("package", Consts.ConstWeiXin.PACKAGE_VALUE);
            signMap.put("noncestr", weiXinSign.getNonce_str());
            signMap.put("timestamp", nonceStr);
            signMap.put("trade_type", weiXinSign.getTrade_type());
            signMap.put("code_url", weiXinSign.getCode_url());
            String sign = WeixinUtil.getSign(signMap);

            weiXinSign.setPackage_value(Consts.ConstWeiXin.PACKAGE_VALUE);
            weiXinSign.setTimestamp(nonceStr);
            weiXinSign.setSign(sign);
            System.out.println("weiXinSign>>>>>>>>>>>>>>>" + weiXinSign.toString());
            return new ModelRes(ModelRes.Status.SUCCESS, "获取签名订单信息成功", weiXinSign.getCode_url());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("支付失败信息>>>>>>>>>>>>>>>" + responseStr);
            return new ModelRes(ModelRes.Status.ERROR, "获取签名订单信息失败", null);
        }
    }

    /**
     * 要求外部订单号必须唯一。
     * Z
     *
     * @return
     */
    public static String getOutTradeNo() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);

        Random r = new Random();
        key = key + r.nextInt();
        key = key.substring(0, 15);
        return key;
    }


    public static String getSign(Map<String, String> map) {
        ArrayList<String> list = new ArrayList<String>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue() != "") {
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String[] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder resultStringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            resultStringBuilder.append(arrayToSort[i]);
        }
        System.out.println("resultStringBuilder》》》》》》" + resultStringBuilder);
        String result = resultStringBuilder.toString();
        result += "key=" + Consts.ConstWeiXin.KEY;
        System.out.println("result>>>>>>>>>>>>>>>" + result);
        result = MD5.MD5Encode(result, "UTF-8").toUpperCase();
        System.out.println("MD5result>>>>>>>>>>>>>>>" + result);
        return result;
    }

    public static Object getObjectFromXML(String xml, Class tClass) {
        //将从API返回的XML数据映射到Java对象
        XStream xStreamForResponseData = new XStream();
        xStreamForResponseData.alias("xml", tClass);
        xStreamForResponseData.ignoreUnknownElements();//暂时忽略掉一些新增的字段
        return xStreamForResponseData.fromXML(xml);
    }

    /**
     * Map集合转换xml文档
     */
    public static String mapToXml(HashMap<String, String> paramMap) {
        String xml = "";
        try {
            XStream xstream = new XStream();
            xml = xstream.toXML(paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return xml;
    }

    public static void mapToXML(Map map, StringBuffer sb) {
        Set set = map.keySet();
        for (Iterator it = set.iterator(); it.hasNext(); ) {
            String key = (String) it.next();
            Object value = map.get(key);
            if (null == value) {
                value = "";
            }
            if (value.getClass().getName().equals("java.util.ArrayList")) {
                ArrayList list = (ArrayList) map.get(key);
                sb.append("<" + key + ">");
                for (int i = 0; i < list.size(); i++) {
                    HashMap hm = (HashMap) list.get(i);
                    mapToXML(hm, sb);
                }
                sb.append("</" + key + ">\n");

            } else {
                if (value instanceof HashMap) {
                    sb.append("<" + key + ">");
                    mapToXML((HashMap) value, sb);
                    sb.append("</" + key + ">");
                } else {
                    sb.append("<" + key + ">" + value + "</" + key + ">");
                }

            }

        }
    }


    /**
     * 获取微信支付链接
     *
     * @param price 最终支付价格
     */
    public static String getPrepayId(String price, int customerId, String nonceStr, String shopName) {
        String responseStr = null;
        HashMap<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("appid", APP_ID); //appid：每个公众号都有一个appid
        paramMap.put("mch_id", MCH_ID); //商户号：开通微信支付后分配
        paramMap.put("nonce_str", nonceStr);//随机数
        paramMap.put("body", "家有管家-余额充值"); //商品描述
        paramMap.put("attach", customerId + "-" + shopName); //附加数据
        paramMap.put("out_trade_no", getOutTradeNo() + "");//商户订单号
        paramMap.put("total_fee", price); //金额必须为整数  单位为分
        paramMap.put("spbill_create_ip", "192.168.1.31"); //本机的Ip
        paramMap.put("notify_url", wxNotifyUrl); //支付成功后，回调地址
        paramMap.put("trade_type", "APP"); //交易类型
        paramMap.put("sign", WeixinUtil.getSign(paramMap));//根据微信签名规则，生成签名。随机参数可以在商户后台管理系统中进行设置。
        StringBuffer sb = new StringBuffer("<xml>");//把参数转换成XML数据格式
        WeixinUtil.mapToXML(paramMap, sb);
        sb.append("</xml>");
        System.out.println("微信提交xml: \n" + sb.toString());

        RequestBody requestBody = RequestBody.create(MediaType.parse("utf-8"), sb.toString());
        Request request = new Request.Builder().addHeader("Content-Type", "text/xml").url(prepayId).post(requestBody).build();


        OkHttpClient okHttpClient = new OkHttpClient();
        try {
            Response response = okHttpClient.newCall(request).execute();
            responseStr = response.body().string();
            System.out.println("weixin return： " + responseStr);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return responseStr;

    }


}
