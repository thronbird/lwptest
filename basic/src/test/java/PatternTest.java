import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liwanping
 * @date 2018-05-31
 */
public class PatternTest {
    @Test
    public void testPattern() throws UnsupportedEncodingException {
        String riskItem="{\"deliveryaddrpro\": \"浙江\",\"deliveryaddrfull\": \"浙江杭州萧山飞虹路111号\",\"deliveryaddrcity\": \"杭州\",\"deliveryaddrdis\": \"萧山\",\"deliveryaddrstr\": \"飞虹路111号\",\"deliveryname\": \"方荣俊\",\"deliveryphone\": \"18621196627\",\"logisticsnum\": \"CNS111111111111\",\"logisticscompany\": \"申通\"}";
        String risk_item = new String(riskItem.getBytes("ISO8859-1"), "utf-8");
        Pattern pattern = Pattern.compile("\\\\");
        Matcher m = pattern.matcher(risk_item);
        risk_item = m.replaceAll("");
        System.out.println(risk_item);
    }
}
