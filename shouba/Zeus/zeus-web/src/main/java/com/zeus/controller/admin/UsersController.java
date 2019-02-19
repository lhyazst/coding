package com.zeus.controller.admin;

import com.zeus.common.QueryResponseResult;
import com.zeus.entity.Users;
import com.zeus.exception.CommonCode;
import com.zeus.service.UsersService;
import com.zeus.utils.PhoneFormatCheckUtils;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @author:wangdi
 * @date:2019/1/13
 * @ver:1.0
 */
@Controller
@RequestMapping(value = "/users/page/")
public class UsersController {


     @Autowired
    private UsersService usersService;
    /**
     * 增加
     * @param user 校验验证码
     * @return
     */
    @PostMapping("/add/{smscode}")
    @ResponseBody
    public QueryResponseResult add(@RequestBody Users user,@PathVariable("smscode") String smscode){

        //校验验证码是否正确
        boolean checkSmsCode = usersService.checkSmsCode(user.getTelephone(), smscode);
        if(!checkSmsCode){
            return new QueryResponseResult(CommonCode.AUTH_CODE,null);
        }


        try {

            return new QueryResponseResult(CommonCode.ADD_SUCCESSFUL,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new QueryResponseResult(CommonCode.ADD_FAIL,null);
        }
    }
    /**
     *
     *
     * @methodName  sendCode 发送验证码
     * @author wangdi
     * @param [phone]
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/22
     */
    @RequestMapping("sendCode/{phone}")
    @ResponseBody
    public QueryResponseResult sendCode(@PathVariable("phone") String phone){

        if(!PhoneFormatCheckUtils.isPhoneLegal(phone)){
            return new QueryResponseResult(CommonCode.PHONE_FORMAT,null);
        }

        try {
            usersService.createSmsCode(phone);
            return new QueryResponseResult(CommonCode.SMS_SUCCESS,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new QueryResponseResult(CommonCode.SMS_FAIL,null);
        }
    }
  /**
   *
   *
   * @methodName  addUsers  添加用户
   * @author wangdi
   * @param [users]
   * @return com.zeus.common.QueryResponseResult
   * @date 2019/1/16
   */
    @PostMapping("addUsers/{phone}")
    @ResponseBody
    public QueryResponseResult addUsers(@RequestBody Users users,@PathVariable("phone")String phone){
      QueryResponseResult queryResponseResult =   usersService.add(users ,phone);
        return queryResponseResult;
    }

    /**
     *
     *
     * @methodName  userfandOne 查询用户
     * @author wangdi
     * @param [username]
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/27
     */
    @RequestMapping("userfandOne/{username}")
    @ResponseBody
    public  QueryResponseResult userfandOne(@PathVariable("username") String username){


        QueryResponseResult queryResponseResult = usersService.userfandOne(username);
        return queryResponseResult;
    }


}
