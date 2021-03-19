package com.lwp.java.basic.http;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.Map;

public class RestTemplateUtil {

    private static final String SUCCESS = "0";

    private static final String RESULT_CODE = "bizCode";

    private static final String RESULT_MSG = "bizMsg";

    private static final String WARNING = "TSP_500";

    private static final Logger logger = LoggerFactory.getLogger(RestTemplateUtil.class);

    private final static int maxTotal = 6;

    private final static int maxPerRoute =6;

    private final static int connectTimeout = 6000;

    private final static int readTimeout = 6000;

    private static final HttpComponentsClientHttpRequestFactory clientHttpRequestFactory;

    private static class SingletonRestTemplate {
        static final RestTemplateUtil INSTANCE = new RestTemplateUtil();
    }

    private RestTemplateUtil() {

    }

    public static RestTemplateUtil getInstance() {
        return SingletonRestTemplate.INSTANCE;
    }

    static {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();// 开始设置连接池
        poolingHttpClientConnectionManager.setMaxTotal(maxTotal); // 最大连接数
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(maxPerRoute); // 同路由并发数
        httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager);
        HttpClient httpClient = httpClientBuilder.build();
        clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);// httpClient连接配置
        clientHttpRequestFactory.setConnectTimeout(connectTimeout);// 连接超时
        clientHttpRequestFactory.setReadTimeout(readTimeout);// 数据读取超时时间
    }

    /**
     * post提交对象
     */
    public Object postJson(String url, String data) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.ACCEPT_ENCODING, "gzip");
        headers.add(HttpHeaders.CONTENT_ENCODING, "UTF-8");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        HttpEntity<String> formEntity = new HttpEntity<>(data, headers);
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        String strRtnJson = restTemplate.postForObject(url, formEntity, String.class);
        return strRtnJson;
    }

    /**
     * post map
     */
    public Object postMap(String url, Map paramsMap) throws Exception {
        MultiValueMap<String, String> postData = new LinkedMultiValueMap<String, String>();
        Iterator<Map.Entry<String, String>> it = paramsMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            postData.add(entry.getKey(),entry.getValue());
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_ENCODING, "UTF-8");
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        HttpEntity<MultiValueMap<String, String>> formEntity = new HttpEntity<>(postData, headers);
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        String strRtnJson = restTemplate.postForObject(url, formEntity, String.class);
        return strRtnJson;
    }
}
