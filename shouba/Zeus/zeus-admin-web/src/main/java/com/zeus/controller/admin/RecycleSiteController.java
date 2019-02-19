package com.zeus.controller.admin;


        import com.zeus.common.QueryResponseResult;
        import com.zeus.service.RecycleSiteService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;

        import java.util.Map;


/**
 * @Description 回收站点
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/recycleSite/page/")
public class RecycleSiteController {
    @Autowired
    private RecycleSiteService recycleSiteService;

    /**
     * @param []
     * @return com.zeus.common.Response
     * @methodName recycleSiteFandAll  查询出所有的回收站站点
     * @author wangdi
     * @date 2019/1/3
     */
    @GetMapping("recycleSitefandall/{page}/{size}")
    @ResponseBody
    private Map recycleSiteFandAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {

        Map response = recycleSiteService.recycleStieFandAll(page, size);

        return response;
    }
    /**
     *
     *
     * @methodName  recycleSiteDelete 删除站点
     * @author wangdi
     * @param [id]
     * @return java.util.Map
     * @date 2019/1/30
     */
    @GetMapping("recycleSiteDelete/{id}")
    @ResponseBody
    private Map recycleSiteDelete(@PathVariable("id") Long id) {

        Map map = recycleSiteService.recycleSiteDelete(id);

        return map;
    }

}
