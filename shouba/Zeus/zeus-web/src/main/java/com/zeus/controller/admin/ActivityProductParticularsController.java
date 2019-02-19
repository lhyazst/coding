package com.zeus.controller.admin;
import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.exception.CommonCode;
import com.zeus.service.ActivityProductParticularsService;
import com.zeus.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Description 活动详情
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/ActivityProductParticulars/page/")
public class ActivityProductParticularsController {
    @Autowired
    private ActivityProductParticularsService activityProductParticularsService;

    /**
     *
     *
     * @methodName  activityProductParticularsFandOne 根据活动id查询出用户评论和参加活动用户和活动详情
     * @author wangdi
     * @param
     * @return com.zeus.common.Response
     * @date 2019/1/3
     */
    @GetMapping("activityProductParticulars/{activityProductId}")
    @ResponseBody
    private QueryResponseResult activityProductParticularsFandOne( @PathVariable("activityProductId") Long activityProductId) {

        if ( EmptyUtil.isEmpty(activityProductId)) {
           new QueryResponseResult(CommonCode.INVALID_PARAM,null);
        }

       QueryResponseResult response = activityProductParticularsService.activityProductParticularsServicefandOne(activityProductId);

        return response;
    }


}
