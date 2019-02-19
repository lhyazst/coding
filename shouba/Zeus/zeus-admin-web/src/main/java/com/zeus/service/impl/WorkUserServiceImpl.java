package com.zeus.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeus.dao.RoleMapper;
import com.zeus.dao.WorkUsersMapper;
import com.zeus.dao.WorkUsersRoleMapper;
import com.zeus.entity.Role;
import com.zeus.entity.WorkUsers;
import com.zeus.entity.WorkUsersRoleKey;
import com.zeus.service.WorkUserService;
import com.zeus.utils.EmptyUtil;
import com.zeus.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 登陆校验
 * @author:wangdi
 * @date:2019/1/13
 * @ver:1.0
 */
@Service("userService")
@Transactional(rollbackFor = {Exception.class})
public class WorkUserServiceImpl implements WorkUserService {
    @Autowired
    private WorkUsersMapper workUsersMapper;
    @Autowired
      private RoleMapper roleMapper;
    @Autowired
    private WorkUsersRoleMapper workUsersRoleMapper;
    /**
     * @param [phone]
     * @return org.springframework.security.core.userdetails.UserDetails
     * @methodName loadUserByUsername 登陆
     * @author wangdi
     * @date 2019/1/24
     */
    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        WorkUsers workUsers = null;

        try {
            workUsers = workUsersMapper.findByUsername(phone);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //处理自己的用户对象封装成UserDetails
        User user = new User(workUsers.getPhone(), "{noop}" + workUsers.getPassword(), workUsers.getStatus() == 0 ? false : true, true, true, true, getAuthority(workUsers.getRoles()));

        return user;
    }

    /**
     * @param [roles]
     * @return java.util.List<org.springframework.security.core.authority.SimpleGrantedAuthority>
     * @methodName getAuthority  作用就是返回一个List集合，集合中装入的是角色描述
     * @author wangdi
     * @date 2019/1/24
     */
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRolename()));
        }
        return list;
    }


    @Override
    public WorkUsers IsLogin(String username, String password) {
        return workUsersMapper.IsLogin(username,password);
    }

    /**
     * @param [page, size]
     * @return java.util.Map
     * @methodName selectFanAll 查询出所有的工作人员
     * @author wangdi
     * @date 2019/1/28
     */
    @Override
    public Map selectFanAll(Integer page, Integer size) {
        if (EmptyUtil.isEmpty(page) || EmptyUtil.isEmpty(size)) {
            Map map = new HashMap<>();
            map.put("code", Result.FALL_CODE);
            map.put("msg", "");
            return map;
        }
        //分页参数
        if (page <= 0) {
            page = 1;
        }
        //page = page -1;
        if (size <= 0) {
            size = 10;
        }

        PageHelper.startPage(page, size);
        List<WorkUsers> userlist = workUsersMapper.fandAll();
        for (WorkUsers workUsers : userlist) {
          List<Role> roles =  roleMapper.selectRole(workUsers.getId());
           workUsers.setRoles(roles);
        }
        PageInfo<WorkUsers> pageInfo = new PageInfo<>(userlist);

        Map<String, Object> map = new HashMap<>();
        map.put("code", Result.SUCCESS_CODE);
        map.put("msg", "");
        map.put("data", pageInfo.getList());
        map.put("count", pageInfo.getTotal());

        return map;
    }

    /**
     * @param [id]
     * @return java.util.Map
     * @methodName deleteWorkUsersFandOne 更具工作人员id删除该用户
     * @author wangdi
     * @date 2019/1/28
     */
    @Override
    public Map deleteWorkUsersFandOne(Long id) {
        if (EmptyUtil.isEmpty(id)) {
            Map map = new HashMap<>();
            map.put("code", Result.FALL_CODE);
            map.put("msg", "");
            return map;
        }
        workUsersMapper.deleteByPrimaryKey(id);
        Map map = new HashMap<>();
        map.put("code", Result.SUCCESS_CODE);
        map.put("msg", "");
        return map;
    }
   /**
    *
    *
    * @methodName  addWorkUser  添加用户
    * @author wangdi
    * @param [workUsers]
    * @return java.util.Map
    * @date 2019/1/28
    */
    @Override
    public Map addWorkUser(WorkUsers workUsers) {
        if (EmptyUtil.isEmpty(workUsers)) {
            Map map = new HashMap<>();
            map.put("code", Result.FALL_CODE);
            map.put("msg", "参数异常");
            return map;
        }
        String username = workUsers.getUsername();

        WorkUsers workUsers1 = workUsersMapper.selectuserName(username);
        if(workUsers1 != null){
            Map map = new HashMap<>();
            map.put("code", Result.USERNAME_FALL);
            map.put("msg", "用户名已存在");
            return map;
        }
        String roleName = workUsers.getRoleName();
        Role role =  roleMapper.selectRoleName(roleName);
        //将用户状态改为1
        workUsers.setStatus(1);
        //添加用户
        Long insert = workUsersMapper.insertuser(workUsers);
        Long id = workUsers.getId();
        WorkUsersRoleKey workUsersRoleKey = new WorkUsersRoleKey();
        workUsersRoleKey.setRoleid(role.getId());
        workUsersRoleKey.setUserid(id);
        //添加角色
        workUsersRoleMapper.insert(workUsersRoleKey);
        Map map = new HashMap<>();
        map.put("code", Result.SUCCESS_CODE);
        map.put("msg", "");
        return map;
    }
     /**
      *
      *
      * @methodName  fandOne 跟据id查询对象
      * @author wangdi
      * @param [id]
      * @return java.util.Map
      * @date 2019/1/29
      */
    @Override
    public Map fandOne(Long id)  {
        if (EmptyUtil.isEmpty(id)) {
            Map map = new HashMap<>();
            map.put("code", Result.FALL_CODE);
            map.put("msg", "参数异常");
            return map;
        }
        WorkUsers workUsers = workUsersMapper.fandOne(id);
        WorkUsers byUsername = null;
        try {
            byUsername = workUsersMapper.findByUsername(workUsers.getPhone());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map map = new HashMap<>();
        map.put("code", Result.SUCCESS_CODE);
        map.put("msg", "");
        map.put("data",byUsername);
        return map;
    }
   /**
    *
    *
    * @methodName  updateUsers 更改用户信息
    * @author wangdi
    * @param [workUsers]
    * @return java.util.Map
    * @date 2019/1/29
    */
    @Override
    public Map updateUsers(WorkUsers workUsers) {
        if (EmptyUtil.isEmpty(workUsers)) {
            Map map = new HashMap<>();
            map.put("code", Result.FALL_CODE);
            map.put("msg", "参数异常");
            return map;
        }
        String roleName = workUsers.getRoleName();
        Role role =  roleMapper.selectRoleName(roleName);
        workUsersMapper.updateByPrimaryKey(workUsers);
        workUsersRoleMapper.update(workUsers.getId(),role.getId());
        Map map = new HashMap<>();
        map.put("code", Result.SUCCESS_CODE);
        map.put("msg", "更新成功");
        return map;
    }
}
