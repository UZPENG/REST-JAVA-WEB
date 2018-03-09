package com.uzpeng.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author serverliu on 2018/3/7.
 */
public class HttpUtil {
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public static final String DELETE = "DELETE";
    public static final String PATCH = "PATCH";

    public static boolean checkMethod(HttpServletRequest request, String method){
        return request.getMethod().equals(method);
    }

    public static String getIpAddress(HttpServletRequest request){
        if(request.getHeader("X-Real-IP") == null){
            return request.getRemoteAddr();
        } else {
            return request.getHeader("X-Real-IP");
        }
    }

}
