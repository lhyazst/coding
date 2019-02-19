package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.CommentsUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Description
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */

public interface CommentsUserMapper extends BaseMapper<CommentsUser> {

    CommentsUser selectcomment(@Param("userid") Long id,@Param("activityProductId") Long activityProductId);
    /**
     *
     *
     * @methodName  selectCUBfanAll  查询出用户和评论和厨余回收袋
     * @author wangdi
     * @param [id, activityProductId]
     * @return com.zeus.entity.CommentsUser
     * @date 2019/1/15
     */
    CommentsUser selectCUBfanAll(@Param("userid") Long userid, @Param("activityProductId") Long activityProductId);
   /**
    *
    *
    * @methodName  fandAllctiviAtyProductId  通过活动id查询出该活动参加评论的所有用户
    * @author wangdi
    * @param [activityProductId]
    * @return java.util.List<com.zeus.entity.CommentsUser>
    * @date 2019/1/21
    */
    List<CommentsUser> fanAllActivityProductId(Long activityProductId);

}