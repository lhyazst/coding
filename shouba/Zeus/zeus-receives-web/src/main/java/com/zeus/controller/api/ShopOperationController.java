package com.zeus.controller.api;

import com.zeus.common.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 店铺运营控制器
 * @Author 元稹
 * @Date 18/12/2018 19:33
 * @Version V1.0
 */
@Controller
@RequestMapping("/api/shopoperation")
public class ShopOperationController {

    @GetMapping("test")
    @ResponseBody
    public Response test() {
        Map<String, Object> resMap = new HashMap<>(16);
        resMap.put("test", "adbcbchui789");
        Response response = new Response("登录成功", resMap);
        return response;
    }

}
