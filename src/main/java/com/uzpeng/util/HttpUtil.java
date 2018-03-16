package com.uzpeng.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author serverliu on 2018/3/7.
 */
public class HttpUtil {

    /**
     * 获取指定请求的IP地址
     * @param request http请求
     * @return 该请求的IP地址
     */
    public static String getIpAddress(HttpServletRequest request){
        if(request.getHeader("X-Real-IP") == null){
            return request.getRemoteAddr();
        } else {
            return request.getHeader("X-Real-IP");
        }
    }

}
