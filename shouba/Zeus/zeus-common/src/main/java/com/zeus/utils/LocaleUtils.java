package com.zeus.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author:fusheng
 * @date:2018/12/22 0022
 * @ver:1.0
 */
public class LocaleUtils {
    public static String getLocaleFormat(String  input,String locale){
        Locale locale1 = Locale.getDefault();
        if("US".equalsIgnoreCase(locale)){
            locale1 =   getUSFormat(input);
        }else {
            locale1 =   getZHFormat(input);
        }
        ResourceBundle res = null;
        String outPut = null;
        try {
            res = ResourceBundle.getBundle("message", locale1);
            outPut = res.getString(input);
            return outPut;
        } catch (Exception e) {
            return  input;
        }

    }

    public static  Locale getUSFormat(String  input){
        return  Locale.US;

    }
    public static  Locale getZHFormat(String  input){
        return  new Locale("zh", "CN");
    }
}
