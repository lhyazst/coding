package com.zeus.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 管理员页面获取控制器
 * @Author 元稹
 * @Date 17/12/2018 20:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/admin/page/")
public class AdminController {

    /**
     * 用户相关操作
     */
    @GetMapping("login")
    private String login() {
        return "user/login";
    }
    @GetMapping("forget")
    private String forget() {
        return "user/forget";
    }
    @GetMapping("info")
    private String info() {
        return "user/info";
    }
    @GetMapping("password")
    private String password() {
        return "user/password";
    }

    /**
     * 主页与控制台
     */
    @GetMapping("index")
    private String index() {
        return "index/index";
    }
    @GetMapping("console")
    private String console() {
        return "index/console";
    }

    /**
     * 数据统计
     */
    @GetMapping("shopdata")
    private String shopData() {
        return "statistic/shopdata";
    }
    @GetMapping("orderdata")
    private String orderData() {
        return "statistic/orderdata";
    }
    @GetMapping("projectdata")
    private String projectData() {
        return "statistic/projectdata";
    }

    /**
     * 数据分析
     */
    @GetMapping("shopanalyse")
    private String shopAnalyse() {
        return "analysis/shopanalyse";
    }
    @GetMapping("orderanalyse")
    private String orderAnalyse() {
        return "analysis/orderanalyse";
    }
    @GetMapping("projectanalyse")
    private String projectAnalyse() {
        return "analysis/projectanalyse";
    }
    @GetMapping("processanalyse")
    private String processAnalyse() {
        return "analysis/processanalyse";
    }
    @GetMapping("users")
    private String users() {
        return "analysis/users";
    }
    @GetMapping("workUsers")
    private String workUsers(){

        return  "analysis/workusers";
    }




    /**
     * 员工信息详情
     */
    @GetMapping("employeeoverview")
    private String employeeOverview() {
        return "employee/employeeoverview";
    }
    @GetMapping("shopoperation")
    private String shopOperation() {
        return "employee/shopoperation";
    }
    @GetMapping("bussinessmanager")
    private String bussinessManager() {
        return "employee/bussinessmanager";
    }
    @GetMapping("uidesigner")
    private String UIDesigner() {
        return "employee/uidesigner";
    }
    @GetMapping("frontendengineer")
    private String frontendEngineer() {
        return "employee/frontendengineer";
    }
    @GetMapping("backendengineer")
    private String backendEngineer() {
        return "employee/backendengineer";
    }
    @GetMapping("testengineer")
    private String testEngineer() {
        return "employee/testengineer";
    }



    /**
     * 系统设置
     */
    @GetMapping("usersetting")
    private String userSetting() {
        return "system/usersetting";
    }
    @GetMapping("privilege")
    private String privilege() {
        return "system/privilege";
    }

    /**
     * 其他页面
     */
    @GetMapping("error")
    private String error() {
        return "common/error";
    }
    @GetMapping("building")
    private String building() {
        return "common/building";
    }
    /**
     * 弹出页面
     */

    @GetMapping("usersUpdate")
    private String userUpdate() {
        //
        return "analysis/usersUpdate";
    }
    @GetMapping("workusersupdate")
    private String workUsersUpdate(){
        return "analysis/workUsersUpdate";
    }
    @GetMapping("workusersadd")
    public String workUserUpdate(){
        return "analysis/workUsersAdd";
    }


    @GetMapping("recycleSite")
    public String recycleSite(){
        return "analysis/recycleSite";
    }



}
