package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.ActivityUser;
import com.zeus.entity.Users;

import java.util.List;
/**
 * 
 * 
 * @methodName  参加活动用户 
 * @author wangdi
 * @param  
 * @return  
 * @date 2019/1/10 
 */  
public interface ActivityUserMapper extends BaseMapper<ActivityUser>{

    List<Users> usfandAll(Long id);
}