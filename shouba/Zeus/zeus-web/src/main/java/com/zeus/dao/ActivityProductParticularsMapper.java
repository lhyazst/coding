package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.ActivityProductParticulars;
import com.zeus.entity.CourseParticulars;

import java.util.List;

/**
 * @Description 活动详情表操作接口
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
public interface ActivityProductParticularsMapper extends BaseMapper<ActivityProductParticulars> {

    /**
     *
     *
     * @methodName  selectActivityList  查出该活动的所有详情图片和介绍
     * @author wangdi
     * @param [activityProductId]
     * @return java.util.List<com.zeus.entity.ActivityProductParticulars>
     * @date 2019/1/21
     */
    List<ActivityProductParticulars> selectActivityList(Long activityProductId);
}