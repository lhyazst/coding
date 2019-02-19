package com.zeus.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    /**
     *
     *
     * @methodName  date2String   将日期转换成字符串
     * @author wangdi
     * @param [date, patt]
     * @return java.lang.String
     * @date 2019/1/23
     */
    public static String date2String(Date date, String patt) {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }

    public static  void main(String[] args)
    {
        Calendar cal=Calendar.getInstance();
        Date date=cal.getTime();
        System.out.println(date2String(date,"今天是yyyy年MM月dd日"));
    }
    /**
     *
     *
     * @methodName   字符串转换成日期
     * @author wangdi
     * @param
     * @return
     * @date 2019/1/23
     */
    public static Date string2Date(String str, String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(str);
        return parse;
    }
    public static Date DateTiem2Date(Long date) throws ParseException {

        return new Date(date);
    }
}
