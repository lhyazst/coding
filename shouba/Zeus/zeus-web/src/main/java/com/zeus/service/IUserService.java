package com.zeus.service;

import com.zeus.entity.User;

/**
 * @Description 用户操作服务层
 * @Author 元稹
 * @Date 16/12/2018 21:56
 * @Version V1.0
 */
public interface IUserService {
   /**
    * 
    * 
    * @methodName  find 
    * @author wangdi
    * @param [id] 
    * @return com.zeus.entity.User 
    * @date 2019/1/10 
    */  
    User find(Long id);

}
