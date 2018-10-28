import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * @author liwanping
 * @date 2018-08-23
 */
public class OtherTest {

    @Test
    public void test(){
        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("a","");
        testMap.put("b","dsad");
        System.out.println(StringUtils.isNotBlank(testMap.get("a")));

        //过滤空字段
        Iterator<Map.Entry<String,String>> iterator = testMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            if(StringUtils.isBlank(entry.getValue())){
                iterator.remove();
            }
        }
        System.out.println(testMap);
    }

    @Test
    public void test2(){
        //System.out.println(null && false);
    }
}
