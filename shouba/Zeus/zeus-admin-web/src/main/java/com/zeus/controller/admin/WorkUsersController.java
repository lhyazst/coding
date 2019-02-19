package com.zeus.controller.admin;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;

import com.zeus.entity.WorkUsers;
import com.zeus.service.WorkUserService;
import com.zeus.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.zeus.constant.Constants.EFFECTIVE_TIME;
import static com.zeus.constant.Constants.TOKEN_ISSUER;

/**
 * @Description
 * @author:wangdi
 * @date:2019/1/13
 * @ver:1.0
 */
@Controller
@RequestMapping(value = "/workusers/page/")
public class WorkUsersController {
    private static Logger LOG= LoggerFactory.getLogger(WorkUsersController.class);

    @Autowired
    private WorkUserService usersService;

    @GetMapping("login")
    @ResponseBody
    private String login(String username,String password) {
        JSON json = new JSONObject();
        WorkUsers user=usersService.IsLogin(username,password);
        if (user != null){
            com.alibaba.fastjson.JSONObject tokenJson = new com.alibaba.fastjson.JSONObject();
            tokenJson.put("userId",user.getId());
            tokenJson.put("username",user.getUsername());
            String token =TokenUtil.createJWT(String.valueOf(user.getId()),TOKEN_ISSUER,tokenJson.toJSONString(), EFFECTIVE_TIME);
            user.setToken(token);
            ((JSONObject) json).put("msg", "登录成功");
            ((JSONObject) json).put("code", 0);
            ((JSONObject) json).put("data", user);
        }else
        {
            ((JSONObject) json).put("msg", "用户名或密码错误,请重新输入");
            ((JSONObject) json).put("code", 10002);
        }
        return json.toString();
    }

    /**
     * @param [page, size]
     * @return com.zeus.common.QueryResponseResult
     * @methodName selectWorkusersFanALL 查询出所有的工作人员
     * @author wangdi
     * @date 2019/1/24
     */
    @GetMapping("workusersFanAll/{page}/{size}")
    @ResponseBody
    public Map selectWorkusersFanALL(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {

        Map queryResponseResult = usersService.selectFanAll(page, size);
        return queryResponseResult;

    }

    /**
     * @param [id]
     * @return java.util.Map
     * @methodName deleteWorkUsersFandOne 跟据用户id删除该用户
     * @author wangdi
     * @date 2019/1/28
     */
    @GetMapping("deleteid/{id}")
    @ResponseBody
    public Map deleteWorkUsersFandOne(@PathVariable("id") Long id) {

        Map map = usersService.deleteWorkUsersFandOne(id);
        return map;
    }

    /**
     * @param [workUsers]
     * @return java.util.Map
     * @methodName addWorkUser
     * @author wangdi
     * @date 2019/1/28
     */
    @RequestMapping(value = "addusers", method = RequestMethod.POST)
    @ResponseBody
    public Map addWorkUser(@RequestBody WorkUsers workUsers) {

        Map map = usersService.addWorkUser(workUsers);
        return map;
    }

    /**
     * @param [id]
     * @return java.util.Map
     * @methodName fandOne 跟据id查询对象
     * @author wangdi
     * @date 2019/1/29
     */
    @GetMapping("fandOne/{id}")
    @ResponseBody
    public Map fandOne(@PathVariable("id") Long id) {

        Map map = usersService.fandOne(id);
        return map;
    }

    @RequestMapping(value = "updateusers", method = RequestMethod.POST)
    @ResponseBody
    public Map updateUsers(@RequestBody WorkUsers workUsers){

        Map map = usersService.updateUsers(workUsers);
        return map;
    }



}
