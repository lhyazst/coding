package com.zeus.controller.admin;

import com.zeus.common.QueryResponseResult;
import com.zeus.entity.Users;
import com.zeus.entity.UsersLog;
import com.zeus.exception.CommonCode;
import com.zeus.service.UsersLogService;
import com.zeus.service.UsersService;
import com.zeus.utils.EmptyUtil;
import com.zeus.utils.PhoneFormatCheckUtils;
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
@RequestMapping(value = "/userslog/page/")
public class UsersLogController {
    @Autowired
    private UsersLogService usersLogService;

    /**
     *
     *
     * @methodName  userslogFandAll 用户消息中心
     * @author wangdi
     * @param [username]
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/16
     */
    @GetMapping("userslogFandAll/{username}")
    @ResponseBody
    public QueryResponseResult userslogFandAll(@PathVariable("username") String username) {

        if (EmptyUtil.isEmpty(username)) {
            new QueryResponseResult(CommonCode.INVALID_PARAM, null);
        }

        QueryResponseResult queryResponseResult = usersLogService.userLogFanAll(username);


        return queryResponseResult;
    }

}
