package com.whut.basiccentre.frame.utils;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.*;

/**
 * @author kco1989
 * @email kco1989@qq.com
 * @date 2019-05-13 10:23
 */
@Slf4j
@Component
public class WebUtils {



    /**
     * 获取请求body中的参数信息
     */
    public static Map<String, String> getReqBodyInfo(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();
        try (
                BufferedReader reader = request.getReader()
        ) {
            if (null != reader) {
                String str = "";
                StringBuilder wholeStr = new StringBuilder();
                while ((str = reader.readLine()) != null) {
                    //逐行读取body体里面的内容；
                    wholeStr.append(str);
                }
                if (StringUtils.isNotBlank(wholeStr.toString())) {
                    JSONObject paramJson = JSONUtil.parseObj(wholeStr.toString());
                    if (null != paramJson) {
                        params = JSONUtil.toBean(paramJson, Map.class);
                    }
                }
            }
        } catch (Exception e) {
            log.error("获取请求{}body信息异常{}", request, e);
        }
        return params;
    }


    /**
     * 按参数名首字母ascii升序，组装QueryString格式的字符串,空值不参与
     *
     * @param is      空参数是否参与
     * @param params  参数map
     * @param outKeys 不参与签名参数
     * @return String
     */
    public static String buildSignSrc(boolean is, Map params, String... outKeys) {
        //不参与签名参数
        Map<String, String> outKeyMap = new HashMap<>();
        if (null != outKeys && outKeys.length > 0) {
            for (String key : outKeys) {
                outKeyMap.put(key, key);
            }
        }

        TreeMap<String, String> tempMap = new TreeMap<>();
        for (Object key1 : params.keySet()) {
            String key = (String) key1;
            //不参与签名
            if (outKeyMap.get(key) != null) {
                continue;
            }
            // 空参数不参与签名的参数
            Object value = params.get(key);
            String valueStr = StringUtils.filterNull(value);
            if (!is && StringUtils.isBlank(valueStr)) {
                continue;
            }
            tempMap.put(key, valueStr);
        }

        StringBuilder buf = new StringBuilder();
        for (String key : tempMap.keySet()) {
            buf.append(key).append("=").append(tempMap.get(key)).append("&");
        }
        String src = "";
        if (!StringUtils.isBlank(buf.toString())) {
            src = buf.substring(0, buf.length() - 1);
        }
        return src;
    }


    /**
     * 获取请求的真实ip地址
     */
    public static String getRealIp(HttpServletRequest request) {
        try {
            String xforwardedFor = request.getHeader("x-forwarded-for");
            String xRealIp = request.getHeader("X-Real-IP");
            log.info("请求头数据: key = x-forwarded-for, value = {}", xforwardedFor);
            log.info("请求头数据: key = X-Real-IP, value = {}", xRealIp);
            if (StringUtils.isNotBlank(xforwardedFor)) {
                return xforwardedFor.split(",")[0];
            }
            if (StringUtils.isNotBlank(xRealIp)) {
                return xRealIp;
            }
            return request.getRemoteAddr();
        } catch (Exception e) {
            log.error("getRemoteAddr ==> " + e);
            return "";
        }
    }




    /**
     * 通过request获取登陆token
     */
    public static String getLoginToken(HttpServletRequest request) {
        // 1. 通过请求参数获取loginToken
        String loginToken = request.getParameter(Constants.LOGIN_TOKEN);
        if (StringUtils.isNotBlank(loginToken)) {
            return loginToken;
        }
        // 2. 通过请求头获取loginToken
        loginToken = request.getHeader(Constants.LOGIN_TOKEN);
        if (StringUtils.isNotBlank(loginToken)) {
            return loginToken;
        }

        // 4. 通过cookie获取loginToken
        Cookie[] cookies = request.getCookies();
        if (ArrayUtils.isEmpty(cookies)) {
            return null;
        }
        return Arrays.stream(cookies)
                .filter(cookie -> StringUtils.equals(cookie.getName(), Constants.LOGIN_TOKEN))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);
    }


    /**
     * 获取当前线程里面的request对象
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    /**
     * 获取当前线程里面的response对象
     *
     * @return
     */
    public static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
    }


}
