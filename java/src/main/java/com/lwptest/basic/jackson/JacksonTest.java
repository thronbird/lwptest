package com.lwptest.basic.jackson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.io.IOException;
import java.util.List;

/**
 * @author liwanping
 * @date 2018-11-19
 */
public class JacksonTest {
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "[{\"order_id\":\"rjowejhrwekl\",\"trx_amount\":\"11\",\"payee_acc_no\":\"\",\"bk_acc_type\":\"01\",\"bk_name\":\"中国建设银行\",\"bk_card_type\":\"个人\",\"bk_card_no\":\"6227005372352331064\",\"bk_card_name\":\"王伟\",\"branch_bk_name\":\"支行\",\"branch_bk_no\":\"联行号\",\"province\":\"省\",\"city\":\"地市\"}]";
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        List<O> o = mapper.readValue(json, new TypeReference<List<O>>() { });
        System.out.println(o);
    }
}
