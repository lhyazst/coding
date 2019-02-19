package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;
import com.zeus.exception.CommonCode;
import com.zeus.service.RecycleBinService;
import com.zeus.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Description 回收箱
 * @Author wangdi
 * @Date 1/7/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/recycleBin/page/")
public class RecycleBinController {
    @Autowired
    private RecycleBinService recycleBinService;

    /**
     *
     *
     * @methodName recycleSiteFandAll 查询出站点里面所有回收箱
     * @author wangdi
     * @param []
     * @return com.zeus.common.Response
     * @date 2019/1/3
     */
    @GetMapping("recycleBinfandall/{recycleSiteId}")
    @ResponseBody
    private QueryResponseResult recycleBinFandAll(@PathVariable("recycleSiteId") Long recycleSiteId) {

        if (EmptyUtil.isEmpty(recycleSiteId)) {
            return new QueryResponseResult(CommonCode.INVALID_PARAM,null);
        }
       QueryResponseResult response = recycleBinService.recycleBinFandAll(recycleSiteId);

        return response;
    }


}
