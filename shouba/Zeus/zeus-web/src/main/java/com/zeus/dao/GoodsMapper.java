package com.zeus.dao;

        import com.zeus.dao.base.BaseMapper;
        import com.zeus.entity.Goods;

        import java.util.List;

/**
 * @Description 商品表操作接口
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
public interface GoodsMapper extends BaseMapper<Goods> {


    /**
     * @param [type]
     * @return java.util.List<com.zeus.entity.Goods>
     * @methodName fandAllConvert  查询兑换的商品类型
     * @author wangdi
     * @date 2019/1/15
     */
    List<Goods> fandAllConvert(String type);

    /**
     * @param [type]
     * @return java.util.List<com.zeus.entity.Goods>
     * @methodName fandAllDonate  查询捐献的商品类型
     * @author wangdi
     * @date 2019/1/15
     */
    List<Goods> fandAllDonate(String type);
}