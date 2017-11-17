import com.summ.utils.StringUtil;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jygj_7500 on 17/11/17.
 */
public class DocumentTest {

    public static void main(String[] args) {
        Document document = new Document();
        Map map = new HashMap();
        String mapString = "{'id':1,'name':'summ'}";
        map.put("id",1);
        map.put("name","summ");
        document.putAll(map);
        System.out.println(document);
    }
}
