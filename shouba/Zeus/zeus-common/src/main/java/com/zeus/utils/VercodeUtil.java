package com.zeus.utils;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 验证码工具类
 * @Author 元稹
 * @Date 18/12/2018 16:33
 * @Version V1.0
 */
public class VercodeUtil {

    /**
     * @Description 检验登录、注册、忘记密码时的验证码是否正确
     * @Author 元稹
     * @Date 18/12/2018 16:39
     * @Param [request]
     * @Return boolean
     */
    public static boolean checkVercode(HttpServletRequest request) {
        String vercodeExpected = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
        String vercodeActual = HttpServletRequestUtil.getString(request, "vercode");
        if (vercodeActual == null || !vercodeActual.equalsIgnoreCase(vercodeExpected)) {
            return false;
        }
        return true;
    }

}
