package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;


import com.zeus.entity.WorkUsers;
import com.zeus.exception.CommonCode;
import com.zeus.service.BagsService;
import com.zeus.service.OrcService;
import com.zeus.service.WorkUserService;
import com.zeus.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


/**
 * @Description 扫描二维码
 * @Author wangdi
 * @Date 1/7/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/orc/manage/")
public class OrcController {

    @Autowired
    public OrcService orcService;
    @Autowired
    public BagsService bagsService;
    @Autowired
    public WorkUserService workUserService;
    /**
     * @param
     * @return com.zeus.common.Response回收员扫描二维码返回回收袋编号和用户信息要求状态必须为0,或者扫描回收箱设置回收箱状态为1，二维码状态为0
     * @methodName orcFandOne 回收员扫描二维码返回回收袋编号和用户信息,或则打开邮箱
     * @author wangdi
     * @date 2019/1/10
     */
    @GetMapping("orcfandoneq/{orcid}/{phone}")
    @ResponseBody
    public QueryResponseResult orcFandOne(@PathVariable("orcid") Long orcid,@PathVariable("phone") String phone) {

       // String username = SecurityContextHolder.getContext().getAuthentication().getName();

        if (EmptyUtil.isEmpty(orcid)) {
            new QueryResponseResult<>(CommonCode.INVALID_PARAM, null);
        }
        QueryResponseResult response = orcService.orcFandOne(orcid,phone);

        return response;
    }

    /**
     * @param
     * @return java.lang.Boolean
     * @methodName orcBagsupdateStatus   回收员回收过后回收袋和二维码的状态更改为1
     * @author wangdi
     * @date 2019/1/10
     */
    @RequestMapping("orcbagsupdatestatus/{orcid}/{bagsid}/{phone}")
    @ResponseBody
    public QueryResponseResult orcBagsupdateStatus(@PathVariable("orcid") Long orcId, @PathVariable("bagsid") Long bagsId,@PathVariable("phone") String phone) {
       // String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (EmptyUtil.isEmpty(orcId) && EmptyUtil.isEmpty(bagsId)) {
           new QueryResponseResult<>(CommonCode.INVALID_PARAM,null);
        }
        WorkUsers workUser =  workUserService.selectUsername(phone);


        Boolean b = orcService.updateStatus(orcId,workUser.getId());
        Boolean g = bagsService.bupdateStats(bagsId);

        if (!b || !g) {
            return new QueryResponseResult(CommonCode.ADD_FAIL, null);
        }
        return new QueryResponseResult(CommonCode.SUCCESS, null);

    }

    /**
     *
     *
     * @methodName  workUserOrcFandOne  仓管员扫描回收袋返回用户信息和物品所有种类
     * @author wangdi
     * @param []
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/17
     */
    @RequestMapping("workUserOrcFandOne/{orcId}")
    @ResponseBody
    public QueryResponseResult workUserOrcFandOne(@PathVariable("orcId")Long orcid){

             QueryResponseResult queryResponseResult = orcService.workUserOrcFandOne(orcid);

                 return queryResponseResult;

    }




}
