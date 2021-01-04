import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Slf4j
public class JacksonTool {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static PropertyNamingStrategy snakeCase = new PropertyNamingStrategy.SnakeCaseStrategy();

    static {
        //序列化的时候忽略空值
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //按照首字母排序
        objectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
        //反序列化时忽略不需要的字段
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        /**
         * 设置全局JSON属性格式 ，针对实体类中属性是以驼峰方式命名的规则适用
         * 如果属性命名时非驼峰模式，需要实现自定义的策略规则实现方式 SNAKE_CASE 小写下划线分割
         * UPPER_CAMEL_CASE 首字母大写驼峰模式 LOWER_CAMEL_CASE
         * 首字母小写驼峰模式(默认实体中定义的属性名称) LOWER_CASE 全小写模式 KEBAB_CASE 小写中画线模式
         */
        objectMapper.setPropertyNamingStrategy(snakeCase);
/*
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addKeySerializer(String.class, new SnakeCaseKeySerializer());
        simpleModule.addDeserializer(Map.class, new SnakeCaseDeserializer());
        //simpleModule.addSerializer(Number.class, new DecimalScaleSerializer());
        objectMapper.registerModule(simpleModule);*/

        /**
         * 设置全局时间格式变量为
         * 如果需要单独指定时间格式，那么需要在对象的属性上加@JsonFormat(pattern="yyyy-MM-dd")注解来指定需要的日期时间格式
        DateFormat dateFormat = new SimpleDateFormat(DateTimeFormat.DATE_PATTERN_LONG);
        objectMapper.setDateFormat(dateFormat);*/
    }

    private JacksonTool() {
    }

    /**
     * 获得全局ObjectMapper对象，默认配置的下划线策略
     *
     * @return ObjectMapper
     */
    public static ObjectMapper getSnakeCaseObjectMapper() {
        return objectMapper;
    }

    /**
     * 将对象转换为json
     *
     * @param object 待转换对象
     * @return String
     */
    public static String parseToJsonString(Object object) {
        Assert.notNull(object, "转换为JSON字符串的对象不能为空");
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将对象转换为JSON后读取为JsonNode
     *
     * @param object 待转换对象
     * @return JsonNode
     */
    public static JsonNode parseToJsonNode(Object object) {
        Assert.notNull(object, "转换为JsonNode对象的对象不能为空");
        try {
            String jsonString = objectMapper.writeValueAsString(object);
            return objectMapper.readTree(jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将JSON字符串转化为JsonNode
     *
     * @param jsonStr JSON字符串
     * @return JsonNode
     */
    public static JsonNode parseToJsonNode(String jsonStr) {
        try {
            return objectMapper.readTree(jsonStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据具体Class将JSON字符串转换为指定的对象
     *
     * @param json  JSON字符串
     * @param clazz Class对象
     * @return T
     */
    public static <T> T parseToObject(String json, Class<T> clazz) {
                Assert.notNull(clazz, "指定的Class不能为空");
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将给定的JSON字符串转换为对象
     *
     * @param json JSON字符串
     * @param type
     * @return T
     */
    public static <T> T parseToObject(String json, JavaType type) {
                try {
            return objectMapper.readValue(json, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将给定的JSON字符串转为对象list
     *
     * @param json
     * @param valueTypeRef
     * @param <T>
     * @return
     */
    public static <T> T parseToObject(String json, TypeReference<T> valueTypeRef) {
                try {
            return objectMapper.readValue(json, valueTypeRef);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过key从json字符串中获取其对应的value
     *
     * @param keyName    key名称
     * @param jsonString json字符串
     * @return String
     */
    public static String getValueFromJsonByKey(String keyName, String jsonString) {
        return getValueFromJsonByKey(keyName, jsonString, false);
    }

    public static <T> T parseToObject(JsonNode jsNode, Class<T> clazz) {
        try {
            return objectMapper.treeToValue(jsNode, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 判断某一个json字符串有没有对应的key
     */
    public static boolean isContainKey(String keyName, String jsonString) {
                JsonNode rootNode;
        try {
            rootNode = objectMapper.readTree(jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rootNode.has(keyName);
    }

    /**
     * 通过key从json字符串中获取其对应的value
     *
     * @param keyName              key名称
     * @param jsonString           json字符串
     * @param ifReadFromNestingObj 如果不存在是否在内嵌对象里面查找
     * @return String
     */
    public static String getValueFromJsonByKey(String keyName, String jsonString, boolean ifReadFromNestingObj) {
                JsonNode rootNode;
        try {
            rootNode = objectMapper.readTree(jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JsonNode nameNode = rootNode.get(keyName);
        String value = null;
        if (nameNode == null && ifReadFromNestingObj) {
            Iterator<JsonNode> it = rootNode.elements();
            while (it.hasNext()) {
                JsonNode node = it.next();
                String nodeValue = getStringValueFromNode(node);
                if (nodeValue != null && nodeValue.startsWith("{")) {
                    if (nodeValue.contains(keyName)) {
                        value = getStringValueFromNode(node.get(keyName));
                        break;
                    } else {
                        value = getValueFromJsonByKey(keyName, nodeValue, ifReadFromNestingObj);
                    }
                }
            }
        } else {
            value = getStringValueFromNode(nameNode);
        }

        return value;
    }

    /**
     * 获取JsonNode的值，由于JsonNode.asText()只能获取值，不能获取对象或者数组，所以如果asText()为空，则用jsonNode.toString()方法
     *
     * @param node
     * @return
     */
    public static String getStringValueFromNode(JsonNode node) {
        if (node == null) {
            return null;
        }
        String result = null;
        if (StringUtils.isBlank(node.asText())) {
            result = node.toString();
        } else {
            result = node.asText();
        }
        // 此处判断是由于jmespath框架会将空字符串解析成双引号缘故
        if (StringUtils.equals("\"\"", result)) {
            result = null;
        }
        // 此处判断是由于jmespath框架会将null解析成null字符串
        if (StringUtils.equals("null", result)) {
            result = null;
        }
        return result;
    }

    /**
     * 将对象转换为json
     *
     * @param object       待转换对象
     * @param objectMapper 自己创建的objectMapper对象 适用于不符合全局配置的情况
     * @return String
     */
    public static String parseToJsonString(Object object, ObjectMapper objectMapper) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将对象转换为JSON后读取为JsonNode
     *
     * @param object       待转换对象
     * @param objectMapper 自己创建的objectMapper对象
     * @return JsonNode
     */
    public static JsonNode parseToJsonNode(Object object, ObjectMapper objectMapper) {
        try {
            String jsonString = objectMapper.writeValueAsString(object);
            return objectMapper.readTree(jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将JSON字符串转化为JsonNode
     *
     * @param jsonStr      JSON字符串
     * @param objectMapper 自己创建的objectMapper对象 适用于不符合全局配置的情况
     * @return JsonNode
     */
    public static JsonNode parseToJsonNode(String jsonStr, ObjectMapper objectMapper) {
        try {
            return objectMapper.readTree(jsonStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据具体Class将JSON字符串转换为指定的对象
     *
     * @param json         JSON字符串
     * @param clazz        Class对象
     * @param objectMapper 自己创建的objectMapper对象 适用于不符合全局配置的情况
     * @return T
     */
    public static <T> T parseToObject(String json, Class<T> clazz, ObjectMapper objectMapper) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将给定的JSON字符串转换为对象
     *
     * @param json         JSON字符串
     * @param type
     * @param objectMapper 自己创建的objectMapper对象 适用于不符合全局配置的情况
     * @return T
     */
    public static <T> T parseToObject(String json, JavaType type, ObjectMapper objectMapper) {
        try {
            return objectMapper.readValue(json, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将给定的JSON字符串转为对象list
     *
     * @param json
     * @param valueTypeRef
     * @param <T>
     * @param objectMapper 自己创建的objectMapper对象 适用于不符合全局配置的情况
     * @return
     */
    public static <T> T parseToObject(String json, TypeReference<T> valueTypeRef, ObjectMapper objectMapper) {
        try {
            return objectMapper.readValue(json, valueTypeRef);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过key从json字符串中获取其对应的value
     *
     * @param keyName      key名称
     * @param jsonString   json字符串
     * @param objectMapper 自己创建的objectMapper对象 适用于不符合全局配置的情况
     * @return String
     */
    public static String getValueFromJsonByKey(String keyName, String jsonString, ObjectMapper objectMapper) {
        return getValueFromJsonByKey(keyName, jsonString, false, objectMapper);
    }

    /**
     * 通过key从json字符串中获取其对应的value
     *
     * @param keyName              key名称
     * @param jsonString           json字符串
     * @param ifReadFromNestingObj 如果不存在是否在内嵌对象里面查找
     * @param objectMapper         自己创建的objectMapper对象
     * @return String
     */
    public static String getValueFromJsonByKey(String keyName, String jsonString, boolean ifReadFromNestingObj,
                                               ObjectMapper objectMapper) {
        JsonNode rootNode;
        try {
            rootNode = objectMapper.readTree(jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JsonNode nameNode = rootNode.get(keyName);
        String value = null;
        if (nameNode == null && ifReadFromNestingObj) {
            Iterator<JsonNode> it = rootNode.elements();
            while (it.hasNext()) {
                JsonNode node = it.next();
                String nodeValue = getStringValueFromNode(node);
                if (nodeValue != null && nodeValue.startsWith("{")) {
                    if (nodeValue.contains(keyName)) {
                        value = getStringValueFromNode(node.get(keyName));
                        break;
                    } else {
                        value = getValueFromJsonByKey(keyName, nodeValue, ifReadFromNestingObj, objectMapper);
                    }
                }
            }
        } else {
            value = getStringValueFromNode(nameNode);
        }
        return value;
    }

    /**
     * 输入Json串，输出textual node对应的字段放入map
     *
     * @param json         输入json字符串
     * @param objectMapper 自定义ObjectMapper
     * @return
     */
    public static Map<String, String> jsonStringToValue(String json, ObjectMapper objectMapper) {
        Map<String, String> resMap = new HashMap<>();
        JsonNode rootNode;
        try {
            rootNode = parseToJsonNode(json, objectMapper);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (rootNode == null) {
            return resMap;
        }
        Iterator<Map.Entry<String, JsonNode>> it = rootNode.fields();
        if (it == null) {
            return resMap;
        }
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> node = it.next();
            //如果
            if (node.getValue().isTextual()) {
                resMap.put(node.getKey(), node.getValue().asText());
            }
        }
        return resMap;
    }

}
