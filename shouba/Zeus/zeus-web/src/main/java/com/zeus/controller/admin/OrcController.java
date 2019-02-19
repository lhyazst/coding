package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.entity.Orc;
import com.zeus.exception.CommonCode;
import com.zeus.service.OrcService;
import com.zeus.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @Description 二维码
 * @Author wangdi
 * @Date 1/7/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/orc/user/")
public class OrcController {
@Autowired
private OrcService orcService;
  /**
   *
   *
   * @methodName  orcFandOne 用户扫描二维码获取编号要求二维码状态必须为3,并且要判断是否是回收箱的二维码；
   * @author wangdi
   * @param
   * @date 2019/1/14
   */
    @GetMapping("orcfandone/{id}")
    @ResponseBody
    public QueryResponseResult orcFandOne(@PathVariable("id") Long id) {

        QueryResponseResult queryResponseResult = orcService.orcFandOne(id);

        return queryResponseResult;
    }
   /**
    *
    *
    * @methodName  addOrcUser  用户绑定回收箱并改变回收箱的数量
    * @author wangdi
    * @param [id, username]
    * @return com.zeus.common.QueryResponseResult
    * @date 2019/1/14
    */
    @GetMapping("addorcuser/{id}/{username}")
    @ResponseBody
    public QueryResponseResult addOrcUserBin(@PathVariable("id") Long id,@PathVariable("username") String username) {

        QueryResponseResult queryResponseResult = orcService.addOrcUsername(id,username);

        return queryResponseResult;
    }
    /**
     *
     *
     * @methodName addircUsernum  用户输入编号绑定回收箱
     * @author wangdi
     * @param [num, username]
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/14
     */

    @GetMapping("addorcusernum/{num}/{username}")
    @ResponseBody
   public  QueryResponseResult addircUsernum(@PathVariable("num") Long num ,@PathVariable("username") String username) {

        QueryResponseResult queryResponseResult = orcService.addOrcUsernum(num,username);

        return queryResponseResult;
    }

     /**
     *
     *
     * @methodName  addOrcUser  用户绑定普通回收袋
     * @author wangdi
     * @param [id, username]
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/14
     */
    @GetMapping("addorcuserbags/{id}/{username}")
    @ResponseBody
    public QueryResponseResult addOrcUserBags(@PathVariable("id") Long id,@PathVariable("username") String username) {

        QueryResponseResult queryResponseResult = orcService.addOrcUsernameBags(id,username);

        return queryResponseResult;
    }

    /**
     *
     *
     * @methodName  addOrcUser  用户绑定厨余回收袋
     * @author wangdi
     * @param [id, username]
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/14
     */
    @GetMapping("addOrcUserBagsWaste/{id}/{username}")
    @ResponseBody
    public QueryResponseResult addOrcUserBagsWaste(@PathVariable("id") Long id,@PathVariable("username") String username) {

        QueryResponseResult queryResponseResult = orcService.addOrcUsernameBagsWaste(id,username);

        return queryResponseResult;
    }



}
