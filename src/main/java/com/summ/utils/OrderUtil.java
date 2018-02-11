package com.summ.utils;

import com.summ.Consts;
import javafx.scene.control.RadioMenuItem;

import java.util.Random;

/**
 * Created by jygj_7500 on 18/1/2.
 */
public class OrderUtil {
    public static String generateStamentNumber(Integer chargeWay, Integer statmentType) {
        System.out.println("对账单流水号>>>>" + String.valueOf(System.currentTimeMillis() + chargeWay + statmentType + Math.random() * 10000));

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf(System.currentTimeMillis()));
        stringBuffer.append(chargeWay);
        stringBuffer.append(statmentType);
        return stringBuffer.toString();
    }
}
