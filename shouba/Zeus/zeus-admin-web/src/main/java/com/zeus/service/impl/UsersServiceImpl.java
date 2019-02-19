package com.zeus.service.impl;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.dao.UsersMapper;

import com.zeus.entity.Address;
import com.zeus.entity.Users;
import com.zeus.exception.CommonCode;
import com.zeus.service.UsersService;

import com.zeus.utils.DateUtils;
import com.zeus.utils.EmptyUtil;
import com.zeus.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;


/**
 * @Description
 * @author:wangdi
 * @date:2019/1/13
 * @ver:1.0
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

   /**
    *
    *
    * @methodName  selectFanAll  查询出所有的用户信息
    * @author wangdi
    * @param [page, size]
    * @return com.zeus.common.QueryResponseResult
    * @date 2019/1/23
    */
    @Override
    public Map<String, Object> selectFanAll(Integer page,Integer size) {
        if (EmptyUtil.isEmpty(page) || EmptyUtil.isEmpty(size)) {
            Map map = new HashMap<>();
            map.put("code", Result.FALL_CODE);
            map.put("msg","");
            return map;
        }

        //分页参数
        if(page <=0){
            page = 1;
        }
        //page = page -1;
        if(size<=0){
            size = 10;
        }
        PageHelper.startPage(page, size);
        List<Users> list = usersMapper.userAddressfandAll();
        List list1 = new ArrayList();
        for(Users users : list){
            Address address = users.getAddress();
            users.setAccount(address.getCommunity());
              list1.add(users);
        }
        PageInfo<Users> pageInfo = new PageInfo<>(list1);
       Map<String,Object> map = new HashMap<>();
        map.put("code", Result.SUCCESS_CODE);
        map.put("msg","");
        map.put("data",pageInfo.getList());
        map.put("count",pageInfo.getTotal());
        return map;

    }
   /**
    *
    *
    * @methodName  deleteUserId 删除
    * @author wangdi
    * @param [id]
    * @return java.util.Map
    * @date 2019/1/25
    */
    @Override
    public Map deleteUserId(Long id) {
        if (EmptyUtil.isEmpty(id)) {
            Map map = new HashMap<>();
            map.put("code", Result.FALL_CODE);
            map.put("msg","");
            return map;
        }
        usersMapper.deleteByPrimaryKey(id);

       Map map = new HashMap<>();
        map.put("code", Result.SUCCESS_CODE);
        map.put("msg","");
            return map;
    }
   /**
    *
    *
    * @methodName  updateId  跟据id查询出唯一对象
    * @author wangdi
    * @param [id]
    * @return java.util.Map
    * @date 2019/1/25
    */
    @Override
    public Map fandOne(Long id)  {
        if (EmptyUtil.isEmpty(id)) {
            Map map = new HashMap<>();
            map.put("code", Result.FALL_CODE);
            map.put("msg","");
            return map;
        }

     Users users =  usersMapper.fandOne(id);
            Address address = users.getAddress();
            users.setAccount(address.getCommunity());
        Map map = new HashMap<>();
        map.put("code", Result.SUCCESS_CODE);
        map.put("msg","");
        map.put("data",users);
        return map;


    }
    /**
     *
     *
     * @methodName  updateId  跟据id查询出唯一对象
     * @author xiaoxuanfeng
     * @param [id]
     * @return java.util.Map
     * @date 2019/2/16
     */
    @Override
    public Map updateByPrimaryKeySelective(Users users) {
        if (EmptyUtil.isEmpty(users)) {
            Map map = new HashMap<>();
            map.put("code", Result.FALL_CODE);
            map.put("msg","");
            return map;
        }
        int i=usersMapper.updateByPrimaryKeySelective(users);
        Map map = new HashMap<>();
        map.put("code", Result.SUCCESS_CODE);
        map.put("msg","");
        return null;
    }
}
