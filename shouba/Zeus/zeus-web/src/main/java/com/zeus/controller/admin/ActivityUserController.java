package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;
import com.zeus.entity.ActivityUser;
import com.zeus.exception.CommonCode;
import com.zeus.service.ActivityUserService;
import com.zeus.service.ArticleService;
import com.zeus.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @Description 用户参与活动
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/activity/page/")
public class ActivityUserController {
    @Autowired
    private ActivityUserService activityUserService;
   /**
    *
    *
    * @methodName  addarticleService 用户参与活动
    * @author wangdi
    * @param [username]
    * @return com.zeus.common.QueryResponseResult
    * @date 2019/1/16
    */
    @GetMapping("activity/{username}/{activityProductid}")
    @ResponseBody
    public QueryResponseResult addArticleService(@PathVariable("username")String username, @PathVariable("activityProductid")Long activityProductid){
        if (EmptyUtil.isEmpty(username) || EmptyUtil.isEmpty(activityProductid)) {
            return new QueryResponseResult(CommonCode.INVALID_PARAM,null);
        }
        QueryResponseResult queryResponseResult = activityUserService. addArticleService(username,activityProductid);
         return queryResponseResult;

    }





}
