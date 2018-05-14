import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.summ.controller.basic.AutoMapperController;
import com.summ.model.JOrderContract;
import com.summ.model.JShop;
import com.summ.model.response.TimeAndWeekRes;
import com.summ.utils.DateUtil;
import com.summ.utils.NannyWorkTimeUtil;
import com.summ.utils.RequestUtil;
import com.summ.utils.StringUtil;
import com.summ.utils.dbUtil.DBMoveUtil;
import com.sun.deploy.net.HttpUtils;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.http.HttpResponse;
import org.bson.Document;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by jygj_7500 on 17/11/17.
 */
public class DocumentTest {

    public static void main(String[] args) throws ParseException, IOException {
////        Long test = Long.valueOf(140737488355328) ;
//        BigDecimal bigDecimal = new BigDecimal(200);
//        BigDecimal bigDecimal1 = new BigDecimal(200);
////        System.out.println("sss"+bigDecimal.subtract(bigDecimal1));
//        System.out.println("aaaaaa>>>" + bigDecimal.compareTo(bigDecimal1));
//
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append(String.valueOf(System.currentTimeMillis()));
//        stringBuffer.append(48);
//        stringBuffer.append(152);
//        System.out.println("bbbbbbbbbb" + stringBuffer.toString());
//        System.out.println("cc" + String.valueOf(System.currentTimeMillis() + 48 + 152 + Math.random() * 10000));
//
//        List<Integer> mylist = Arrays.asList(1, 2, 3);
//        List<String> list = new ArrayList<String>();
//        for (int i = 0; i < mylist.size() - 1; i++) {
//            for (int j = i + 1; j < mylist.size(); j++) {
//                list.add(mylist.get(i) + ":" + mylist.get(j));
//            }
//        }
//        List<TimeAndWeekRes> timeAndWeekResList = NannyWorkTimeUtil.value2TimeAndWeekRes(281474976710654L);
//        for (int i=0;i<timeAndWeekResList.size();i++){
//            System.out.println(timeAndWeekResList.get(i).toString());
//        }
//        System.out.println(StringUtil.changeIntegerLenght(6655,6));
//        System.out.println((int)(Math.random()*10000));

//        String host = "https://yunyidata.market.alicloudapi.com";
//        String path = "/bankAuthenticate4";
//        String method = "POST";
//        String appcode = "a6b220c9c22549cca37ca365caa26209";
//        Map<String, String> headers = new HashMap<String, String>();
//        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
//        headers.put("Authorization", "APPCODE " + appcode);
//        //根据API的要求，定义相对应的Content-Type
//        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//        Map<String, String> querys = new HashMap<String, String>();
//        Map<String, String> bodys = new HashMap<String, String>();
//        bodys.put("ReturnBankInfo", "YES");
//        bodys.put("cardNo", "62155811111111111");
//        bodys.put("idNo", "340421199922225555");
//        bodys.put("name", "张三");
//        bodys.put("phoneNo", "13522221111");

        String roomType="室二厅一厨二卫";
        List<Integer> list =DBMoveUtil.getHouse(roomType);
        for (Integer integer : list){
            System.out.println(integer);
        }
    }

}
