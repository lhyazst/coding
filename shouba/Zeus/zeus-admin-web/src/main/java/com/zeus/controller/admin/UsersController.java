package com.zeus.controller.admin;

import com.zeus.common.QueryResponseResult;
import com.zeus.entity.Users;
import com.zeus.exception.CommonCode;
import com.zeus.service.UsersService;
import com.zeus.utils.PhoneFormatCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    *
    *
    * @methodName  selectFanAll 查询出所有的用户
    * @author wangdi
    * @param []
    * @return com.zeus.common.QueryResponseResult
    * @date 2019/1/23
    */
     @GetMapping("userFanAll/{page}/{size}")
     @ResponseBody
     public Map selectFanAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){

       Map queryResponseResult=  usersService.selectFanAll(page,size);

       return queryResponseResult;
     }

    /**
     *
     *
     * @methodName  deleteUserId 删除用户
     * @author xiaoxuanfeng
     * @param []
     * @return map
     * @date 2019/2/16
     */
    @GetMapping("deleteUserId/{id}")
    @ResponseBody
     public Map deleteUserId(@PathVariable("id") Long id){

         Map map = usersService.deleteUserId(id);
         return map;
     }

    /**
     *
     *
     * @methodName  fandOne 查询用户
     * @author xiaoxuanfeng
     * @param []
     * @return map
     * @date 2019/2/16
     */
    @GetMapping("fandOne/{id}")
    @ResponseBody
     public Map fandOne(@PathVariable("id") Long id){

       Map map =  usersService.fandOne(id);
         return map;
     }

/**
 *
 *
 * @methodName  UpdataOne 查询用户
 * @author xiaoxuanfeng
 * @param []
 * @return map
 * @date 2019/2/16
 */

@GetMapping("updateone/{users}")
@ResponseBody
public Map updateone(@PathVariable("users") Users users){
    Map map =  usersService.updateByPrimaryKeySelective(users);
    return map;
}

}
