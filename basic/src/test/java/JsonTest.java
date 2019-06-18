import com.google.gson.GsonBuilder;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class JsonTest {
    public static void main (String[] args ) throws UnsupportedEncodingException {
       Map<String,String> msgMap= new HashMap();
       msgMap.put("remark",null);
       msgMap.put("xx","yy");
      String msg1= Base64.encodeBase64String(new GsonBuilder().serializeNulls().create().toJson(msgMap).getBytes("UTF-8"));
      String msg2 = Base64.encodeBase64String(new GsonBuilder().serializeNulls().create().toJson(msgMap).getBytes("UTF-8"));
        System.out.println(msg1);
        System.out.println(msg2);
        Map<String, Object> bb= (Map<String, Object>) JSONObject.fromObject("{\"remark\":null,\"xx\":\"yy\"}");
        String send = Base64.encodeBase64String(new GsonBuilder().serializeNulls().create().toJson(bb).getBytes("UTF-8"));
        System.out.println(send);
        //   Map<String, Object> map = new Gson().fromJson("{\"remark\":null,\"xx\":\"yy\"}", Map.class);
        //        String send = Base64.encodeBase64String(new GsonBuilder().serializeNulls().create().toJson(map).getBytes("UTF-8"));
        //        System.out.println(send);//eyJyZW1hcmsiOm51bGwsInh4IjoieXkifQ==
        //eyJyZW1hcmsiOnt9LCJ4eCI6Inl5In0=
        String base64String = Base64.encodeBase64String("{\"remark\":null,\"xx\":\"yy\"}".getBytes("UTF-8"));
        System.out.println(base64String);
    }
}
