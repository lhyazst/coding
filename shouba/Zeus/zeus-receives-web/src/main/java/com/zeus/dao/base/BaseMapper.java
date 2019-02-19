package com.zeus.dao.base;

import com.zeus.entity.Bags;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Description Mybatis Generator生成的通用接口
 * @Author 元稹
 * @Date 17/12/2018 16:39
 * @Version V1.0
 */
public interface BaseMapper<T> {

    /**
     * @Description 根据主键ID删除表信息
     * @Author 元稹
     * @Date 17/12/2018 16:40
     * @Param [id]
     * @Return int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @Description 插入一条完整记录
     * @Author 元稹
     * @Date 17/12/2018 16:41
     * @Param [t]
     * @Return int
     */
    int insert(T t);

    /**
     * @Description 插入一条选择性记录
     * @Author 元稹
     * @Date 17/12/2018 16:41
     * @Param [t]
     * @Return int
     */
    int insertSelective(T t);

    /**
     * @Description 根据主键ID查询表信息
     * @Author 元稹
     * @Date 17/12/2018 16:40
     * @Param [id]
     * @Return [t]
     */
    T selectByPrimaryKey(Long id);

    /**
     * @Description 根据主键ID选择性更新表信息
     * @Author 元稹
     * @Date 17/12/2018 16:41
     * @Param [t]
     * @Return int
     */
    int updateByPrimaryKeySelective(T t);

    /**
     * @Description 根据主键ID更新表信息
     * @Author 元稹
     * @Date 17/12/2018 16:41
     * @Param [t]
     * @Return int
     */
    int updateByPrimaryKey(T t);

    /**
     *
     *
     * @methodName  查询表的所有信息
     * @author wangdi
     * @param []
     * @return java.util.List<T>
     * @date 2019/1/3
     */
    List<T> fandAll();
     /**
      * 
      * 
      * @methodName  selectByFandAll 
      * @author wangdi
      * @param [id] 
      * @return java.util.List<T> 
      * @date 2019/1/10 
      */  
    List<T> selectByFandAll(Long id);

    /**
     *
     *
     * @methodName  状态更新回收员id,更新日期
     * @author wangdi
     * @param []
     * @return java.util.List<T>
     * @date 2019/1/3
     */
    void updatestatus(@Param("id") Long id,@Param("userid") Long userid,@Param("date") Date date);



}
