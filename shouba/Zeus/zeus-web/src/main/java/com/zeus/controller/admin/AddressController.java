package com.zeus.controller.admin;



import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.entity.Address;
import com.zeus.exception.CommonCode;
import com.zeus.service.AddressService;
import com.zeus.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



/**
 * @Description 地址
 *
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/address/page/")
public class AddressController {
    @Autowired
    private AddressService addressService;

    /**
     * @param
     * @return com.zeus.common.Response  用户添加地址
     * @methodName GoodsFandAll
     * @author wangdi
     * @date 2019/1/3
     */
    @PostMapping("addressadd/{username}")
    @ResponseBody
    private QueryResponseResult addressAdd(@RequestBody Address address,@PathVariable("username") String username) {

        if (EmptyUtil.isEmpty(address) || EmptyUtil.isEmpty(username)) {
           return new QueryResponseResult(CommonCode.INVALID_PARAM,null);
        }

       QueryResponseResult aBoolean = addressService.addressAdd(address,username);

        return aBoolean;
    }
   /**
    *
    *
    * @methodName  addressfandAll  查询出所有的地址
    * @author wangdi
    * @param []
    * @return com.zeus.common.Response
    * @date 2019/1/21
    */
    @GetMapping("addressfandall")
    @ResponseBody
    private Response addressfandAll() {


        Response addressBoolean = addressService.addressFandAll();
        return addressBoolean;
    }


}
