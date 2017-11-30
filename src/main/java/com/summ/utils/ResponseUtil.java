package com.summ.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jygj_7500 on 17/11/30.
 */
public class ResponseUtil {

    public static Map List2Map(List list){
        Map map = new HashMap();
        map.put("list",list);
        return  map;
    }

}
