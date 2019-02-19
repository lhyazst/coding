package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;
import com.zeus.exception.CommonCode;
import com.zeus.service.GoodsParticularsService;
import com.zeus.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 商品详情
 *
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/goodsparticulars/page/")
public class GoodsParticularsController {
    @Autowired
    private GoodsParticularsService goodsParticularsService;

    /**
     *
     *
     * @methodName  goodsparticularsFandOne 查询出产品详情页
     * @author wangdi
     * @param []
     * @return com.zeus.common.Response
     * @date 2019/1/5
     */
    @GetMapping("goodsparticularsFandOne/{id}/{username}")
    @ResponseBody
    public QueryResponseResult goodsparticularsFandOne(@PathVariable("id")Long id,@PathVariable("username") String username){

        if(EmptyUtil.isEmpty(id)){
        return new QueryResponseResult(CommonCode.INVALID_PARAM,null);
        }
        QueryResponseResult response= goodsParticularsService.goodsParticularsFandOne(id,username);

                 return response;
    }

}
