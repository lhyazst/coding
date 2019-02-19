package com.zeus.exception;

import lombok.ToString;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 18:33.
 * @Modified By:
 */
@ToString
public enum CommonCode implements ResultCode {
    INVALID_PARAM(false, 10003, "非法参数！"),
    SUCCESS(true, 10000, "操作成功！"),
    FAIL(false, 11111, "操作失败！"),
    UNAUTHENTICATED(false, 10001, "此操作需要登陆系统！"),
    UNAUTHORISE(false, 10002, "权限不足，无权操作！"),
    SERVER_ERROR(false, 99999, "抱歉，系统繁忙，请稍后重试！"),
    DATA_NOT_FOUND(false, 10004, "数据不存在"),
    ADD_SUCCESSFUL(true, 10008, "添加成功"),
    ADD_FAIL(false, 10007, "添加失败"),
    PHONE_FORMAT(false, 10009, "手机格式不正确"),
    SMS_FAIL(false, 10010, "发送验证码失败"),
    SMS_SUCCESS(true, 10011, "发送验证码成功"),
    INSUFFICIENT_FUND(false, 10012, "金额不足"),
    AUTH_CODE(false, 10005, "验证码不正确");

    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    private CommonCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;

    }
   /**
    * 
    * 
    * @methodName  success 
    * @author wangdi
    * @param [] 
    * @return boolean 
    * @date 2019/1/21 
    */  
    @Override
    public boolean success() {
        return success;
    }
    /**
     * 
     * 
     * @methodName  code 
     * @author wangdi
     * @param [] 
     * @return int 
     * @date 2019/1/21 
     */  
    @Override
    public int code() {
        return code;
    }
   /**
    * 
    * 
    * @methodName  message 
    * @author wangdi
    * @param [] 
    * @return java.lang.String 
    * @date 2019/1/21 
    */  
    @Override
    public String message() {
        return message;
    }


}
