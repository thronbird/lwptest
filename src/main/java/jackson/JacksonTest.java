package jackson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liwanping
 * @date 2018-11-19
 */
public class JacksonTest {
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "[{\"user_name\":\"bflee\",\"id_number\":\"123456\"},{\"user_name\":\"balee\",\"id_number\":\"123456\"}]";
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        List<O> o = mapper.readValue(json, new TypeReference<List<O>>() { });
        System.out.println(o);
    }
}
