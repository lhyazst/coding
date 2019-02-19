package com.zeus.controller.admin;

import com.zeus.common.QueryResponseResult;
import com.zeus.service.CommentsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Description   用户评论
 * @author:wangdi
 * @date:2019/1/15
 * @ver:1.0
 */
@Controller
@RequestMapping(value = "/commentsuser/page/")
public class CommentsUserController {
    @Autowired
  private CommentsUserService commentsUserService;



/**
 *
 *
 * @methodName  AddCommentsUser  添加评论
 * @author wangdi
 * @param []
 * @return com.zeus.common.QueryResponseResult
 * @date 2019/1/15
 */
    @GetMapping("addCommentsUser/{comment}/{activityProductId}/{username}")
    @ResponseBody
 public QueryResponseResult addCommentsUser(@PathVariable("comment") String comment, @PathVariable("activityProductId") Long activityProductId,@PathVariable("username") String username){

         QueryResponseResult queryResponseResult =commentsUserService.addComments(comment,activityProductId,username);


return queryResponseResult;
 }





}
