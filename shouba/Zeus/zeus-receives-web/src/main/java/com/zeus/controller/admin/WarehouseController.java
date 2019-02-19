package com.zeus.controller.admin;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.zeus.common.QueryResponseResult;
import com.zeus.constant.Constants;
import com.zeus.entity.Role;
import com.zeus.entity.Users;
import com.zeus.exception.CommonCode;
import com.zeus.service.WarehouseService;
import com.zeus.service.WorkUserService;
import com.zeus.utils.DateUtils;
import com.zeus.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @Description 仓库
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/warehouse/page/")
public class WarehouseController {
@Autowired
 private WarehouseService warehouseService;
    @Autowired
    private WorkUserService workUserService;

/**
 *
 *
 * @methodName  warehouseUserFanAll 查询出该仓库员所有的仓库
 * @author wangdi
 * @param [id]
 * @return com.zeus.common.QueryResponseResult
 * @date 2019/1/18
 */
    @RequestMapping("warehouseFanAll/{phone}")
    @ResponseBody
    public QueryResponseResult warehouseUserFanAll(@PathVariable("phone")String phone) {


       // String username = SecurityContextHolder.getContext().getAuthentication().getName();
              QueryResponseResult queryResponseResult = warehouseService.warehouseUserFanAll(phone);
   return queryResponseResult;
    }



  /**
   *
   *
   * @methodName  warehousebagsFanAll  查询出仓库下的所有回收袋
   * @author wangdi
   * @param [date, id]
   * @return com.zeus.common.QueryResponseResult
   * @date 2019/1/18
   */
    @RequestMapping("warehousebagsFanAll/{date}/{id}")
    @ResponseBody
   public QueryResponseResult warehousebagsFanAll(@PathVariable("date") String date,@PathVariable("id")Long id){
        if (EmptyUtil.isEmpty(id)) {
            return new QueryResponseResult(CommonCode.INVALID_PARAM,null);
        }
           if(date == null || date.length() <1 || Constants.NULL_STRING.equals(date) || "".equals(date)){
                 date= DateUtils.date2String(new Date(),"yyyy-MM-dd");

           }
         QueryResponseResult queryResponseResult = warehouseService.warehousebagsFanAll(date,id);
           return queryResponseResult;


   }
   /**
    *
    *
    * @methodName  warehousefanOne 跟据id查询出仓库并返回他的物品种类
    * @author wangdi
    * @param [id]
    * @return com.zeus.common.QueryResponseResult
    * @date 2019/1/19
    */
    @RequestMapping("warehouseFandone/{id}")
    @ResponseBody
   public QueryResponseResult warehousefanOne(@PathVariable("id")Long id) {

        if (EmptyUtil.isEmpty(id)) {
            return new QueryResponseResult(CommonCode.INVALID_PARAM, null);
        }
            QueryResponseResult queryResponseResult=   warehouseService.warehousefanOne(id);

        return queryResponseResult;


    }

    @GetMapping("login")
    @ResponseBody
    private String login(String username,String password) {
        Map map=new HashMap();
        JSONObject json= JSONUtil.createObj();
        Users users=workUserService.Login(username,password);
        if (users != null){
            Role role=workUserService.LoginOfRole(users.getId());
            map.put("users",users);
            map.put("rolename",role.getRolename());
            json.put("msg","登录成功");
            json.put("code",0);
            json.put("data",map);
        }else
        {
            json.put("msg","账号密码错误");
            json.put("code","fail");
        }
        return json.toString();
    }



}
