package com.zeus.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @Description  非空判断工具类
 * @author:wangdi
 * @date:2019/1/4
 * @ver:1.0
 */
public class EmptyUtil {


    //判断非空
    public static boolean isEmpty(Object obj) {
        //判断是否为null
        if (obj == null) {
            return true;
        }
        //判断字符是否为空
        if (obj instanceof CharSequence) {
            if (((CharSequence) obj).length() == 0) {
                return true;
            }
        }
        //map判断
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        // collection判断
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        //数组判断
        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++) {
                if (object[i] != null) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }

    //多值的判断
    public static boolean isEmptys(Object... obj) {
        for (int i = 0; i < obj.length; i++) {
            if (EmptyUtil.isEmpty(obj[i])) {
                return true;
            }
        }
        return false;
    }
}















