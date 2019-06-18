import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liwanping
 * @date 2018-06-15
 */
public class MessTest {
    @Test
    public void gsonstr(){
        List<String> existstxtyp = new ArrayList();
        existstxtyp.add("01");
        existstxtyp.add("02");
        System.out.println(new Gson().toJson(existstxtyp));
    }

}
