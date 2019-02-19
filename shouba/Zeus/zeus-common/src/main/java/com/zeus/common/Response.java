package com.zeus.common;

import com.zeus.constant.Constants;
import lombok.Data;

/**
 * @Description 返回前端的统一类
 * @Author 元稹
 * @Date 18/12/2018 17:47
 * @Version V1.0
 */
@Data
public class Response<T> {

    /**
     * 返回码
     */

    private int code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public Response() {
    }


    /**
     * @Description 成功构造器
     * @Author 元稹
     * @Date 18/12/2018 18:23
     * @Param [success, msg, data]
     * @Return
     */
    public Response(String msg, T data) {
        this.code = Constants.SUCCESS_CODE;
        this.msg = msg;
        this.data = data;
    }

    /**
     * @Description 失败构造器
     * @Author 元稹
     * @Date 18/12/2018 18:23
     * @Param [success, code, msg]
     * @Return
     */
    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

}
