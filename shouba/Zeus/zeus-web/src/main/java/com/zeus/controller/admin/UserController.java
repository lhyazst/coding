package com.zeus.controller.admin;

import com.zeus.common.Response;
import com.zeus.service.IUserService;
import com.zeus.utils.VercodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 用户控制器
 * @Author 元稹
 * @Date 18/12/2018 17:18
 * @Version V1.0
 */
@Controller
@RequestMapping("/admin/user/")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("login")
    @ResponseBody
    private Response<Map<String, Object>> login(HttpServletRequest request) {
        Response response = new Response();

        // 验证密码是否一致
        Map<String, Object> resMap = new HashMap<>(16);
        resMap.put("access_token", "c262e61cd13ad99fc650e6908c7e5e65b63d2f32185ecfed6b801ee3fbdd5c0a");
        response.setMsg("登录成功");
        response.setData(resMap);
        System.out.println(response.toString());
        return response;
    }

}
