package com.zeus.controller.admin;


        import com.zeus.common.QueryResponseResult;
        import com.zeus.common.Response;
        import com.zeus.entity.Course;
        import com.zeus.service.CarouselService;
        import com.zeus.service.CourseService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;

        import java.util.List;


/**
 * @Description 轮播图
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/carousel/page/")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    /**
     * @param []
     * @return com.zeus.common.QueryResponseResult
     * @methodName selectCarousl 查询出轮播图
     * @author wangdi
     * @date 2019/1/22
     */
    @GetMapping("carouselfandAll")
    @ResponseBody
    public QueryResponseResult selectCarousl() {

        QueryResponseResult queryResponseResult = carouselService.fandAll();

        return queryResponseResult;
    }


}
