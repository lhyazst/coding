package com.zeus.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description HttpServletRequest请求处理工具类
 * @Author 元稹
 * @Date 18/12/2018 16:34
 * @Version V1.0
 */
public class HttpServletRequestUtil {

    /**
     * @Description 获取HttpServletRequest里面的int值
     * @Author 元稹
     * @Date 18/12/2018 16:35
     * @Param [httpServletRequest, key]
     * @Return int
     */
    public static int getInt(HttpServletRequest httpServletRequest, String key) {
        try {
            return Integer.decode(httpServletRequest.getParameter(key));
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * @Description 获取HttpServletRequest里面的long值
     * @Author 元稹
     * @Date 18/12/2018 16:35
     * @Param [httpServletRequest, key]
     * @Return long
     */
    public static long getLong(HttpServletRequest httpServletRequest, String key) {
        try {
            return Long.valueOf(httpServletRequest.getParameter(key));
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * @Description 获取HttpServletRequest里面的double值
     * @Author 元稹
     * @Date 18/12/2018 16:35
     * @Param [httpServletRequest, key]
     * @Return double
     */
    public static Double getDouble(HttpServletRequest httpServletRequest, String key) {
        try {
            return Double.valueOf(httpServletRequest.getParameter(key));
        } catch (Exception e) {
            return -1d;
        }
    }

    /**
     * @Description 获取HttpServletRequest里面的Boolean值
     * @Author 元稹
     * @Date 18/12/2018 16:35
     * @Param [httpServletRequest, key]
     * @Return Boolean
     */
    public static Boolean getBoolean(HttpServletRequest httpServletRequest, String key) {
        try {
            return Boolean.valueOf(httpServletRequest.getParameter(key));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @Description 获取HttpServletRequest里面的String值
     * @Author 元稹
     * @Date 18/12/2018 16:35
     * @Param [httpServletRequest, key]
     * @Return String
     */
    public static String getString(HttpServletRequest httpServletRequest, String key) {
        try {
            String result = httpServletRequest.getParameter(key);
            if (result != null) {
                result = result.trim();
            }
            if ("".equals(result)) {
                result = null;
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

}
