package com.summ.utils.dbUtil;

import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JCustomer;
import com.summ.model.JProvince;
import com.summ.model2.CustomerInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.ibatis.annotations.Case;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 迁移数据库类
 */
public final class DBMoveUtil {
    public static String[] province = new String[]{"上海市", "河南", "河北", "北京", "天津", "山东", "山西", "黑龙江", "吉林", "辽宁", "浙江", "江苏", "安徽",
            "江西", "湖南", "湖北", "新疆", "新疆生产建设兵团", "云南", "贵州", "福建", "台湾", "宁夏", "西藏",
            "四川", "重庆", "内蒙古", "广西", "海南", "青海", "甘肃", "陕西", "广东", "香港", "澳门", "暂无"};
    public static String[] nannyAnimalSign = new String[]{"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪", "暂无"};
    public static Integer[] nannyAnimalSignNum = new Integer[]{89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 126};
    public static String[] nannyEducation = new String[]{"中专", "大专", "无", "小学", "初中", "高中", "本科", "硕士", "博士"};
    public static Integer[] nannyEducationNum = new Integer[]{258, 259, 101, 102, 103, 104, 105, 106, 107};
    public static String[] nannyCertificate = new String[]{"身份", "健康", "母婴", "育婴", "早教", "家政", "其他"};
    public static Integer[] nannyCertificateNum = new Integer[]{189, 109, 115, 110, 111, 117, 280};

    /**
     * 获取籍贯字典
     *
     * @param originName
     * @return
     */
    public static Integer getNannyOrigin(String originName) {
        for (int i = 0; i < province.length; i++) {
            if (originName.contains(province[i])) {
                return i + 1;
            }
        }
        return 36;
    }

    /**
     * 获取生肖字典
     *
     * @param nannyAnimal
     * @return
     */
    public static Integer getNannyAnimal(String nannyAnimal) {
        for (int i = 0; i < nannyAnimalSign.length; i++) {
            if (nannyAnimal.contains(nannyAnimalSign[i])) {
                return nannyAnimalSignNum[i];
            }
        }
        return 126;
    }

    /**
     * 获取服务师学历
     *
     * @param nannyQualification
     * @return
     */
    public static Integer getNannyEducation(String nannyQualification) {
        for (int i = 0; i < nannyEducation.length; i++) {
            if (nannyQualification.contains(nannyEducation[i])) {
                return nannyEducationNum[i];
            }
        }
        return 101;
    }

    /**
     * 获取服务师证件类型
     *
     * @param certificate
     * @return
     */
    public static Integer getNannyCertificate(String certificate) {
        for (int i = 0; i < nannyCertificate.length; i++) {
            if (certificate.contains(nannyCertificate[i])) {
                return nannyCertificateNum[i];
            }
        }
        return nannyCertificateNum[6];
    }

    /**
     * 获取服务师对账单类型
     *
     * @param rpType
     * @return
     */
    public static Integer getNannyStatmentType(Integer rpType) {
        /** 对账单类型,1合同 2包月 3一次性 4免费 5试工 6包年 7奖励 8惩罚*/
        switch (rpType) {
            case 1:
                return 162;
            case 2:
                return 279;
            case 3:
                return 166;
            case 4:
                return 166;
            case 5:
                return 281;
            case 7:
                return 159;
            case 8:
                return 160;
            default:
                return 0;
        }
    }
    /**
     * 获取服务师CurrentJobLevel
     *
     * @param
     * @return
     */
    public static Integer getNannyCurrentJobLevel(Double mission_hour, BigDecimal mission_cost) {
        if (mission_hour.equals(0)){
            return 84;
        }
        Integer d = mission_cost.divide(new BigDecimal(mission_hour),BigDecimal.ROUND_HALF_UP).intValue();
        switch (d) {
            case 25:
                return 84;
            case 28:
                return 85;
            case 30:
                return 86;
            default:
                return 84;
        }
    }
    /**
     * 获取订单状态
     *
     * @param
     * @return
     */
    public static Integer getOrderStatus(Integer orderStatus) {
        /**1预约中/2未配单/3已配单(已删除此状态)/4试工中/5已开工/6已完工/7试工结束*/
        switch (orderStatus) {
            case 1:
                return 138;
            case 2:
                return 142;
            case 4:
                return 143;
            case 5:
                return 149;
            case 6:
                return 150;
            case 7:
                return 147;
            default:
                return 151;
        }
    }

    /**
     * 获取服务师CurrentUnitPrice
     *
     * @param
     * @return
     */
    public static BigDecimal getNannyCurrentUnitPrice(Double mission_hour, BigDecimal mission_cost) {
        if (mission_hour.equals(0)){
            return new BigDecimal(25);
        }
        Integer d = mission_cost.divide(new BigDecimal(mission_hour),BigDecimal.ROUND_HALF_UP).intValue();
        switch (d) {
            case 25:
                return new BigDecimal(25);
            case 28:
                return new BigDecimal(28);
            case 30:
                return new BigDecimal(30);
            default:
                return new BigDecimal(25);
        }
    }
    /**
     * 获取订单类型
     *
     * @param orderType
     * @return
     */
    public static Integer getOrderType(Integer orderType) {
        /** 订单类型,0全部1合同2包月3一次性4免费5包年*/
        switch (orderType) {
            case 1:
                return 163;
            case 2:
                return 277;
            case 3:
                return 164;
            case 5:
                return 165;
            default:
                return 0;
        }
    }

    /**
     * 客户对账单类型
     *
     * @param type
     * @param backup
     * @param orderType
     * @return
     */
    public static Integer getCustomerStatmentType(int type, String backup, int orderType) {
        switch (type) {
            //1、5合同2包月、3、4临时、6包年、0充值
            case 1:
                switch (orderType) {
                    case 1:
                        return 39;
                    case 2:
                        return 260;
                    case 3:
                        return 177;
                    case 4:
                        return 177;
                    case 5:
                        return 39;
                    case 6:
                        return 240;
                    default:
                        return 0;
                }
            case 2:
                return 38;
            case 3:
                return 0;
            case 4:
                switch (backup.substring(0, 2)) {
                    case "提现":
                        return 41;
                    case "退回":
                        return 42;
                    case "充值":
                        return 43;
                    default:
                        return 42;
                }
            default:
                return 0;


        }
    }

    /**
     * 客户房产
     *
     * @param roomType
     * @return
     */
    public static List<Integer> getHouse(String roomType) {
        List<Integer> list = new ArrayList<Integer>(3);
        list.add(0);
        list.add(0);
        list.add(0);
        if ("".equals(roomType) || null == roomType) {
            return list;
        }
        for (int i = 0; i < roomType.length() / 2; i++) {
            String str1 = roomType.substring(2 * i, 2 * i + 1);
            Integer strEnd1;
            switch (str1) {
                case "一":
                    strEnd1 = 1;
                    break;
                case "1":
                    strEnd1 = 1;
                    break;
                case "二":
                    strEnd1 = 2;
                    break;
                case "2":
                    strEnd1 = 2;
                    break;
                case "两":
                    strEnd1 = 2;
                    break;
                case "俩":
                    strEnd1 = 2;
                    break;
                case "三":
                    strEnd1 = 3;
                    break;
                case "3":
                    strEnd1 = 3;
                    break;
                case "四":
                    strEnd1 = 4;
                    break;
                case "4":
                    strEnd1 = 4;
                    break;
                case "五":
                    strEnd1 = 5;
                    break;
                case "5":
                    strEnd1 = 5;
                    break;
                case "七":
                    strEnd1 = 7;
                    break;
                case "7":
                    strEnd1 = 7;
                    break;
                case "六":
                    strEnd1 = 6;
                    break;
                case "6":
                    strEnd1 = 6;
                    break;
                default:
                    return list;
            }
            String str2 = roomType.substring(2 * i + 1, 2 * i + 2);
            switch (str2) {
                case "室":
                    list.set(i, strEnd1);
                    break;
                case "房":
                    list.set(i, strEnd1);
                    break;
                case "厅":
                    list.set(i, strEnd1);
                    break;
                case "卫":
                    list.set(i, strEnd1);
                    break;
                default:
                    list.add(i, 0);
            }
        }
        return list;
    }
}
