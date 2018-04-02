package com.summ;

/**
 * 全局常量
 * 
 * @author johsnon
 *
 */
public final class Consts {

	/**图片上传地址*/
	public static String nannyAvatarUrl = "/web/images/nannyavatar/";
	public static String nannyCertUrl = "/web/images/nannycertificate/";
	public static String supplierBusinessLicenseUrl = "/web/images/supplierbusinesslicense/";
	public static String leaguerBusinessLicenseUrl = "/web/images/leaguerbusinesslicense/";
	public static String supplierIdcardUrl = "/web/images/supplieridcard/";
	public static String leaguerIdcardUrl = "/web/images/leagueridcard/";

	/**图片下载地址*/
	public static String nannyAvatarUrlRes = "http://three.jyguanjia.com/images/nannyavatar/";
	public static String nannyCertUrlRes = "http://three.jyguanjia.com/images/nannycertificate/";
	public static String supplierBusinessLicenseUrlRes = "http://three.jyguanjia.com/images/supplierbusinesslicense/";
	public static String leaguerBusinessLicenseUrlRes = "http://three.jyguanjia.com/images/leaguerbusinesslicense/";
	public static String supplierIdcardUrlRes = "http://three.jyguanjia.com/images/supplieridcard/";
	public static String leaguerIdcardUrlRes = "http://three.jyguanjia.com/images/leagueridcard/";

	public static boolean DEBUG_MODE = false;

	/**充值方式*/
	public static int zhifubao = 44;
	public static int weixin = 45;
	public static int card = 209;
	public static int cash = 127;

	/**百度地图API ak*/
	public static String ak = "GpprDsu0RcV1PAm8qRd1MBTBt2En99Tv";

	/**服务器地址*/
	public static String serverUrl = "http://three.jyguanjia.com:8080/JYGJMS";


	/**
	 * 应用ID、商户ID、回头啊函数、商户密钥、微信接口
	 */
	public interface ConstWeiXin {
		String APP_ID = "wx1024cb31dfbae7cc";
		String MCH_ID = "1488511392";
		String WEIXIN_CALLBACK_URL = "http://112.74.182.69:8082/customer/WeiXinPayResultNew";
		String KEY = "beaaa56c4ad04744391d322ff2884db8";
		String URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		String PACKAGE_VALUE = "Sign=WXPay";//packageValue
	}
}
